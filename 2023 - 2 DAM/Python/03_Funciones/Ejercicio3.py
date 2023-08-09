from funciones.Dni import es_nif
valor = input("Introduce tu NIF: ")
print(f"El NIF {valor} es correcto?\n{es_nif(valor)}")