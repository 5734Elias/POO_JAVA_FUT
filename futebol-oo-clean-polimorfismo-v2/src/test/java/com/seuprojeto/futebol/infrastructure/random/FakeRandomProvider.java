package com.seuprojeto.futebol.infrastructure.random;

import java.util.ArrayDeque;
import java.util.Deque;

// Random "fake" para testes: você injeta uma sequência de números previsíveis.
public class FakeRandomProvider implements RandomProvider {

    private final Deque<Integer> fila = new ArrayDeque<>();

    public FakeRandomProvider(int... valores) {
        for (int v : valores) fila.addLast(v);
    }

    @Override
    public int nextInt(int bound) {
        if (fila.isEmpty()) return 0;
        int v = fila.removeFirst();
        // garante que fica no range
        return Math.floorMod(v, bound);
    }
}
