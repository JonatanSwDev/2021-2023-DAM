package Practica4;
/*
Ejercicio6.java
Fecha: 21/12/2021
Autor: Jonatan Gomez Garcia
Programa que declara un metodo que recibe un array de enteros junto con un numero a buscar cuantos elementos se encuentran de
forma consecutiva, devolviendo el valor de los elemntos consecutivos (1,2,3... o 3,4,5...) se empieza a contar
a partir del segundo elemento del vector.
*/
public class Ejercicio6 {
    public static void main(String[] args) {
        int[] vector1 = {1,2,3,5,7,8,5,4,3,7,7,8,3,4,5,8,9,6,7,8};
        int[] vector2 = {1,6,3,8,3,9,5,8,3,7,4,6};
        int[] vector3 = {4,6,8,3,6,9,2,3,4,5,6,8,6,7,8,9,3};

        System.out.println("El vector1 tiene " + contarIntConsecutivos(vector1) + " numeros consecutivos");
        System.out.println("El vector2 tiene " + contarIntConsecutivos(vector2) + " numeros consecutivos");
        System.out.println("El vector3 tiene " + contarIntConsecutivos(vector3) + " numeros consecutivos");
    }

    static int contarIntConsecutivos(int[] vector){
        int contador = 1;
        for (int i = 1; i < vector.length; i++){        
            if (vector[i-1]+1 == vector[i]){
                contador++;
            }
        }

        if (contador == 1){
            return 0;
        }

        return contador;
    }
}
