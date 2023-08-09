package Practica5;
/*
Ejercicio2.java
Fecha: 11/01/2022
Autor: Jonatan Gomez Garcia
Programa que, usando un método que recibe una ecuación con paréntesis, comprueba si los paréntesis están
correctamente colocados y devuelve true si está bien colocado o false si no lo está
*/
public class Ejercicio2 {
    public static void main(String[] args){
        String ecuacion1 = "(15+15)/(12-10)";
        String ecuacion2 = "(15+15)/12-10)";

        System.out.println("La ecuacion1 devuelve " + parentesisCorrectos(ecuacion1));
        System.out.println("La ecuacion2 devuelve " + parentesisCorrectos(ecuacion2));
    }

    static boolean parentesisCorrectos(String ecuacion){
        int contador = 0;
        for (int i = 0; i < ecuacion.length(); i++){
            if (ecuacion.charAt(i) == '('){
                contador++;
            }
            if (ecuacion.charAt(i) == ')'){
                contador--;
            }
        }

        if (contador == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
