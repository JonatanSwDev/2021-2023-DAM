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

if [ $MES = "FEBRERO" ]; then
	echo "Ese mes tiene 28 dias."
elif [ $MES = "ABRIL" ] || [ $MES = "JUNIO" ] ||
 [ $MES = "SEPTIEMBRE" ] || [ $MES = "NOVIEMBRE" ]; then
	echo "Ese mes tiene 30 días."
else
	echo "Ese mes tiene 31 dias."
fi