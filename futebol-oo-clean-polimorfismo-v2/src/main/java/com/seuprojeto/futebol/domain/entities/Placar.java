package com.seuprojeto.futebol.domain.entities;

// Placar simples (mandante x visitante).
public class Placar {

    private int golsMandante;
    private int golsVisitante;

    public void golMandante() {
        golsMandante++;
    }

    public void golVisitante() {
        golsVisitante++;
    }

    public int getGolsMandante() {
        return golsMandante;
    }

    public int getGolsVisitante() {
        return golsVisitante;
    }

    @Override
    public String toString() {
        return golsMandante + " x " + golsVisitante;
    }
}
