    package com.espacoka.pratica.controller;

    import com.espacoka.pratica.dto.ClienteRequestDTO;
    import com.espacoka.pratica.dto.ClienteResponseDTO;
    import com.espacoka.pratica.service.ClienteService;
    import jakarta.validation.Valid;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/clientes")
    public class ClienteController {

        private final ClienteService service;

        public ClienteController(ClienteService service) {
            this.service = service;
        }

        // 🔹 Criar cliente
        @PostMapping
        public ResponseEntity<ClienteResponseDTO> criar(@Valid @RequestBody ClienteRequestDTO dto) {
            ClienteResponseDTO cliente = service.criar(dto);
            return ResponseEntity.status(201).body(cliente);
        }

        // 🔹 Buscar por ID
        @GetMapping("/{id}")
        public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Long id) {
            return ResponseEntity.ok(service.buscarPorId(id));
        }

        // 🔹 Listar com paginação
        @GetMapping
        public ResponseEntity<Page<ClienteResponseDTO>> listar(Pageable pageable) {
            return ResponseEntity.ok(service.listarPaginado(pageable));
        }

        // 🔹 Buscar por email
        @GetMapping("/email")
        public ResponseEntity<ClienteResponseDTO> buscarPorEmail(@RequestParam String email) {
            return ResponseEntity.ok(service.buscarPorEmail(email));
        }

        // 🔹 Buscar por nome
        @GetMapping("/nome")
        public ResponseEntity<?> buscarPorNome(@RequestParam String nome) {
            return ResponseEntity.ok(service.buscarPorNome(nome));
        }

        // 🔹 Verificar desconto
        @GetMapping("/{id}/desconto")
        public ResponseEntity<Boolean> verificarDesconto(@PathVariable Long id) {
            return ResponseEntity.ok(service.temDescontoAniversarioPorId(id));
        }

        // 🔹 Deletar cliente
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletar(@PathVariable Long id) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }
    }