#!/bin/bash
#Nombre: Francisco Jesús Viguera Alejos
#Fecha: 02/02/2022
#Enunciado: Programa que pide datos a introducir y despues calcula la media

read -p "Introduce la nota de ISO: " NOTAISO
read -p "Introduce la nota de PAR: " NOTAPAR
read -p "Introduce la nota de BBDD: " NOTABBDD
SUMA=$[$NOTAISO+$NOTAPAR+$NOTABBDD]
echo $NOTABBDD
echo $NOTAPAR
echo $NOTAISO
echo $SUMA
#MEDIA=$[$SUMA/3] Resultado sin decimales
MEDIA=$(echo "scale=2; $SUMA/3" | bc -l) #Scale marca el numero de decimales. Y despues del ; se pone la operacion
echo "La media es $MEDIA."