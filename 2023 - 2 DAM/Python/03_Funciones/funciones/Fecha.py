from datetime import datetime


def es_bisiesto(anio):
    if anio % 4 == 0 and (anio % 100 != 0 or anio % 400 == 0):
        return True
    else:
        return False

def dia_anio(dia, mes, anio):
    dias_mes = [31,28,31,30,31,30,31,31,30,31,30,31]
    suma = 0
    if mes == 1:
        return dia
    else:
        if es_bisiesto(anio):
            dias_mes[1] = 29
    for i in range(mes-1):
        suma += dias_mes[i]
    suma += dia
    return suma

def validarFecha(dia, mes, anio):
    dias_mes = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    if anio <= 0:
        return False
    if es_bisiesto(anio):
        dias_mes[1] = 29
    if mes <= 0 or mes > 12:
        return False
    if dia <= 0 or dia > dias_mes[mes-1]:
        return False
    return True


def dia_anio_Utilidades(dia, mes, anio):
    try:
        ##Construimos la fecha y a la vez
        #Hacemos la comprobacion de que
        #La fecha ya es correcta con el
        ##Tratamiento de excepciones
        fecha = datetime(anio, mes, dia)
    except:
        ##En casoo de que la fecha no sea correcta
        print("La fecha introducida no es correcta")
        return None
    ##Creamos la referencia de la fecha a inicios de año
    inicio_del_anio = datetime(anio, 1, 1)
    ##Devolvemos la resta de la fecha actual con menos el inicio de año
    #Usando el operador .days y restando uno, ya que los dias del año
    ##Son tratados desde el dia 0 < max_dias, no de 0 <= max_dias
    return (fecha - inicio_del_anio).days + 1