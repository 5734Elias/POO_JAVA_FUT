package com.seuprojeto.futebol.domain.entities;

// Entidade "Partida": guarda os times e o estado do jogo.
public class Partida {

    private final Time mandante;
    private final Time visitante;
    private final EstadoPartida estado = new EstadoPartida();

    public Partida(Time mandante, Time visitante) {
        this.mandante = mandante;
        this.visitante = visitante;
    }

    public Time getMandante() {
        return mandante;
    }

    public Time getVisitante() {
        return visitante;
    }

    public EstadoPartida getEstado() {
        return estado;
    }
}
