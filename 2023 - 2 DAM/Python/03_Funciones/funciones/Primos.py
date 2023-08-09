def es_primo(n):
    # n**x realiza la potencia de n a la x
    for i in range(2, int(n**(1/2))+1):
        if n % i == 0:
            return False
    return True


def calcularPrimos(n):
    lista = []
    for i in range(2, n+1):
        if es_primo(i):
            lista.append(i)
    return lista