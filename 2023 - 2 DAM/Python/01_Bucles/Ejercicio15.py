import math
import sys

try:
    print("Introduce el nivel del rombo (2-40)")
    nivel = int(input())
except:
    print("El valor introducido no es un numero entero")
    sys.exit()

if nivel < 2 or nivel > 40 :
    print("El valor introducido esta fuera de rango")
    sys.exit()

resultado = ""

if nivel%2 == 0:
    nivel += 1
    print("Has introducido un numero par, se va a sumar un nivel mas\nAhora el nivel es: " + str(nivel))
base = math.ceil(nivel/2)
for i in range(base+1):
    resultado += "\n"
    for j in range(base-i):
        resultado += " "
    for j in range((2*i)-1):
        resultado += "X"

i = base
while i > 1:
    resultado += "\n"
    for j in range(base-i+1):
        resultado += " "
    for j in range((2*i)-3):
        resultado += "X"
    i -= 1
print(resultado)
