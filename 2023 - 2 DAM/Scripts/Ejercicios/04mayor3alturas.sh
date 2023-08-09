#!/bin/bash
#Nombre: Francisco Jesús Viguera Alejos
#Fecha: 10/02/2022
#Enunciado: Script nos pide la altura de 3 personas en centímetros, y nos dice por pantalla la mayor de esas alturas.

clear
read -n 3 -p "Altura de persona 1 en centimetros (máximo 999) : " ALTURA1
echo #Este echo sirve para introducir un retorno de lineaclear
read -n 3 -p "Altura de persona 1 en centimetros (máximo 999) : " ALTURA2
echo #Este echo sirve para introducir un retorno de lineaclear
read -n 3 -p "Altura de persona 1 en centimetros (máximo 999) : " ALTURA3
echo #Este echo sirve para introducir un retorno de linea

if [ $ALTURA1 -gt $ALTURA2 ] && [ $ALTURA1 -gt $ALTURA3 ]; then
	echo "La persona más alta es la de $ALTURA1 centimetros."
elif [ $ALTURA2 -gt $ALTURA3 ]; then
	echo "La persona más alta es la de $ALTURA2 centimetros."
else
	echo "La persona más alta es la de $ALTURA3 centimetros."
fi