package Practica4;
/*
Ejercicio13.java
Fecha: 22/12/2021
Autor: Jonatan Gomez Garcia
Programa que declara el metodo maxima3() que recibe una matriz rectangular de tamaño (n,m) con datos.
Devuelve una una submatriz de tamaño (3,3), cuyos valores sumen el valor máximo dentro de la matriz recibida.
*/

public class Ejercicio13 {
    public static void main(String[] args) {
            
        // Declaración de la matriz.
        int[][] matriz = {
                          { 0, 2, 4, 0, 9, 5 },
                          { 7, 1, 3, 3, 2, 1 },
                          { 1, 3, 9, 8, 5, 6 },
                          { 4, 6, 7, 9, 1, 0 }
        };
    
        double[][] matriz3x3 = maxima3(matriz);

        mostrarArray(matriz3x3);
        }
        
        static double[][] maxima3(int[][] matriz){
        double maxSuma = Integer.MIN_VALUE;

            for (int fila = 0; fila < matriz.length - 1; fila++) {
                for (int colum = 0; colum < matriz[0].length - 1; colum ++){
                    double suma = matriz[fila][colum] +  
                    matriz[fila][colum + 1] +
                    matriz[fila + 1][colum]+
                    matriz[fila + 1][colum + 1];
                    if (suma > maxSuma) {
                        maxSuma = suma;
                    }
                }   
            }
            double[][] suma3x3 = new double[3][3];
            double maxDouble = maxSuma / 9;
        for (int i = 0; i < suma3x3.length; i++){
            for (int j =0; j < suma3x3.length; j++){
                suma3x3[i][j] = maxDouble;
            }
        }
        return suma3x3;
    }

    static void mostrarArray(double [][] secuencia){
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

        
}

