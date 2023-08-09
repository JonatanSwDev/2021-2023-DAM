package Practica5;
/*
Ejercicio9.java
Fecha: 13/02/2022
Autor: Jonatan Gomez Garcia
Programa que, usando un método que recibe un texto y una clave, encripta el texto
*/
public class Ejercicio9 {
    public static void main(String[] args){
    String texto = "Solo me queda por hacer este ejercicio, vamos a ver como sale :D";
    String clave = "98765432155";

    System.out.println("\nTexto encriptado:\n" + encriptar(texto, clave));
    }

    static String encriptar(String texto, String clave){
    String textoencriptado = "";

    for (int i = 0; i < texto.length(); i++){
        short chanum = (short) (texto.charAt(i) ^ clave.charAt(i%clave.length()));
        textoencriptado += chanum;
    }

    return textoencriptado;
    }
}
