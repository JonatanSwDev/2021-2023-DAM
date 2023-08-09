package Practica5;
/*
invertirTexto.java
Fecha: 11/01/2022
Autor: Jonatan Gomez Garcia
Programa que transforma una cadena de caracters a la inversa usando StringBuilder y un bucle do while
*/
public class invertirTexto {
    public static void main(String[] args){
        String texto = "Pelos nasales";
        StringBuilder invertido = new StringBuilder();
        int i = (texto.length() - 1);

        do {
            invertido.append(texto.charAt(i));
            i--;
        } while (i >= 0);

        System.out.println(invertido);
    }
}
