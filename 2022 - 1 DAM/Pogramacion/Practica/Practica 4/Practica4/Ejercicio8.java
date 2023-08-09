package Practica4;
/*
Ejercicio8.java
Fecha: 21/12/2021
Autor: Jonatan Gomez Garcia
Programa que declara un metodo boolean que recibe un array de enteros y determina si están ordenados o no.
*/
public class Ejercicio8 {
    public static void main(String[] args) {
        int[] vector1 = {1,2,3,4,5,6,7,8,9};
        int[] vector2 = {1,2,3,5,6,7,8,9,10};
        int[] vector3 = {13,14,15,16,17,18,19,20,21,22};

        System.out.println("¿El Vector1 esta ordenado? --> " + yaOrdenadoInt(vector1));
        System.out.println("¿El Vector2 esta ordenado? --> " + yaOrdenadoInt(vector2));
        System.out.println("¿El Vector3 esta ordenado? --> " + yaOrdenadoInt(vector3));         
    }

    static boolean yaOrdenadoInt(int[] vector){
    boolean ordenVector = true;
        for (int i = 1; i < vector.length; i++){
            if (vector[i-1]+1 != vector[i]){
                ordenVector = false;
                break;
            }
        }
    return ordenVector;
    }

}
