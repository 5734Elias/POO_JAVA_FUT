package com.seuprojeto.futebol.presentation;

import com.seuprojeto.futebol.application.usecases.SimularPartidaUseCase;
import com.seuprojeto.futebol.domain.entities.*;
import com.seuprojeto.futebol.infrastructure.random.JavaUtilRandomProvider;
import com.seuprojeto.futebol.infrastructure.random.RandomProvider;

import java.util.Map;

public class CliApp {

    public static void main(String[] args) {

        RandomProvider random = new JavaUtilRandomProvider();

        // Técnicos
        Tecnico tecnicoA = new Tecnico("Dorival", "4-3-3");
        Tecnico tecnicoB = new Tecnico("Abel", "4-2-3-1");

        // Times
        Time flamengo = new Time("Flamengo", tecnicoA);
        Time palmeiras = new Time("Palmeiras", tecnicoB);

        // Elencos (misturando tipos para o polimorfismo ficar evidente)
        flamengo.adicionarJogador(new Atacante("Pedro", 9, 500000, random));
        flamengo.adicionarJogador(new Atacante("Bruno Henrique", 27, 520000, random));
        flamengo.adicionarJogador(new Zagueiro("Léo Pereira", 4, 400000, random));
        flamengo.adicionarJogador(new Goleiro("Rossi", 1, 450000, random));

        palmeiras.adicionarJogador(new Atacante("Rony", 10, 480000, random));
        palmeiras.adicionarJogador(new Zagueiro("Gustavo Gómez", 15, 520000, random));
        palmeiras.adicionarJogador(new Zagueiro("Murilo", 26, 430000, random));
        palmeiras.adicionarJogador(new Goleiro("Weverton", 21, 470000, random));

        // Use Case
        SimularPartidaUseCase simular = new SimularPartidaUseCase(random);

        // Executa partida
        Partida partida = simular.executar(flamengo, palmeiras, 8);
        EstadoPartida estado = partida.getEstado();

        // Log completo
        System.out.println("\n========================");
        System.out.println("RELATÓRIO DA PARTIDA");
        System.out.println("========================");

        for (String linha : estado.getLog()) {
            System.out.println(linha);
        }

        // Estatísticas por jogador
        System.out.println("\n========================");
        System.out.println("ESTATÍSTICAS POR JOGADOR");
        System.out.println("========================");

        for (Map.Entry<String, EstatisticasJogador> e : estado.getStatsPorJogador().entrySet()) {
            System.out.println("• " + e.getKey() + " -> " + e.getValue());
        }

        System.out.println("\nPlacar final: " + flamengo.getNome() + " " + estado.getPlacar() + " " + palmeiras.getNome());
    }
}
