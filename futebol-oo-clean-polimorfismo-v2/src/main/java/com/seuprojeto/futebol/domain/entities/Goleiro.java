package com.seuprojeto.futebol.domain.entities;

import com.seuprojeto.futebol.domain.events.*;
import com.seuprojeto.futebol.domain.valueobjects.PartidaContexto;
import com.seuprojeto.futebol.infrastructure.random.RandomProvider;

import java.util.ArrayList;
import java.util.List;

// Goleiro: às vezes registra uma defesa marcante.
public class Goleiro extends Jogador {

    private final RandomProvider random;

    public Goleiro(String nome, int camisa, double salario, RandomProvider random) {
        super(nome, camisa, salario);
        this.random = random;
    }

    @Override
    public List<EventoDeJogo> executarAcao(PartidaContexto ctx) {
        List<EventoDeJogo> eventos = new ArrayList<>();

        int chance = random.nextInt(100);

        // 35% de chance de defesa
        if (chance < 35) {
            eventos.add(new Defesa(getNome()));
        } else {
            eventos.add(new EventoLog("🧤 " + getNome() + " atento no gol (chance=" + chance + ")"));
        }

        return eventos;
    }
}
