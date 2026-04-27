package com.espacoka.pratica.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
}