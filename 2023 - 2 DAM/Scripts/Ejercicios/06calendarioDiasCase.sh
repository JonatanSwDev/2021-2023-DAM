#!/bin/bash
#Nombre: Francisco Jesús Viguera Alejos
#Fecha: 10/02/2022
#Enunciado: Script  nos pedirá por pantalla el nombre de un mes (enero, febrero, etc.) y nos dirá por pantalla el número de días que tiene ese mes. 
#(Así, si introducimos diciembre nos responderá “Diciembre tiene 31 días”). 
#Para este script se considera que no existen los años bisiestos, así que febrero siempre tendrá 28 días.


read -p "Introduce el mes: " MES
echo #Este echo sirve para introducir un retorno de linea

#Otra opcion para tener la decada
#DECADA=$(echo $DECADA | cut -c 3)
#let DECADA=DECADA*10
#echo "Eres de la decada $DECADA"
MES=$(echo ${MES^^})

case $MES in
	"FEBRERO")
		echo "Ese mes tiene 28 dias." ;;
	"ABRIL"|"JUNIO"|"SEPTIEMBRE"|"NOVIEMBRE")
		echo "Ese mes tiene 30 dias." ;;
	"ENERO"|"MARZO"|"MAYO"|"JULIO"|"AGOSTO"|"OCTUBRE"|"DICIEMBRE")
		echo "Ese mes tiene 31 días." ;;
	*)
		echo "ERROR, no existe el mes $MES ."
esac
