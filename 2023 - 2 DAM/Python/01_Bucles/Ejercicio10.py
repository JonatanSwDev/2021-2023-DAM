import random

print("Se van a generar 100 numeros aleatorios")
lista = []

for i in range(100):
    n = random.randint(0,99)
    lista.append(n)

rango1 = 0
rango2 = 0
rango3 = 0
rango4 = 0
rango5 = 0

for i in lista:
    if i >= 0 and i < 20:
        rango1 += 1
    elif i >= 20 and i < 40:
        rango2 += 1
    elif i >= 40 and i < 60:
        rango3 += 1
    elif i >= 60 and i < 80:
        rango4 += 1
    elif i >= 80 and i < 100:
        rango5 += 1

print("[ 0-19]: " + str(rango1) +
      "\n[20-39]: " + str(rango2) +
      "\n[40-59]: " + str(rango3) +
      "\n[60-79]: " + str(rango4) +
      "\n[80-99]: " + str(rango5))
