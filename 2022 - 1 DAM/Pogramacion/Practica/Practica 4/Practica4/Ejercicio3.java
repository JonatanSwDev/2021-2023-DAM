package Practica4;
/*
Ejercicio3.java
Fecha: 20/12/2021
Autor: Jonatan Gomez Garcia
Programa que declara un metodo que recibe un array de numeros enteros y un entero, el metodo devuelve
la frecuencia con el que el numero entero se repite en el array.
*/
public class Ejercicio3 {
    public static void main(String[] args){
        int[] array = {1,2,3,8,7,6,7,9,0,7,5,89,6,5,4,2,4,7,7,8,9,5,7,1};
        int numero = 7;

        System.out.print("El numero " + numero + " se repite " + frecuenciaNumero(array, numero) + " veces");
    }

    static int frecuenciaNumero(int[] array, int numero){
        int frecuencia = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == numero){
                frecuencia ++;
            }
        }

        return frecuencia;
    }
    
}
