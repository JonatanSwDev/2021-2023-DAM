from funciones.Fecha import dia_anio,validarFecha,dia_anio_Utilidades

dia = input("Introduce el dia: ")
mes = input("Introduce el mes: ")
anio = input("Introduce el año: ")

if dia.isnumeric() and mes.isnumeric() and anio.isnumeric():
    dia = int(dia)
    mes = int(mes)
    anio = int(anio)
    print(f"Segun la fecha {dia}/{mes}/{anio} vamos por el dia {dia_anio_Utilidades(dia, mes, anio)} del año")

    if validarFecha(dia, mes, anio):
        print(f"Segun la fecha {dia}/{mes}/{anio} vamos por el dia {dia_anio(dia, mes, anio)} del año")
    else:
        print(f"La fecha {dia}/{mes}/{anio} no es valida")
else:
    print("Los valores introducidos no son validos")