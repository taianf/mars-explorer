# Getting Started

Simple Spring Rest API

## Considerações:
- Caso seja uma instrução de mover e a sonda esteja na borda do campo, ela irá continuar na mesma posição.
- Caso seja uma instrução de mover e a sonda encontre outra na frente, ela irá continuar na mesma posição.
- As sondas se movem um movimento de cada vez, na ordem em que são enviadas.
- Caso uma sonda execute todos os movimentos, ela ficará na mesma posição até que todas as outras também executem os seus.

## Iniciando a API

```
./gradlew bootRun
```

## Modelos de dados

A entrada de dados segue o seguinte modelo json:

```json
{
  "board": {
    "x": 5,
    "y": 5
  },
  "probes": [
    {
      "start": {
        "x": 1,
        "y": 2,
        "direction": "N"
      },
      "moves": "LMLMLMLMM"
    },
    {
      "start": {
        "x": 3,
        "y": 3,
        "direction": "E"
      },
      "moves": "MMRMMRMRRM"
    }
  ]
}
```

E a resposta segue o seguinte modelo:

```json
[
  {
    "x": 1,
    "y": 3,
    "direction": "N"
  },
  {
    "x": 5,
    "y": 1,
    "direction": "E"
  }
]
```

## Swagger UI

```
http://localhost:8080/swagger-ui.html
```
