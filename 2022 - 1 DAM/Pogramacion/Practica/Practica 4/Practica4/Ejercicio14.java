package Practica4;
/*
Ejercicio14.java
Fecha: 22/12/2021
Autor: Jonatan Gomez Garcia
Programa que recibe un texto y determina la posicion de cada letra del texto segun el alfabeto.
*/
import java.util.Scanner;
import javax.print.attribute.standard.NumberOfDocuments;
public class Ejercicio14 {
    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introduce el texto deseado: ");
        String textodeseado = teclado.nextLine().trim().toUpperCase();
        
        mostrarArray(indiceAlfabetico(textodeseado));
    }

    static int[] indiceAlfabetico(String texto){
        char[] alfabeto = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        //String[] alfabeto ={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        int[] indice = new int [texto.length()];
        for (int i = 0; i < texto.length(); i++){
            int numerocaracter = texto.charAt(i);

            for (int j = 0; j < alfabeto.length; j++){
                int numeroalfabeto = alfabeto[j];

                if (numerocaracter == numeroalfabeto){
                    indice[i] += j + 1;
                    break;
                }
            }
        }
        return indice;
    }

    static void mostrarArray(int[] indice){
        String serie = "";
        for (int i = 0; i < indice.length; i++){
            serie += indice[i];
            if (i < indice.length - 1){ serie += ", ";}
        }

        System.out.print("Las letras del texto introducido se encuentran en las siguientes posiciones del alfabeto: \n\t" + serie);
    }
}
