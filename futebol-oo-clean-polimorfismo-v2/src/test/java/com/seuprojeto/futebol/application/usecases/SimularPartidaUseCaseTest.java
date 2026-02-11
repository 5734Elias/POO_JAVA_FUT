package com.seuprojeto.futebol.application.usecases;

import com.seuprojeto.futebol.domain.entities.*;
import com.seuprojeto.futebol.infrastructure.random.FakeRandomProvider;
import com.seuprojeto.futebol.infrastructure.random.RandomProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimularPartidaUseCaseTest {

    @Test
    void deveSimularSemIfPorTipoEDarPlacarValido() {
        // Sequência de "random": controla comportamento dos jogadores.
        // Atacante: chance < 30 = gol. Zagueiro: chance < 40 = desarme. Cartão: > 91 = amarelo.
        RandomProvider random = new FakeRandomProvider(
                10, // atacante -> gol
                50, // atacante -> não gol
                10, 95, // zagueiro -> desarme + amarelo
                10, // goleiro -> defesa
                10, // atacante -> gol
                10, // atacante -> gol
                10, 10, // zagueiro -> desarme sem amarelo
                10  // goleiro -> defesa
        );

        Tecnico t1 = new Tecnico("A", "4-3-3");
        Tecnico t2 = new Tecnico("B", "4-4-2");

        Time mandante = new Time("Time A", t1);
        Time visitante = new Time("Time B", t2);

        mandante.adicionarJogador(new Atacante("Pedro", 9, 1, random));
        mandante.adicionarJogador(new Zagueiro("Léo", 4, 1, random));
        mandante.adicionarJogador(new Goleiro("Rossi", 1, 1, random));

        visitante.adicionarJogador(new Atacante("Rony", 10, 1, random));
        visitante.adicionarJogador(new Zagueiro("Gómez", 15, 1, random));
        visitante.adicionarJogador(new Goleiro("Weverton", 21, 1, random));

        SimularPartidaUseCase useCase = new SimularPartidaUseCase(random);
        Partida partida = useCase.executar(mandante, visitante, 6);

        assertNotNull(partida);
        assertNotNull(partida.getEstado());
        assertNotNull(partida.getEstado().getPlacar());

        // Tem log e stats
        assertFalse(partida.getEstado().getLog().isEmpty());
        assertFalse(partida.getEstado().getStatsPorJogador().isEmpty());
    }
}
