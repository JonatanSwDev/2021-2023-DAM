#!/bin/bash
#Nombre: Francisco Jesús Viguera Alejos
#Fecha: 10/02/2022
#Enunciado: Script nos pide la edad y nos diga por pantalla en que década nacimos. (La década de los 70, la de los 80, la de los 90, etc.).

read -p "Introduce tu edad: " EDAD
echo #Este echo sirve para introducir un retorno de linea
YEAR=$(date +%Y)
let DECADA=YEAR-EDAD

#Otra opcion para tener la decada
#DECADA=$(echo $DECADA | cut -c 3)
#let DECADA=DECADA*10
#echo "Eres de la decada $DECADA"

case $DECADA in
	2*) 
		echo "Eres de la epoca de los 2000 o superior." ;;
	??9?)
		echo "Eres de la epoca de los 90." ;;
	??8?)
		echo "Eres de la epoca de los 80." ;;
	??7?)
		echo "Eres de la epoca de los 70." ;;
	??6?)
		echo "Eres de la epoca de los 60." ;;
	*)
		echo "Eres de la epoca de los 50 o incluso anterior." ;;
esac
