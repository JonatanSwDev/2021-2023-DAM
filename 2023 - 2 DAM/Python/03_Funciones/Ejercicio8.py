from funciones.Estudiante import imprimeMenu,addEstudiante,showEstCal,showEstAprobados,numAprobados,estMaxNota,estAvgNota,estNota,salir
func = {1:addEstudiante,
            2:showEstCal,
            3:showEstAprobados,
            4:numAprobados,
            5:estMaxNota,
            6:estAvgNota,
            7:estNota,
            8:salir}

opcion = -30
while(opcion != 8):
    imprimeMenu()
    opcion = int(input("Selecciona una opcion: "))
    if opcion in func:
        func[opcion]()
    else:
        print("Operacion no valida")
