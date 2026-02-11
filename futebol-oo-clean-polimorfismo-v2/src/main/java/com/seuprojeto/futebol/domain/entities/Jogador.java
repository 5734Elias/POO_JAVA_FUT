package com.seuprojeto.futebol.domain.entities;

import com.seuprojeto.futebol.domain.events.EventoDeJogo;
import com.seuprojeto.futebol.domain.valueobjects.PartidaContexto;

import java.util.List;

// Jogador abstrato: obriga todos os tipos a retornarem eventos.
public abstract class Jogador {

    private final String nome;
    private final int camisa;
    private double salario;

    public Jogador(String nome, int camisa, double salario) {
        this.nome = nome;
        this.camisa = camisa;
        this.salario = salario;
    }

    // Polimorfismo: cada filho decide como agir e quais eventos gerar.
    public abstract List<EventoDeJogo> executarAcao(PartidaContexto ctx);

    public String getNome() {
        return nome;
    }

    public int getCamisa() {
        return camisa;
    }

    public double getSalario() {
        return salario;
    }

    // Encapsulamento com validação simples.
    public void setSalario(double salario) {
        if (salario > 0) this.salario = salario;
    }
}
