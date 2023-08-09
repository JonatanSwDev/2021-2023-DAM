package Practica4;
/*
Ejercicio12.java
Fecha: 22/12/2021
Autor: Jonatan Gomez Garcia
Programa que declara metodos para representar unos valores con un patron establecido sobre la matriz
*/
public class Ejercicio12 {
    public static void main(String[] args){

        int[][] secuenciaA = secuenciaNaturalIntA(4);
        int[][] secuenciaB = secuenciaNaturalIntB(4);
        
        mostrarArray(secuenciaA);
        mostrarArray(secuenciaB);
       }
    
    static void mostrarArray(int [][] secuencia){
        String mostrarArray = "";
        for (int i = 0; i < secuencia.length; i++) {
            for (int j =0; j < secuencia[i].length; j++) {
                mostrarArray += secuencia[i][j];
                mostrarArray += " ";
            }
                mostrarArray += "\n";
        }
            System.out.println(mostrarArray);
    }

    static int[][] secuenciaNaturalIntA(int lado){
        int[][]secuenciaA = new int [lado][lado];
        for (int i = 0; i < lado; i++){
            for (int j = 0; j < lado; j++){
                if (j == 0){
                secuenciaA[i][j] = j + 1 + i;
                } else {
                    secuenciaA[i][j] = secuenciaA[i][j-1] + 4;
                }
            }
        }
        return secuenciaA;
    }
    
    static int[][] secuenciaNaturalIntB(int lado){
        int[][]secuenciaB = new int [lado][lado];
        for (int i = 0; i < lado; i++){
            for (int j = 0; j < lado; j++){
                
                if (i % 2 == 0 && i == 0){
                secuenciaB[j][i] = j + 1;
                }
                
                if (i % 2 == 0 && i != 0){
                    secuenciaB[j][i] = (lado*2) + secuenciaB[j][i-2];
                }
                
                if (i % 2 != 0 && i == 1){
                    secuenciaB[j][i] = (lado*2) - secuenciaB[j][i-1] + 1 ;
                }

                if (i % 2 != 0 && i != 1){
                    secuenciaB[j][i] = (lado * (i+1)) - secuenciaB[j][0] +1 ;

                }
            }
        }
        return secuenciaB;
    }
}
