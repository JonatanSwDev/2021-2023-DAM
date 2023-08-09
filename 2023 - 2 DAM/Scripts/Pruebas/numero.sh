#!/bin/bash
#Nombre: Francisco Jesús Viguera Alejos
#Fecha: 02/02/2022
#Enunciado: Programa que realiza operaciones matematicas
NUMERO=4
echo Primera suma: "($NUMERO+3)" $(($NUMERO+3))
let SUMA=NUMERO+12
echo Segunda suma: "($NUMERO+12)" $SUMA
echo Tercera suma: "($NUMERO+20)" $[$NUMERO+20]

echo Prueba de calculo
PRECIO_COPAS=55
BEBEDORES=10
ESCOTE=$[$PRECIO_COPAS / $BEBEDORES]
echo Tenemos que pagar $ESCOTE euros cada uno.