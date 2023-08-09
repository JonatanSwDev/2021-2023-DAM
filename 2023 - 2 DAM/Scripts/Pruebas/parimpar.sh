#!/bin/bash
#Nombre: Francisco Jesús Viguera Alejos
#Fecha: 03/02/2022
#Enunciado: Programa que pide numeros y los analiza
read -p "Introduzca un número : " NUMERO
let RESTO=NUMERO%2
if [ $RESTO -eq 0 ]; then
	echo "El número $NUMERO es par"
else
	echo "El número $NUMERO es impar"
fi

read -p "Introduce otro número : " NUMERO
let RESTO=NUMERO%10