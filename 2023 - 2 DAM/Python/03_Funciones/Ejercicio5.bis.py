from funciones.Fecha import dia_anio_Utilidades

dia = input("Introduce el dia: ")
mes = input("Introduce el mes: ")
anio = input("Introduce el año: ")

if dia.isnumeric() and mes.isnumeric() and anio.isnumeric():
    dia = int(dia)
    mes = int(mes)
    anio = int(anio)
    ##La diferencia con el Ejercicio5.py es que usamos utilidades de Python
    print(f"Segun la fecha {dia}/{mes}/{anio} vamos por el dia {dia_anio_Utilidades(dia, mes, anio)} del año")