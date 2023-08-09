#!/bin/bash
#Nombre: Francisco Jesús Viguera Alejos
#Fecha: 03/02/2022
#Enunciado: Script que pide un nombre por pantalla y nos dice si dicho nombre comienza por la letra jota mayúscula.
read -p "Introduzca un nombre : " NOMBRE
PRIMERA_LETRA=$(echo $NOMBRE | cut -c 1)
if [ $PRIMERA_LETRA = "J" ]; then
	echo "$NOMBRE empieza por J"
else
	echo "$NOMBRE no empieza por J"
fi
echo