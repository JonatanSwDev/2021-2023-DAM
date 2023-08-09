package Practica4;
/*
Ejercicio9.java
Fecha: 21/12/2021
Autor: Jonatan Gomez Garcia
Programa que declara un metodo boolean que recibe un array de enteros y determina si están ordenados o no.
*/
public class Ejercicio9 {
    public static void main(String[] args){
        int[] vector1 = {1,2,3,5,7,8,5,4,3,7,7,8,3,4,5,8,9,6,7,8};
        int[] vector2 = {1,2,3,6,9,8,6,7,6,4,2,1,5,5,5,4,21,6,6,6};

        System.out.println("El numero más repetido en el vecor1 es el: " +  masFrecuenteInt(vector1));
        System.out.println("El numero más repetido en el vecor2 es el: " +  masFrecuenteInt(vector2));
    }

    static int masFrecuenteInt(int[] vector){
        int masFrecuente = 0;
        int numMasFrecuente = Integer.MIN_VALUE;

            for (int i = 0; i < vector.length; i++){
                int contador = 0;
                
                for(int j = 0; j < vector.length; j++){
                    if (vector[i] == vector[j]){
                        contador++;}
                
                if (masFrecuente < contador){
                    masFrecuente = contador;
                    numMasFrecuente = vector[i];}
                }
            }
            return numMasFrecuente;
    }
}
