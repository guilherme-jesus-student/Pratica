package com.espacoka.pratica.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "agendamentos",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"profissional_id", "dataHora"})
        }
)
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔹 Cliente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    // 🔹 Profissional
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profissional_id", nullable = false)
    private Profissional profissional;

    // 🔹 Data e hora
    @Column(nullable = false)
    private LocalDateTime dataHora;

    public Agendamento() {}

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}