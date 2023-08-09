#!/bin/bash
#Nombre: Francisco Jesús Viguera Alejos
#Fecha: 03/02/2022
#Enunciado: Script que pide un número por pantalla, e indica si es un múltiplo de 10 o no.
read -p "Introduzca un número : " NUMERO
let RESTO=NUMERO%10
if [ $RESTO -eq 0 ]; then
	echo "El número $NUMERO es multiplo de 10"
else
	echo "El número $NUMERO no es multiplo de 10"
fi