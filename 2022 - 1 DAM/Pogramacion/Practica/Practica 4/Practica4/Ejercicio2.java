package Practica4;
/*
Ejercicio2.java
Fecha: 20/12/2021
Autor: Jonatan Gomez Garcia
Programa que declara un array de enteros con 20 elementos. Cada elemento del vector se inincializa
haciendo una multiplicación de la posición del elemento por 5, tras eso se muestran por pantalla.
*/
public class Ejercicio2 {
    public static void main(String[] args){
        int[] numeros = asignarNumeros(new int [20]);

        System.out.println("Cada elemento se ha inincializado con el siguiente valor:");
        mostrarArray(numeros);
    }

    static int[] asignarNumeros(int[] numeros){
        for (int i = 0; i < numeros.length; i++){
            numeros [i] = i*5;
        }
        return numeros;
    }

    static void mostrarArray(int[] vector){
        String serie = "";
        for (int i = 0; i < vector.length; i++){
            serie += vector[i];
            if (i < vector.length - 1){ serie += ", ";}       
        }        

        System.out.print(serie);
    }
}
