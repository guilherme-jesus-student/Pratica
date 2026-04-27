package com.espacoka.pratica.service;

import com.espacoka.pratica.dto.ClienteRequestDTO;
import com.espacoka.pratica.dto.ClienteResponseDTO;
import com.espacoka.pratica.exception.RegraNegocioException;
import com.espacoka.pratica.model.Cliente;
import com.espacoka.pratica.repository.ClienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    // 🔹 Criar cliente
    public ClienteResponseDTO criar(ClienteRequestDTO dto) {

        if (repository.existsByEmail(dto.getEmail())) {
            throw new RegraNegocioException("Email já cadastrado");
        }

        Cliente cliente = toEntity(dto);
        Cliente salvo = repository.save(cliente);

        return toResponseDTO(salvo);
    }

    // 🔹 Buscar por ID
    public ClienteResponseDTO buscarPorId(Long id) {
        Cliente cliente = buscarOuFalhar(id);
        return toResponseDTO(cliente);
    }

    // 🔹 Listar com paginação
    public Page<ClienteResponseDTO> listarPaginado(Pageable pageable) {
        return repository.findAll(pageable)
                .map(this::toResponseDTO);
    }

    // 🔹 Buscar por email
    public ClienteResponseDTO buscarPorEmail(String email) {
        Cliente cliente = repository.findByEmail(email)
                .orElseThrow(() -> new RegraNegocioException("Cliente não encontrado"));

        return toResponseDTO(cliente);
    }

    // 🔹 Buscar por nome
    public List<ClienteResponseDTO> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // 🔹 Deletar
    public void deletar(Long id) {
        Cliente cliente = buscarOuFalhar(id);
        repository.delete(cliente);
    }

    // 🎁 Regra: desconto no mês do aniversário
    public boolean temDescontoAniversarioPorId(Long id) {
        Cliente cliente = buscarOuFalhar(id);
        return temDescontoAniversario(cliente);
    }

    // ===============================
    // 🔥 MÉTODOS PRIVADOS
    // ===============================

    private Cliente buscarOuFalhar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Cliente não encontrado"));
    }

    private boolean temDescontoAniversario(Cliente cliente) {
        if (cliente.getDataNascimento() == null) {
            return false;
        }

        return cliente.getDataNascimento().getMonthValue() ==
                LocalDate.now().getMonthValue();
    }

    private Cliente toEntity(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEmail(dto.getEmail());
        cliente.setDataNascimento(dto.getDataNascimento());
        return cliente;
    }

    private ClienteResponseDTO toResponseDTO(Cliente cliente) {
        return ClienteResponseDTO.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .email(cliente.getEmail())
                .telefone(cliente.getTelefone())
                .dataNascimento(cliente.getDataNascimento())
                .build();
    }
}