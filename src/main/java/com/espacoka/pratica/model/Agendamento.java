package com.espacoka.pratica.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "agendamentos",
        uniqueConstraints = {
                // POO/Banco de Dados: Garante que um profissional não tenha dois agendamentos no mesmo horário
                @UniqueConstraint(columnNames = {"profissional_id", "dataHora"})
        }
)
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento ManyToOne: Muitos agendamentos para um único cliente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    // Relacionamento ManyToOne: Muitos agendamentos para um profissional (cabeleireira, manicure, etc)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profissional_id", nullable = false)
    private Profissional profissional;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    // 🔥 NOVO CAMPO: Essencial para a regra de negócio de cancelamento automático
    @Enumerated(EnumType.STRING) // Salva o nome do status no banco (ex: "PENDENTE") em vez de números
    @Column(nullable = false)
    private StatusAgendamento status;

    public Agendamento() {}

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }
}