package Practica4;
/*
Ejercicio15.java
Fecha: 23/12/2021
Autor: Jonatan Gomez Garcia
Programa que localiza un numero dentro de un vector usando una búsqueda binaria.
El resultado es la posición donde se encuentra el número dentro del vector.
*/
public class Ejercicio15 {
    
    public static void main(String[] args){
        int[] vector1 = {1,2,3,4,5,6,7,8,9,10,11};
        int numero = 5;

        System.out.println("El numero " + numero + " esta en la posicion " + " " + buscarNumero(vector1, numero));
    }
    
    static int buscarNumero(int[] vector1, int numero){
        int inferior = 0;
        int superior = vector1.length - 1;
        int medio = -1;

        while (inferior <= superior){
            medio = (superior+inferior) / 2;

            if(vector1[medio] == numero){
                break;
            }
            else if (numero < vector1[medio]){
                superior = medio -1;
            } else {
                inferior = medio + 1;
            }
        }
        return medio;
    }
    
}
