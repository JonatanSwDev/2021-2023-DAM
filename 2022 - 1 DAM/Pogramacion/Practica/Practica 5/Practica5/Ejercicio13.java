package Practica5;
/*
Ejercicio13.java
Fecha: 11/02/2022
Autor: Jonatan Gomez Garcia
Programa que, usando un método que recibe un vector de enteros que representa una fecha,
determina si la fecha es válida o no lo es
*/
public class Ejercicio13 {
    public static void main(String[] args){
        int[] fecha0 = {28,02,1996};
        int[] fecha1 = {21,04,1994};
        int[] fecha2 = {31,02,2021};
        int[] fecha3 = {15,03,2020};
        int[] fecha4 = {30,06,2022};
        int[] fecha5 = {31,07,2022};
        int[] fecha6 = {31,04,1994};
        int[] fecha7 = {01,01,3001};
        int[] fecha8 = {31,10,2030};
        int[] fecha9 = {31,9,2031};

        System.out.println("La fecha " + 0 + " devuelve " + fechaValida(fecha0));
        System.out.println("La fecha " + 1 + " devuelve " + fechaValida(fecha1));
        System.out.println("La fecha " + 2 + " devuelve " + fechaValida(fecha2));
        System.out.println("La fecha " + 3 + " devuelve " + fechaValida(fecha3));
        System.out.println("La fecha " + 4 + " devuelve " + fechaValida(fecha4));
        System.out.println("La fecha " + 5 + " devuelve " + fechaValida(fecha5));
        System.out.println("La fecha " + 6 + " devuelve " + fechaValida(fecha6));
        System.out.println("La fecha " + 7 + " devuelve " + fechaValida(fecha7));
        System.out.println("La fecha " + 8 + " devuelve " + fechaValida(fecha8));
        System.out.println("La fecha " + 9 + " devuelve " + fechaValida(fecha9));
     
    }
    static boolean fechaValida(int[] fecha){
        boolean esValida = false;
        int espar = fecha[1] % 2;
        if (fecha[2] > 0 && fecha[2] <= 3000){
            if (fecha[1] >= 01 && fecha[1] <= 12 && fecha[0] > 0 && fecha[0] <=31){
                if (fecha[1] == 2 && fecha[0] <= 28){
                    return true;
                }
                if (fecha[1] >= 01 && fecha[1] <= 07){
                    if (espar != 0 && fecha[0] <= 31){
                        return true;
                    } else if (espar == 0 && fecha[0] <=30){
                        return true;
                    }
                }
                if (fecha[1] >= 8){
                    if (espar != 0 && fecha[0] <= 30){
                        return true;
                    } else if (espar == 0 && fecha[0] <=31){
                        return true;
                    }
                }
            }

        }
        




        return esValida;
    }
    
}
