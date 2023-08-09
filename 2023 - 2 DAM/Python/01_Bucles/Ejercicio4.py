print("Introduce un numero entero positivo: ")
try:
    numero = int(input())
    if numero < 0:
        print("El numero introducido no es positivo")
    else:
        suma = 0
        for i in range(numero):
            if i % 2 == 0:
                suma += i
        print("La suma es: " + str(suma))
except:
    print("El valor introducido no es numerico")
