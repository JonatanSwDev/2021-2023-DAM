package Practica5;
/*
Ejercicio6.java
Fecha: 28/02/2022
Autor: Jonatan Gomez Garcia
Programa que, usando un método que recibe una cadena de caracteres con una
cierta longitud devuelve una cadena completando una longitud objetivo con asteriscos
*/
public class Ejercicio6 {
    public static void main(String[] args){
        System.out.println(padRight("Introducción", '*', 20));
        }
    
    static StringBuilder padRight(String texto, char caracter, int numero){
        StringBuilder resultado = new StringBuilder();
        resultado.append(texto);
        if (resultado.length() <= 0){
            return resultado;
        }
        if (resultado.length() > 0){
            for (int i = texto.length(); i < numero; i++){
                resultado.append(caracter);
            }
        }
    return resultado;
    }
}
