package com.seuprojeto.futebol.domain.entities;

// Técnico do time.
public class Tecnico {

    private final String nome;
    private final String esquema;

    public Tecnico(String nome, String esquema) {
        this.nome = nome;
        this.esquema = esquema;
    }

    public void orientar() {
        System.out.println("👔 Técnico " + nome + " orientando no esquema " + esquema);
    }
}
