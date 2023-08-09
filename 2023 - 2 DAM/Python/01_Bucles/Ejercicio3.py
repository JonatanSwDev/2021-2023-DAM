aprobados = 0
suspensos = 0
suma = 0
continuar = True
cuenta = 1

while continuar:
    print("Introduce la " + str(cuenta) + " nota")
    actual = input()

    if not actual:
        continuar = False
        cuenta -= 1
    else:
        if float(actual) <= 10 and float(actual) >= 5:
            aprobados += 1
            suma += float(actual)
            cuenta += 1
        elif float(actual) < 5 and float(actual) >= 0:
            suspensos +=1
            suma += float(actual)
            cuenta += 1
        else:
            print("Nota no valida (0-10)")
media = suma/cuenta
print("Numero de alumnos: " + str(cuenta) +
      "\nAprobados: " + str(aprobados) +
      "\nSuspensos: " + str(suspensos) +
      "\nNota media: " + str(media))

