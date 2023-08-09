import sys

from funciones.Primos import calcularPrimos

valor = input("Introduce un numero: ")
if not valor.isnumeric():
    print("El valor introducido no es numerico")
    sys.exit()

if int(valor) >= 2:
    lista = calcularPrimos(int(valor))
    print(f"Numeros primos [2-{valor}]: {lista}")
else:
    print("El valor introducido debe ser igual o mayor a 2")