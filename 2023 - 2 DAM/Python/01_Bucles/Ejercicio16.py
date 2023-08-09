print("Introduce una cantidad entera de Euros")
try:
    print("Introduce el nivel del rombo (2-40)")
    dinero = int(input())
except:
    print("El valor introducido no es un numero entero")
    sys.exit()

b500 = 0
b200 = 0
b100 = 0
b50 = 0
b20 = 0
b10 = 0
b5 = 0
m2 = 0
m1 = 0
while dinero != 0:
    if dinero - 500 >= 0:
        b500 += 1
        dinero -= 500
    elif dinero - 200 >= 0:
        b200 += 1
        dinero -= 200
    elif dinero -100 >= 0:
        b100 += 1
        dinero -= 100
    elif dinero - 50 >= 0:
        b50 += 1
        dinero -= 50
    elif dinero -20 >= 0:
        b20 += 1
        dinero -= 20
    elif dinero - 10 >= 0:
        b10 += 1
        dinero -= 10
    elif dinero -5 >= 0:
        b5 += 1
        dinero -= 5
    elif dinero - 2 >= 0:
        m2 += 1
        dinero -= 2
    elif dinero -1 >= 0:
        m1 += 1
        dinero -= 1

print("Billetes de 500: " + str(b500) +
      "\nBilletes de 200: " + str(b200) +
      "\nBilletes de 100: " + str(b100) +
      "\nBilletes de 50: " + str(b50) +
      "\nBilletes de 20: " + str(b20) +
      "\nBilletes de 10: " + str(b10) +
      "\nBilletes de 5: " + str(b5) +
      "\nMonedas de 2: " + str(m2) +
      "\nMonedas de 1: " + str(m1))
