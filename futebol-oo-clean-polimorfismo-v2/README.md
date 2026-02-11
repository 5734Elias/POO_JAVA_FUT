# Futebol OO (Clean Architecture + Polimorfismo por Eventos) v2

Este projeto é um material de estudo de OO em Java com:
- Encapsulamento
- Herança
- Polimorfismo real (sem `instanceof` / sem `if` por tipo)
- Clean Architecture (domain / application / infrastructure / presentation)
- Entidade `Partida`
- Relatório final com estatísticas por jogador
- Testes com JUnit 5

## Rodar
```bash
mvn clean compile exec:java
```

## Rodar testes
```bash
mvn test
```

## Onde está o polimorfismo?
Cada classe de jogador implementa:

- `List<EventoDeJogo> executarAcao(PartidaContexto ctx)`

O Use Case só processa eventos:

- `evento.aplicar(estado)`

Sem checar o tipo do jogador.
