package Practica4;
/*
Ejercicio4.java
Fecha: 20/12/2021
Autor: Jonatan Gomez Garcia
Programa que declara un metodo que recibe un array de numeros enteros y un entero, el metodo devuelve
la frecuencia con el que el numero entero se repite en el array.
*/
public class Ejercicio4 {
    public static void main(String[] args){
        int[] vector1 = {1,2,3,4,5,6,7,8,9};
        int[] vector2 = {1,2,3,4,5,6,7,8,9};
        int[] vector3 = {0,1,2,3,4,5,6,7,8,9};
        int[] vector4 = {01234,1,2,3,4,5,6,7,8,};
        int[] vector5 = {0,1,2,3,4,5};


    
    System.out.println("El resultado de vector1 y vector2 = " + vectoresIntIguales(vector1, vector2));
    System.out.println("El resultado de vector3 y vector4 = " + vectoresIntIguales(vector3, vector4));
    System.out.println("El resultado de vector3 y vector5 = " + vectoresIntIguales(vector4, vector5));
    
    }

    static boolean vectoresIntIguales(int[] array1, int[] array2){
        boolean condicion = true;
        if (array1.length != array2.length){
            return false;
        }
        for (int i = 0; i < array1.length; i++){
            if (array1[i] != array2[i]){
                condicion = false;
                break;
            }
        }
        return condicion;

    }
}
