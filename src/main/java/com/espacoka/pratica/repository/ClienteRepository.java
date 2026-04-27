package com.espacoka.pratica.repository;

import com.espacoka.pratica.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByEmail(String email);

    List<Cliente> findByNomeContainingIgnoreCase(String nome);

    boolean existsByEmail(String email);
}