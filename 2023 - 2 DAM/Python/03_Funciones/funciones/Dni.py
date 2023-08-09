import re

def es_nif(valor):
    if not re.search('^\d{8}[a-zA-Z]{1}$', valor):
        return False
    numeros = valor[0:8]
    letra = valor[8:9].upper()
    letras = "TRWAGMYFPDXBNJZSQVHLCKE"
    calculoLetra = int(numeros)%23

    if letras[calculoLetra : calculoLetra +1] == letra:
        return True
    else:
        return False

def letra_nif(numeros):
    letras = "TRWAGMYFPDXBNJZSQVHLCKE"
    calculoLetra = numeros % 23
    return letras[calculoLetra : calculoLetra +1]