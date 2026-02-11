package com.seuprojeto.futebol.infrastructure.random;

import java.util.Random;

// Implementação concreta (infraestrutura).
public class JavaUtilRandomProvider implements RandomProvider {

    private final Random random = new Random();

    @Override
    public int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
