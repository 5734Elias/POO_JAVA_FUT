package com.seuprojeto.futebol.domain.entities;

import com.seuprojeto.futebol.domain.events.*;
import com.seuprojeto.futebol.domain.valueobjects.PartidaContexto;
import com.seuprojeto.futebol.infrastructure.random.RandomProvider;

import java.util.ArrayList;
import java.util.List;

// Atacante: gera finalizações e, às vezes, gol.
public class Atacante extends Jogador {

    private final RandomProvider random;

    public Atacante(String nome, int camisa, double salario, RandomProvider random) {
        super(nome, camisa, salario);
        this.random = random;
    }

    @Override
    public List<EventoDeJogo> executarAcao(PartidaContexto ctx) {
        List<EventoDeJogo> eventos = new ArrayList<>();

        eventos.add(new EventoLog("➡️ " + ctx.getTimeAtual().getNome() + " no ataque!"));
        eventos.add(new Finalizacao(getNome()));

        int chance = random.nextInt(100);

        // 30% de chance de gol (exemplo didático)
        if (chance < 30) {
            eventos.add(new Gol(getNome(), ctx.getLadoAtual()));
        } else {
            eventos.add(new EventoLog("❌ A bola não entrou (chance=" + chance + ")"));
        }

        return eventos;
    }
}
