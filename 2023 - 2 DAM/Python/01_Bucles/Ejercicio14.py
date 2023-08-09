import sys

try:
    print("Introduce el nivel del triangulo (2-40)")
    nivel = int(input())
except:
    print("El valor introducido no es un numero entero")
    sys.exit()

if nivel < 2 or nivel > 40 :
    print("El valor introducido esta fuera de rango")
    sys.exit()
resultado = ""
for i in range(nivel+1):
    for j in range(nivel-i):
        resultado += " "
    for j in range((i*2)-1):
        resultado += "X"
    resultado += "\n"

print("Nivel " + str(nivel) + "\n" + resultado)
