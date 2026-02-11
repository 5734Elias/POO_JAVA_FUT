package com.seuprojeto.futebol.domain.events;

import com.seuprojeto.futebol.domain.entities.EstadoPartida;

// Evento de jogo: sabe se aplicar no estado (placar, log, estatísticas).
public interface EventoDeJogo {
    void aplicar(EstadoPartida estado);
}
