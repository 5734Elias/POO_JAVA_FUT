package com.seuprojeto.futebol.domain.valueobjects;

import com.seuprojeto.futebol.domain.entities.Partida;
import com.seuprojeto.futebol.domain.entities.Time;

// Contexto passado para o jogador agir na rodada.
public class PartidaContexto {

    private final Partida partida;
    private final Time timeAtual;
    private final Lado ladoAtual;

    public PartidaContexto(Partida partida, Time timeAtual, Lado ladoAtual) {
        this.partida = partida;
        this.timeAtual = timeAtual;
        this.ladoAtual = ladoAtual;
    }

    public Partida getPartida() {
        return partida;
    }

    public Time getTimeAtual() {
        return timeAtual;
    }

    public Lado getLadoAtual() {
        return ladoAtual;
    }
}
