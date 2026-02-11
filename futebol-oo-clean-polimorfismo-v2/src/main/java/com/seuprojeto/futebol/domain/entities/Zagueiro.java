package com.seuprojeto.futebol.domain.entities;

import com.seuprojeto.futebol.domain.events.*;
import com.seuprojeto.futebol.domain.valueobjects.PartidaContexto;
import com.seuprojeto.futebol.infrastructure.random.RandomProvider;

import java.util.ArrayList;
import java.util.List;

// Zagueiro: pode desarmar e, raramente, tomar amarelo.
public class Zagueiro extends Jogador {

    private final RandomProvider random;

    public Zagueiro(String nome, int camisa, double salario, RandomProvider random) {
        super(nome, camisa, salario);
        this.random = random;
    }

    @Override
    public List<EventoDeJogo> executarAcao(PartidaContexto ctx) {
        List<EventoDeJogo> eventos = new ArrayList<>();

        int chance = random.nextInt(100);

        // 40% desarme
        if (chance < 40) {
            eventos.add(new Desarme(getNome()));
        } else {
            eventos.add(new EventoLog("🧱 " + getNome() + " fechou a linha (chance=" + chance + ")"));
        }

        // 8% amarelo
        int chanceCartao = random.nextInt(100);
        if (chanceCartao > 91) {
            eventos.add(new CartaoAmarelo(getNome()));
        }

        return eventos;
    }
}
