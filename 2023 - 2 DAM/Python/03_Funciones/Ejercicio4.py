from funciones.Dni import letra_nif
import re
valor = input("Introduce tu NIF sin la letra: ")
if not re.search('^\d{8}$', valor):
    print("El NIF introducido no es valido")
else:
    print(f"La letra para {valor} es {letra_nif(int(valor))}")