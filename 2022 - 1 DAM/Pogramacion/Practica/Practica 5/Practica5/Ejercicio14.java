package Practica5;
/*
Ejercicio14.java
Fecha: 11/02/2022
Autor: Jonatan Gomez Garcia
Programa que, usando un método que recibe una fecha en forma de texto,
determina si la fecha es válida o no lo es.
*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio14 {
    public static void main(String[] args){
        String fecha0 = "28/02/1996";
        String fecha1 = "21/04/1994";
        String fecha2 = "31/02/2021";
        String fecha3 = "15/03/2020";
        String fecha4 = "30/06/2022";
        String fecha5 = "31/07/2022";
        String fecha6 = "31/04/1994";
        String fecha7 = "01/01/3001";
        String fecha8 = "31/10/2030";
        String fecha9 = "31/9/2031";

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
    static boolean fechaValida(String fechatexto){
        String regex = "^(\\d+)/(\\d+)/(\\d+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fechatexto);
        
        int[] fecha = new int[3];
        if (matcher.find()) {
            fecha[0] = Integer.valueOf(matcher.group(1));
            fecha[1] = Integer.valueOf(matcher.group(2));
            fecha[2] = Integer.valueOf(matcher.group(3));
            }

            System.out.println(fecha[0]+ " " + fecha[1] + " " + fecha[2]);

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
