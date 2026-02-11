package com.seuprojeto.futebol.domain.events;

import com.seuprojeto.futebol.domain.entities.EstadoPartida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartaoAmareloTest {

    @Test
    void amareloDeveIncrementarStatsELog() {
        EstadoPartida estado = new EstadoPartida();

        new CartaoAmarelo("Gómez").aplicar(estado);

        assertTrue(estado.getStatsPorJogador().containsKey("Gómez"));
        assertEquals(1, estado.getStatsPorJogador().get("Gómez").getAmarelos());

        assertFalse(estado.getLog().isEmpty());
        assertTrue(estado.getLog().get(0).contains("Cartão amarelo"));
    }
}
