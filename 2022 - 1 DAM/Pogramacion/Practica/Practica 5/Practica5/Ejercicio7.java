package Practica5;
/*
Ejercicio7.java
Fecha: 09/02/2022
Autor: Jonatan Gomez Garcia
Programa que, usando un método que recibe dos cadenas de texto, sustituye las palabas que coinciden
en la primera cadena con las palabas de la segunda por asteriscos
*/
public class Ejercicio7 {
    public static void main(String[] args){
    String texto = "Oracle ha anunciado hoy su nueva generación de compilador Java hoy. Utiliza analizador avanzado y optimizador especial para la JVM de Oracle";    
    String terminos ="JVM,Java,Oracle";

    System.out.println(reemplazarPalabras(texto, terminos));

    }

    static String reemplazarPalabras(String texto, String terminos){
        String[] buscar = terminos.split(",");     
        
        for (int i = 0; i < buscar.length; i++){
            String caracter = "";
            for (int j = 0; j < buscar[i].length(); j++){
                caracter += "*";
            }
            texto = texto.replaceAll(buscar[i], caracter);
        }        

        return texto;

    }   
    
}
