package com.seuprojeto.futebol.domain.events;

import com.seuprojeto.futebol.domain.entities.EstadoPartida;
import com.seuprojeto.futebol.domain.valueobjects.Lado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GolTest {

    @Test
    void golDeveIncrementarPlacarEStats() {
        EstadoPartida estado = new EstadoPartida();

        new Gol("Pedro", Lado.MANDANTE).aplicar(estado);

        assertEquals(1, estado.getPlacar().getGolsMandante());
        assertEquals(0, estado.getPlacar().getGolsVisitante());

        assertTrue(estado.getStatsPorJogador().containsKey("Pedro"));
        assertEquals(1, estado.getStatsPorJogador().get("Pedro").getGols());
    }
}
