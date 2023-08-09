valor = "Not Vacia"
contador = 0
notas = []
aprobados = 0
suspensos = 0
suma = 0
while(valor):
    valor = input("\tIntroduce una nota para el alumno " + str(contador + 1) + ": ")
    try:
        nota = float(valor)
        if nota >= 0 and nota <= 10:
            contador += 1
            notas.append(nota)
            suma+=nota
            
            if nota >= 5:
                aprobados+=1
            else:
                suspensos+=1
        else:
            print("\tLa nota introducida debe ser entre 0 y 10")
    except:
        if valor:
            print("\tLa nota introducida para el ", str(contador + 1), "alumno no es valida")

print("Se han introducido las siguientes notas:")
for i in range(0, len(notas)):
    print("\tNota del alumno", str(i+1), notas[i])
    
print("\nResumen:" \
      "\n\tNumero de alumnos:", str(contador), \
      "\n\tAprobados:", str(aprobados), \
      "\n\tSuspensos:", str(suspensos), \
      "\n\tNote media:", str((suma/contador)) if suma!=0 else 0)
#CON EL OPERADOR TERNARIO EVITO QUE EL PROGRAMA TENGA UN FALLO AL INTENTAR DIVIDIR 0 ENTRE ALGO