package Practica4;
/*
Ejercicio10.java
Fecha: 21/12/2021
Autor: Jonatan Gomez Garcia
Programa que declara un metodo que recibe un array de enteros y otro array de numeros enteros para buscar
la secuencia del segundo array dentro del primer array y determinar donde comienza la secuencia.
*/
public class Ejercicio10 {
    public static void main(String[] args){
        int[] vector1 = {1,2,3,5,7,8,5,4,3,7,7,8,3,4,5,8,9,6,7,8};
        int[] vector2 = {1,2,3,6,9,8,3,4,7,6,4,2,1,5,5,5,4,21,6};
        int[] vector3 = {1,2,3,6,9,8,7,6,4,2,1,5,5,5,4,21,6};
    
        int[] secuencia = {8,3,4};

        /*
        Como observación, he realizado el ejercicio sin que importe la cantidad de elementos que contenga
        el vector secuencia
        */
        System.err.println("\nSi la posición es -1 no se ha encontrado coincidencia con la secuencia");
        System.out.println("\t\t--------------------------");
        System.out.println("La secuencia 8,3,4 comienza en la posición " + buscarSecuenciaInt(vector1, secuencia) + " del vector1");
        System.out.println("La secuencia 8,3,4 comienza en la posición " + buscarSecuenciaInt(vector2, secuencia) + " del vector2");
        System.out.println("La secuencia 8,3,4 comienza en la posición " + buscarSecuenciaInt(vector3, secuencia) + " del vector3");
        
    }

    static int buscarSecuenciaInt(int[] vector, int[] secuencia){
        boolean esSecuencia = false;
        int resultado = -1;
        for (int i = 0; i < vector.length; i++){
            int l = i; //Variable usada en el siguiente bucle para comparar sin modificar la i.
            if (esSecuencia) { //Si ya ha encontrado la secuencia para el bucle
                break;
                
            }
            for (int j = 0; j < secuencia.length; j++){                
                if (vector[l] == secuencia[j]){
                    esSecuencia = true;
                    resultado = i;
                    l++;
                } else {
                    esSecuencia = false; //Si no ha encontrado la secuencia para este bucle para pasar al siguiente numero
                    resultado = -1;
                    break;
                }
            }

            if (i > ((vector.length - secuencia.length))){ //Si se acaban los números con los que poder comparar se debe de detener
                resultado = -1; 
                break;
            }
        }
 
        return resultado;

    }

}


