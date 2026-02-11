package com.seuprojeto.futebol.domain.entities;

import com.seuprojeto.futebol.domain.valueobjects.Lado;

import java.util.*;

// Estado mutável da partida: placar + log + estatísticas por jogador.
public class EstadoPartida {

    private final Placar placar = new Placar();
    private final List<String> log = new ArrayList<>();
    private final Map<String, EstatisticasJogador> statsPorJogador = new LinkedHashMap<>();

    public Placar getPlacar() {
        return placar;
    }

    public void registrar(String mensagem) {
        log.add(mensagem);
    }

    public List<String> getLog() {
        return Collections.unmodifiableList(log);
    }

    public Map<String, EstatisticasJogador> getStatsPorJogador() {
        return Collections.unmodifiableMap(statsPorJogador);
    }

    // --- Métodos "de domínio" para eventos usarem (evita duplicação) ---

    public void registrarFinalizacao(String autor) {
        stats(autor).addFinalizacao();
        registrar("🎯 Finalização de " + autor);
    }

    public void registrarGol(String autor, Lado lado) {
        stats(autor).addGol();

        if (lado == Lado.MANDANTE) placar.golMandante();
        else placar.golVisitante();

        registrar("⚽ GOL de " + autor + " (" + lado + ")");
    }

    public void registrarDefesa(String goleiro) {
        stats(goleiro).addDefesa();
        registrar("🧤 Defesa do goleiro " + goleiro);
    }

    public void registrarDesarme(String zagueiro) {
        stats(zagueiro).addDesarme();
        registrar("🛡️ Desarme de " + zagueiro);
    }

    public void registrarAmarelo(String jogador) {
        stats(jogador).addAmarelo();
        registrar("🟨 Cartão amarelo para " + jogador);
    }

    private EstatisticasJogador stats(String nomeJogador) {
        return statsPorJogador.computeIfAbsent(nomeJogador, k -> new EstatisticasJogador());
    }
}
