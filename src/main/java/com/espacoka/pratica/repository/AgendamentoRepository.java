package com.espacoka.pratica.repository;

import com.espacoka.pratica.model.Agendamento;
import com.espacoka.pratica.model.Profissional;
import com.espacoka.pratica.model.StatusAgendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // 🔹 Para a Regra de Negócio: Verifica se o profissional já tem cliente nesse horário
    boolean existsByProfissionalAndDataHora(Profissional profissional, LocalDateTime dataHora);

    // 🤖 Para o Robô: Busca agendamentos PENDENTES que já passaram do horário (atrasados)
    List<Agendamento> findByStatusAndDataHoraBefore(StatusAgendamento status, LocalDateTime limite);
}