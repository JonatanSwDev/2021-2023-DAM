#!/bin/bash
#Nombre: Francisco Jesús Viguera Alejos
#Fecha: 03/02/2022
#Enunciado: Programa que revisa detalles de fechas con condicionales
if [ $DIA = "viernes" ]; then
	echo "Bravo, por fin es viernes"
fi

DIASEMANA=$( date +%u ) 
if [ $DIASEMANA -ge 3 ]; then
	echo "Estamos a mas de la mitad de la semana"
fi
if [ $DIASEMANA -lt 3 ]; then
	echo "Estamos a menos de la mitad de la semana"
fi


DIAMES=$( date +%d )
if [ $DIAMES -lt 15 ]; then
	echo "Estamos en la primera quincena del mes"
else 
	echo "Estamos en la segunda quincena del mes"
fi

MESANYO=$( date +%m )
if [ $MESANYO -eq 1 ]; then
	echo "Estamos en enero"
elif [ $MESANYO -eq 2 ]; then
		echo "Estamos en febrero"
	elif [ $MESANYO -ge 3 ]; then
			echo "Estamos en marzo o mas allá."
	else
		echo "Mes no valido"
fi