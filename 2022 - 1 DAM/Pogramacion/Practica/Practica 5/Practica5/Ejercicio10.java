package Practica5;
/*
Ejercicio10.java
Fecha: 11/02/2022
Autor: Jonatan Gomez Garcia
Programa que, usando un método devuelve la fecha actual con un formato determinado
*/
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ejercicio10 {
    public static void main(String[] args){

        System.out.println("Hoy es " + fechaActual());
    }
    
    static String fechaActual(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = formato.format(LocalDateTime.now());

        return fecha;
    }
    
    
}
