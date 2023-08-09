package Practica5;
/*
Ejercicio5.java
Fecha: 28/02/2022
Autor: Jonatan Gomez Garcia
Programa que, usando un método que recibe una cadena con etiquetas para pasar
a mayusculas, devuelve el texto con las mayusculas convenientes sin las etiquetas
*/
public class Ejercicio5 {
    public static void main(String[] args){
        String texto = "Estamos, viviendo en un <mayus>submarino amarillo</mayus>. No tenemos <mayus>nada</mayus> qué hacer";
        
        System.out.println(pasarMayusculaSubCadena(texto));
    }

    static String pasarMayusculaSubCadena (String texto){
        boolean etiqueta = false;
        boolean mayusculas = false;
        String textoresultado = "";
        String aux = "";
        char[] textito = texto.toCharArray();

        for (int i = 0; i < textito.length; i++){
            if ((textito[i] == '<' && mayusculas == false && etiqueta == false)){
                etiqueta = true;
                mayusculas = true;
            }
            if (textito[i] == '>' && etiqueta == true){
                etiqueta = false;
                continue;
            }
            if (textito[i] == '<' && textito[i+1] == '/' && etiqueta == false && mayusculas == true){
                etiqueta = true;
                mayusculas = false;
                textoresultado += aux.toUpperCase();
                aux = "";
            }
            if (etiqueta == false && mayusculas == false){
                textoresultado += textito[i];
            }
            if (etiqueta == false && mayusculas == true){
                aux += textito[i];
            }
        }

        return textoresultado;
    }
}
