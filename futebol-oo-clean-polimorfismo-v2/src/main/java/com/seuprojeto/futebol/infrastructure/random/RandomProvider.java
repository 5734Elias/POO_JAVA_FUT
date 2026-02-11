package com.seuprojeto.futebol.infrastructure.random;

// Abstração: o resto do sistema depende disso, não de Random direto.
public interface RandomProvider {
    int nextInt(int bound);
}
