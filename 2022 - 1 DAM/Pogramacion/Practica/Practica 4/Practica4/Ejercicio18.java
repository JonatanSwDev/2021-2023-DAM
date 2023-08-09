package Practica4;
/*
Ejercicio15.java
Fecha: 23/12/2021
Autor: Jonatan Gomez Garcia
Programa que localiza un numero dentro de un vector usando una búsqueda binaria recursiva.
El resultado es la posición donde se encuentra el número dentro del vector.
*/
public class Ejercicio18 {    
    public static void main(String[] args){
        int inferior = 0;
        int[] vector1 = {1,2,3,4,5,6,7,8,9,10};
        int superior = (vector1.length) - 1;
        int numero = 5;

        System.out.println("El numero " + numero + " esta en la posicion " + " " + buscarNumero(vector1, numero, inferior, superior));
    }
    
    static int buscarNumero(int[] vector1, int numero, int inferior, int superior){
       int medio = (superior+inferior) / 2;
       System.out.println("Inferior es: " + inferior);
        if (numero > superior){
            return -1;
        }
        else if(numero == vector1[medio]){
            return medio;
        }
        else if (numero < vector1[medio]){
            buscarNumero(vector1, numero, inferior, medio-1);
        }
        else if (numero > vector1[medio]){
                buscarNumero(vector1, numero, medio+1, superior);
        }
    return medio;
    }
    
}
