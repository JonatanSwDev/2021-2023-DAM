package Practica4;
/*
Ejercicio16.java
Fecha: 23/12/2021
Autor: Jonatan Gomez Garcia
Programa que intenta ordenar un vector de enteros con el metodo de la Baraja y devuelve un código si lo ha ordenado, si no ha podido ordenarlo
o si ya estaba ordenado (Nunca lo va a dejar sin ordenar ;))
*/
public class Ejercicio17 {
    static int ordenados;
    public static void main(String[] args){
        int [] numeros = {0,6,5,7,9,3};
        mostrarArray(numeros);
       
        System.out.println("\t" + ordenarBaraja(numeros));
        
        }
        //Metodo que muestra en pantalla la informacion de los codigos
        static void informacion(){
            System.out.println("\n\tCodigo 1 --> Han sido ordenados\n\tCodigo 0 --> Ya estaban ordenados\n\tCodigo -1 --> No se han podido ordenar");
        }
        //Metodo principal
        static int ordenarBaraja(int[] numeros){
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
            
        if(ordenados == -1){ //Orden para ordenarlos
            System.out.println("Se va a ordenar\n");
            numeros = baraja(numeros);
        }
        if (ordenados == 0){ informacion(); return ordenados;}
    
        //Comprobación final de orden
         for (int i = 0; i < numeros.length; i++){
                int j = i+1;
                if (j > numeros.length -1){
                    j = i;
                }
                aux = numeros[i];
                if (aux <= numeros[j]){
                ordenados = 1;
                } 
                else {
                    ordenados = -1;
                    break;
                }  
            }
            return ordenados;
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

        static int[] baraja(int[] numeros){
            int pos; 
            int aux;
        for (int i = 0; i < numeros.length; i++){
            pos = i;
            aux = numeros[i];
            while (pos > 0 && numeros[pos-1] > aux){
                numeros[pos] = numeros[pos-1];
                pos --;
            }
            numeros[pos] = aux;
            mostrarArray(numeros);
        }
        informacion();
        return numeros;
    }
}
