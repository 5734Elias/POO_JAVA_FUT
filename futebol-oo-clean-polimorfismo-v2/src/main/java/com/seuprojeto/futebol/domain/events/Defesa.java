package com.seuprojeto.futebol.domain.events;

import com.seuprojeto.futebol.domain.entities.EstadoPartida;

// Evento: defesa.
public class Defesa implements EventoDeJogo {

    private final String goleiro;

    public Defesa(String goleiro) {
        this.goleiro = goleiro;
    }

    @Override
    public void aplicar(EstadoPartida estado) {
        estado.registrarDefesa(goleiro);
    }
}
