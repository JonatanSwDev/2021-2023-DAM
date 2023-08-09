#!/bin/bash
#Nombre: Francisco Jesús Viguera Alejos
#Fecha: 10/02/2022
#Enunciado: Script nos pida el año en que nacimos (4 cifras) y 
#nos diga por pantalla que animal nos corresponde según el horóscopo chino.


read -p "Introduce el año de nacimiento: " YEAR
echo #Este echo sirve para introducir un retorno de linea

#Otra opcion para tener la decada
#DECADA=$(echo $DECADA | cut -c 3)
#let DECADA=DECADA*10
#echo "Eres de la decada $DECADA"
let HOROSCOPO=YEAR%12

case $HOROSCOPO in
	"FEBRERO")
		echo "Ese mes tiene 28 dias." ;;
	"ABRIL"|"JUNIO"|"SEPTIEMBRE"|"NOVIEMBRE")
		echo "Ese mes tiene 30 dias." ;;
	"ENERO"|"MARZO"|"MAYO"|"JULIO"|"AGOSTO"|"OCTUBRE"|"DICIEMBRE")
		echo "Ese mes tiene 31 días." ;;
	*)
		echo "ERROR, no existe el mes $MES ."
esac
