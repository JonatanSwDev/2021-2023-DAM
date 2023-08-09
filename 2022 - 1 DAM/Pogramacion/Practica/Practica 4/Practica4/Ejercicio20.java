package Practica4;
/*
Ejercicio120.java
Fecha: 22/12/2021
Autor: Jonatan Gomez Garcia
Programa que intenta ordenar un vector de enteros por el algoritmo quickShort y devuelve un código si lo ha ordenado, si no ha podido ordenarlo
o si ya estaba ordenado (Nunca lo va a dejar sin ordenar ;))
*/
public class Ejercicio20 {
    static int ordenados;
    public static void main(String[] args){
        int[] vector1= {0,6,7,9,5,4,2,3};

        mostrarArray(vector1);
        System.out.print("\t" + ordenarQuickShort(vector1, 0, vector1.length - 1));
    }

    static void informacion(){
        System.out.println("\n\tCodigo 1 --> Han sido ordenados\n\tCodigo 0 --> Ya estaban ordenados\n\tCodigo -1 --> No se han podido ordenar");
    }
    
    static int ordenarQuickShort(int[] numeros, int primero, int ultimo){
        int aux;

            //Comprobación inicial del orden
            for (int i = 0; i < numeros.length; i++){
                int j = i+1;
                if (j > numeros.length -1){
                    j = i;
                }
                aux = numeros[i];
                if (aux <= numeros[j]){
                ordenados = 0;
                } 
                else {
                    ordenados = -1;
                    break;
                }  
            }

            //Filtro con las ordenes en caso de que estuvieran ordenados o desordenados
            int[] numerosOrdenados = new int [numeros.length];
        if(ordenados == -1){ //Orden para ordenarlos
            System.err.println("Se va a ordenar\n");
            numerosOrdenados = quick(numeros, primero, ultimo);
        }
        if (ordenados == 0){ informacion(); return ordenados;}
    
        //Comprobación final de orden
         for (int i = 0; i < numerosOrdenados.length; i++){
                int j = i+1;
                if (j > numerosOrdenados.length -1){
                    j = i;
                }
                aux = numerosOrdenados[i];
                if (aux <= numerosOrdenados[j]){
                ordenados = 1;
                } 
                else {
                    ordenados = -1;
                    break;
                }  
            }
            informacion();
            return ordenados;
        }
    
    


    static int[] quick(int[] vector, int primero, int ultimo){
        int i, j, medio, aux;
        i = primero;
        j = ultimo;
        medio = vector[(primero+ ultimo) / 2];

        do {
            while(vector[i] < medio){
                i++;    }
            while (vector[j] > medio){
                j--;    }
                
            if(i <= j){
                aux = vector[i];
                vector[i] = vector[j];
                vector[j] = aux;
                i++;
                j--;
            }
        } while (i <=j);
        mostrarArray(vector);

        if(primero < j){
            quick(vector, primero, j);
        }
        if (i < ultimo){
            quick(vector, i, ultimo);

        }
        return vector;
    }
    //Metodo para mostrar el Array
    static void mostrarArray(int[] numeros){
        String serie = "";
        for (int i = 0; i < numeros.length; i++){
            serie += numeros[i];
            if (i < numeros.length - 1){ serie += ", ";}
        }
    System.out.println(serie);
    
    }
    
    
}
