package com.seuprojeto.futebol.domain.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Um time "tem" técnico e um elenco (composição).
public class Time {

    private final String nome;
    private final Tecnico tecnico;
    private final List<Jogador> elenco = new ArrayList<>();

    public Time(String nome, Tecnico tecnico) {
        this.nome = nome;
        this.tecnico = tecnico;
    }

    public String getNome() {
        return nome;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void adicionarJogador(Jogador jogador) {
        elenco.add(jogador);
    }

    public List<Jogador> getElenco() {
        return Collections.unmodifiableList(elenco);
    }
}
