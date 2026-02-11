package com.seuprojeto.futebol.domain.entities;

// Estatísticas agregadas por jogador (relatório final).
public class EstatisticasJogador {

    private int gols;
    private int defesas;
    private int desarmes;
    private int amarelos;
    private int finalizacoes;

    public void addGol() { gols++; }
    public void addDefesa() { defesas++; }
    public void addDesarme() { desarmes++; }
    public void addAmarelo() { amarelos++; }
    public void addFinalizacao() { finalizacoes++; }

    public int getGols() { return gols; }
    public int getDefesas() { return defesas; }
    public int getDesarmes() { return desarmes; }
    public int getAmarelos() { return amarelos; }
    public int getFinalizacoes() { return finalizacoes; }

    @Override
    public String toString() {
        return "gols=" + gols +
                ", finalizações=" + finalizacoes +
                ", defesas=" + defesas +
                ", desarmes=" + desarmes +
                ", amarelos=" + amarelos;
    }
}
