package com.espacoka.pratica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 🔴 Regra de negócio (409)
    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<?> handleRegraNegocio(RegraNegocioException ex) {

        Map<String, Object> erro = new HashMap<>();
        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", HttpStatus.CONFLICT.value());
        erro.put("error", "Regra de negócio");
        erro.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    // 🟡 Validação (400)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidacao(MethodArgumentNotValidException ex) {

        Map<String, String> erros = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(e -> erros.put(e.getField(), e.getDefaultMessage()));

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("timestamp", LocalDateTime.now());
        resposta.put("status", HttpStatus.BAD_REQUEST.value());
        resposta.put("error", "Erro de validação");
        resposta.put("messages", erros);

        return ResponseEntity.badRequest().body(resposta);
    }

    // 🔴 Genérico (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeral(Exception ex) {

        Map<String, Object> erro = new HashMap<>();
        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        erro.put("error", "Erro interno");
        erro.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }
}