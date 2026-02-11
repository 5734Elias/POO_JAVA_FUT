package com.seuprojeto.futebol.domain.events;

import com.seuprojeto.futebol.domain.entities.EstadoPartida;

// Evento genérico só para registrar texto.
public class EventoLog implements EventoDeJogo {

    private final String mensagem;

    public EventoLog(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public void aplicar(EstadoPartida estado) {
        estado.registrar(mensagem);
    }
}
