import random

print("Piense un número del 0 al 100 (no me engañe ni cambie de número)")

respuesta = "k"
menor = 0
mayor = 100
intentos = 1
while respuesta != "i":
    numero = random.randint(menor, mayor)
    print("¿Es el " + str(numero) + "?")
    respuesta = input()
    if respuesta == "n":
        mayor = numero - 1
        intentos += 1
    elif respuesta == "m":
        menor = numero + 1
        intentos += 1
    elif respuesta == "i":
        print("¡¡¡Qué bueno soy, lo he acertado en tan sólo " + str(intentos) + " intentos!!!")
    else:
        print("No soy capaz de reconocer la orden: " + respuesta + " te digo otro numero...")
