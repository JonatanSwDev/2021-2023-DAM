import math

def cuadrados():
    try:
        print("Introduce el valor del lado para el cuadrado")
        lado = input()
        lado = lado.replace(",",".")
        resultado = float(lado)*float(lado)
        print("La superficie del cuadrado es: " + str(resultado))
    except:
        print("El valor introducido no es numerico")

def triangulos():
    try:
        print("Introduce el valor de la base del triangulo")
        base = input()
        base = base.replace(",",".")

        print("Introduce el valor de la altura del triangulo")
        altura = input()
        altura = altura.replace(",",".")

        resultado = float(base)*float(altura)/2
        print("La superficie del triangulo es: " + str(resultado))
    except:
        print("El valor introducido no es numerico")

def circulos():
    try:
        print("Introduce el radio del circulo")
        radio = input()
        radio = radio.replace(",",".")

        resultado = math.pow(float(radio), 2) * math.pi
        print("La superficie del circulo es: " + str(resultado))
    except:
        print("El valor introducido no es numerico")

option = "-1"
while option != "4":
    print("Calculo de superficies:\n" +
      "1 - Cuadrados\n" +
      "2 - Triangulos\n" +
      "3 - Circulos\n" +
      "4 - Salir")

    option = str(input())

    if option == "1":
        cuadrados()
    elif option == "2":
        triangulos()
    elif option == "3":
        circulos()
    elif option == "4":
        print("Hasta pronto")
    else:
        print("Orden no reconocida")



