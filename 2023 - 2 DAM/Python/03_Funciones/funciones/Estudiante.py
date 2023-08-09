alumnos = ["Ana Pi","Pau Lopez","Luis Sol","Mar Vega","Paz Mir"]
notas = [10,5.5,2.0,8.5,7.0]

def imprimeMenu():
    menu = "\n1) Añadir estudiante y calificación\n"+\
            "2) Mostrar lista de estudiantes con sus calificaciones\n"+\
            "3) Mostrar estudiantes aprobados\n"+\
            "4) Número de aprobados\n"+\
            "5) Estudiantes con máxima nota\n"+\
            "6) Estudiantes con nota mayor o igual a la media\n"+\
            "7) Nota estudiante\n"+\
            "8) Finalizar ejecución del programa\n"
    print(menu)

def addEstudiante():
    nombre = input("Introduce el nombre para el estudiante: ")
    nota = float(input("Introduce la nota para " + nombre + ": "))
    if checkNota(nota):
        alumnos.append(nombre)
        notas.append(nota)
        print(f"Alumno {nombre} con nota {nota} añadido correctamente")
    else:
        print(f"La nota {nota} no es valida para el alumno {nombre}, retrocediendo...")
def showEstCal():
    for i in range(len(alumnos)):
        print(f"Alumno {alumnos[i]}: {notas[i]}")
def showEstAprobados():
    for i in range(len(alumnos)):
        if notas[i] >= 5:
            print(f"Alumno {alumnos[i]}: {notas[i]}")
def numAprobados():
    num_aprobados = sum(1 for nota in notas if nota >=5)
    print(f"numero de alumnos aprobados: {num_aprobados}")
def estMaxNota():
    print("Alumnos con la maxima nota:")
    max_nota = max(notas)
    for i in range(len(notas)):
        if notas[i] == max_nota:
            print(f"{alumnos[i]}: {notas[i]}")
def estAvgNota():
    print("Alumnos por encima de la media:")
    nota_media = sum(nota for nota in notas) / len(notas)
    for i in range(len(notas)):
        if notas[i] >= nota_media:
            print(f"{alumnos[i]}: {notas[i]}")
def estNota():
    alumno = input("Introduce el nombre del alumno a consultar nota: ")
    if alumno in alumnos:
        for i in range(len(alumnos)):
            if alumno == alumnos[i]:
                print(f"La nota para {alumno} es {notas[i]}")
    else:
        print(f"No se encuentra ningun alumno que se llame {alumno}")
def salir():
    print("Fin de Programa")

def checkNota(nota):
    if nota >= 0 and nota <= 10:
        return True
    else:
        return False