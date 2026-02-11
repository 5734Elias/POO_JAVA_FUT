package com.seuprojeto.futebol.domain.events;

import com.seuprojeto.futebol.domain.entities.EstadoPartida;
import com.seuprojeto.futebol.domain.valueobjects.Lado;

// Evento: gol.
public class Gol implements EventoDeJogo {

    private final String autor;
    private final Lado lado;

    public Gol(String autor, Lado lado) {
        this.autor = autor;
        this.lado = lado;
    }

    @Override
    public void aplicar(EstadoPartida estado) {
        estado.registrarGol(autor, lado);
    }
}
