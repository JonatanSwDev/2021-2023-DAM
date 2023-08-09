package Practica5;
/*
Ejercicio4.java
Fecha: 25/01/2022
Autor: Jonatan Gomez Garcia
Programa que, usando un método que recibe dos cadenas de texto, comprueba si contiene una palabra de otro String y devuelve
el número de veces que lo contiene la primera cadena sin tener en cuenta mayusculas o minusculas.
*/
public class Ejercicio4 {
    public static void main(String[] args){
        String texto = "Estamos viviendo en un submarino amarillo. No tenemos nada que hacer. En el interior del submarino se está muy apretado. Así que estamos leyendo todo el día. Vamos a salir en 5 días.";
        String buscar = "en";
        
        System.out.println("El texto se repite " + obtenerNumeroVecesSubCadena2(texto, buscar) + " veces.");    
    }

    static int obtenerNumeroVecesSubCadena2(String texto, String buscar){
        int contador = 0;
        buscar = buscar.toUpperCase();
        String[] textoArray = texto.toUpperCase().split("[., ]");
        for (int i = 0; i < textoArray.length; i++){
            if (textoArray[i].indexOf(buscar) >= 0){
                contador++;
            }
        }
        return contador;
    }
    
}
