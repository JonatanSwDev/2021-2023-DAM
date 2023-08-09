#!/bin/bash
#Nombre: Francisco Jesús Viguera Alejos
#Fecha: 02/02/2022
#Enunciado: Programa que copia un fichero y lo nombra con la fecha actual
NOMBRE_FICHERO="red"$(date +%d%m%y)".conf"
cp /etc/network/interfaces $NOMBRE_FICHERO