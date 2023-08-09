import sys

mayor = []
while True:
    print("Introduce un numero")
    numero = input()

    if numero == "0":
        break

    numero = numero.replace(",",".")
    try:
        mayor.append(float(numero))
    except:
        print("El valor introducido no es numerico")

if len(mayor) > 0:
    print("Usando funcion max(): El mayor numero de la lista es " + str(max(mayor)))

    maximo = -sys.maxsize - 1
    for i in mayor:
        if i > maximo:
            maximo = i

    print("Usando bucle: El mayor numero de la lista es " + str(maximo))
else:
    print("No has introducido ningun numero")
