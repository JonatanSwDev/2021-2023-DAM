#!/bin/bash
#Nombre: Francisco Jesús Viguera Alejos
#Fecha: 09/02/2022
#Enunciado: Programa que muestra el mensaje "Hola Mundo".
clear
read -n 3 -p "Numero entre 100 y 999 (No pulses INTRO) : " NUMERO
echo #Este echo sirve para introducir un retorno de linea

if [ $NUMERO -lt 100 ]; then
	echo "Lo siento, has introducido un numero menor de 100"
else
	PRIMERA_CIFRA=$(echo $NUMERO | cut -c 1)
	TERCERA_CIFRA=$(echo $NUMERO | cut -c 3)
	if [ $PRIMERA_CIFRA = $TERCERA_CIFRA ]; then
		echo "El numero $NUMERO es capicua."
	else
		echo "El número $NUMERO no es capicua"
	fi
fi
