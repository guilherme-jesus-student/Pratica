package com.espacoka.pratica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "clientes")
public class Cliente extends Pessoa {

    private LocalDate dataNascimento;

    public Cliente() {
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}