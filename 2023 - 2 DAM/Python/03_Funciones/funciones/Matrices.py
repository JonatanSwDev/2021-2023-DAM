import random


def generarMatrizRandom():
    columnas = random.randrange(2,6)
    filas = random.randrange(2,6)
    matriz = []
    for i in range(columnas):
        lista = []
        for j in range(filas):
           lista.append(random.randrange(0,100))
        matriz.append(lista)
    return matriz

def imprimirMatriz(matriz):
    for fila in matriz:
        print(fila)

def esCuadrada(matriz):
    if len(matriz) == len(matriz[0]):
        return True
    else:
        return False

def sumaDiagonal(matriz):
    diagonal = 0
    if esCuadrada(matriz):
        for i in range(len(matriz)):
            diagonal += matriz[i][i]
        return diagonal
    else:
        return None