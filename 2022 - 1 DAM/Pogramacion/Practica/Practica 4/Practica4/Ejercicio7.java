package Practica4;
/*
Ejercicio7.java
Fecha: 21/12/2021
Autor: Jonatan Gomez Garcia
Programa que declara un metodo que recibe un array de enteros junto con un numero a buscar
y determina la posición del elemento a buscar dentro del vector.
*/
public class Ejercicio7 {
    public static void main(String[] args) {
        int[] vector1 = {1,2,3,4,5,6,7,8,9,0};
        int[] vector2 = {0,9,8,7,6,5,4,3,2,1};
        int buscar = 3;

        System.out.println("El numero " + buscar + " se encuentra en la posicion " + buscarInt(vector1, buscar) + " del vector1");
        System.out.println("El numero " + buscar + " se encuentra en la posicion " + buscarInt(vector2, buscar) + " del vector2");
    }

    static int buscarInt(int[] vector, int buscar){
        int posicion = -1;

        for (int i = 0; i < vector.length; i++){  
            if (vector[i] == buscar){
                posicion = i;
                break;
            }
        }
        return posicion;
    }
}
