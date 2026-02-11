package com.seuprojeto.futebol.domain.events;

import com.seuprojeto.futebol.domain.entities.EstadoPartida;

// Evento: finalização (incrementa estatística e registra).
public class Finalizacao implements EventoDeJogo {

    private final String autor;

    public Finalizacao(String autor) {
        this.autor = autor;
    }

    @Override
    public void aplicar(EstadoPartida estado) {
        estado.registrarFinalizacao(autor);
    }
}
