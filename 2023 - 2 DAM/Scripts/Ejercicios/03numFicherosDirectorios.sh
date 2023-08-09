#!/bin/bash
#Nombre: Francisco Jesús Viguera Alejos
#Fecha: 09/02/2022
#Enunciado: Script que nos diga si en el directorio actual hay más de 10 ficheros o no.

NUM_FICHEROS=$(ls | wc -l)
if [ $NUM_FICHEROS -gt 10 ]; then
	echo "Existen más de 10 ficheros en el directorio actual: $NUM_FICHEROS"
else
	echo "No existen más de 10 fichero en el directorio actual: $NUM_FICHEROS"
fi