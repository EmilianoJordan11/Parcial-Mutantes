# 🧬 Parcial Mutantes

## 📖 Introducción

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Mens.

Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es mutante basándose en su secuencia de ADN.

Para eso te ha pedido crear un programa con un método o función con la siguiente firma:
```
boolean isMutant(String[] dna);
```

## ⚙️ Funcionamiento programa
Se recibirá como parámetro un array de Strings que representan cada fila de una tabla de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las cuales representa cada base nitrogenada del ADN.

Se sabrá si un humano es mutante, si encuentras **MÁS DE UNA SECUENCIA DISTINTA** de cuatro letras iguales, de forma oblicua, horizontal o vertical.

La matriz a verificar se ingresa por teclado y luego de verificar si es mutante o no, le duvuelve el resultado al usuario.

## 🚀 Ejecución
El proyecto ha sido deployado en Render y puede ser accedido mediante el siguiente link:
https://parcial-mutantes-qs03.onrender.com

### 🔗 Endpoints

-**POST** /mutant/ - Recibe un JSON con la matriz de ADN a verificar. Ejemplo:
```json
{
    "dna": [
        "TCGGGTGAT",
        "TGATCCTTT",
        "TACGAGTGA",
        "AAATGTACG",
        "ACGAGTGCT",
        "AGACACATG",
        "GAATTCCAA",
        "ACTACGACC",
        "TGAGTATCC"
    ]
}
```

-**GET** /stats/ Devuelve un JSON con la cantidad de mutantes y humanos verificados, junto con la proporción de ADN mutante en comparación con el ADN humano.
```json
{
    "ratio": 0.4
    "count_mutant_dna": 40,
    "count_human_dna": 100
}
```
