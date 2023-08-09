package Practica4;
/*
Ejercicio21.java
Fecha: 23/12/2021
Autor: Jonatan Gomez Garcia
Programa que pide un numero tope para buscar numeros primos hasta dicho numero.
*/
import java.util.Scanner;
import java.util.ArrayList;
public class Ejercicio21 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce tope en el que encontrar numeros primos: ");
        int n = teclado.nextInt();

        System.out.print("Numeros primos hasta el " + n + ": " + obtenerPrimos(n));
        teclado.close();
    }
        static ArrayList obtenerPrimos(int n){
        ArrayList<String> primos = new ArrayList();
        boolean[] primo = new boolean[n+1];  //Hay que poner n+1 para que cuente el numero 20 también
        for(int i = 0; i < primo.length ;i++){
            primo[i] = true;
        }

        for (int i = 2; i <= n; i++){
            // Actualiza todos los múltiplos de la i
            for(int j = 2; i*j <= n; j++){
                if (i*j < primo.length){
                    primo[i*j] = false; // Descartando numeros primos
                }
            }
        }
        
        for(int i = 2; i <= n; i++){
            if(primo[i] == true){
                String j = Integer.toString(i);
                primos.add(j);
            }
        }
        return primos;
    }
}
    
