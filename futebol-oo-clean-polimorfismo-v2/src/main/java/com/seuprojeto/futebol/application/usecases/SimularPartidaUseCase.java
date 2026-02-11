package com.seuprojeto.futebol.application.usecases;

import com.seuprojeto.futebol.domain.entities.*;
import com.seuprojeto.futebol.domain.events.EventoDeJogo;
import com.seuprojeto.futebol.domain.valueobjects.Lado;
import com.seuprojeto.futebol.domain.valueobjects.PartidaContexto;
import com.seuprojeto.futebol.infrastructure.random.RandomProvider;

import java.util.List;

// Use Case: simular a partida.
// Aqui NÃO existe if por tipo de jogador (sem instanceof / sem getClass).
public class SimularPartidaUseCase {

    private final RandomProvider random;

    public SimularPartidaUseCase(RandomProvider random) {
        this.random = random;
    }

    public Partida executar(Time mandante, Time visitante, int rodadas) {
        Partida partida = new Partida(mandante, visitante);
        EstadoPartida estado = partida.getEstado();

        mandante.getTecnico().orientar();
        visitante.getTecnico().orientar();

        for (int i = 1; i <= rodadas; i++) {
            boolean mandanteAtaca = (i % 2 == 1);

            Time timeAtual = mandanteAtaca ? mandante : visitante;
            Lado ladoAtual = mandanteAtaca ? Lado.MANDANTE : Lado.VISITANTE;

            estado.registrar("\n===== Rodada " + i + " =====");
            estado.registrar("Time da vez: " + timeAtual.getNome());

            PartidaContexto ctx = new PartidaContexto(partida, timeAtual, ladoAtual);

            Jogador escolhido = escolherJogador(timeAtual);

            estado.registrar("👟 Jogador escolhido: " + escolhido.getNome() + " (camisa " + escolhido.getCamisa() + ")");

            // Polimorfismo: o jogador retorna eventos; cada evento se aplica no estado.
            List<EventoDeJogo> eventos = escolhido.executarAcao(ctx);

            for (EventoDeJogo e : eventos) {
                e.aplicar(estado);
            }

            estado.registrar("📌 Placar: " + estado.getPlacar());
        }

        estado.registrar("\n🏁 Fim de jogo: " + mandante.getNome() + " " + estado.getPlacar() + " " + visitante.getNome());
        return partida;
    }

    private Jogador escolherJogador(Time time) {
        int idx = random.nextInt(time.getElenco().size());
        return time.getElenco().get(idx);
    }
}
