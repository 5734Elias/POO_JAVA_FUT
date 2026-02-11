package com.seuprojeto.futebol.domain.events;

import com.seuprojeto.futebol.domain.entities.EstadoPartida;

// Evento: cartão amarelo.
public class CartaoAmarelo implements EventoDeJogo {

    private final String jogador;

    public CartaoAmarelo(String jogador) {
        this.jogador = jogador;
    }

    @Override
    public void aplicar(EstadoPartida estado) {
        estado.registrarAmarelo(jogador);
    }
}
