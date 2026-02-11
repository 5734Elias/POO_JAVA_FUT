package com.seuprojeto.futebol.domain.events;

import com.seuprojeto.futebol.domain.entities.EstadoPartida;

// Evento: desarme.
public class Desarme implements EventoDeJogo {

    private final String zagueiro;

    public Desarme(String zagueiro) {
        this.zagueiro = zagueiro;
    }

    @Override
    public void aplicar(EstadoPartida estado) {
        estado.registrarDesarme(zagueiro);
    }
}
