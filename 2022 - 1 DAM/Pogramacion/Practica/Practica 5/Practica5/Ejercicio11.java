package Practica5;
/*
Ejercicio11.java
Fecha: 11/02/2022
Autor: Jonatan Gomez Garcia
Programa que, usando un método devuelve la hora actual con un formato determinado
*/
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ejercicio11 {
    public static void main(String[] args){

        System.out.println("La hora es: " + horaActual());
    }
    
    static String horaActual(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        String fecha = formato.format(LocalDateTime.now());

        return fecha;
    }
    
    
}
