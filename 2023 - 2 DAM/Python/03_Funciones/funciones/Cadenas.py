def cadenas_largas(lista):
    max_cadena = []
    longitud = 0
    for cadena in lista:
        if len(cadena) == longitud:
            max_cadena.append(cadena)
        elif len(cadena) > longitud:
            longitud = len(cadena)
            max_cadena = [cadena]
    return max_cadena

def es_repeticion(cadena):
    #Si la cadena no es par no puede ser nunca producto de una subcadena duplicada
    if len(cadena) % 2 != 0:
        return False
    ##Calculamos la mitad exacta de la cadena pasandolo a entero
    ##Si no lo pasamos a entero se quedará en float y no se podra partir la cadena
    mitad = int(len(cadena)/2)
    ##Comprobamos si la cadena duplicada es igual a la cadena
    if cadena[:mitad]+cadena[:mitad] == cadena:
        return True
    return False