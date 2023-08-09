package Practica4;
/*
Ejercicio1.java
Fecha: 20/12/2021
Autor: Jonatan Gomez Garcia
Programa simple que declara un Array de enteros con 10 elementos y cada elemento inincializado a 7
Muestra el valor de cada elemento del Array en pantalla, es decir: 10 veces 7
*/
public class Ejercicio1{
    public static void main(String[] args){
        int[] vector = {7,7,7,7,7,7,7,7,7,7};

        System.out.println("Se ha creado un vector de 10 elementos\nCada elemento se ha inincializado a 7");

        mostrarArray(vector);
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

