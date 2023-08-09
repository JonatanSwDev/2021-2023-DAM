package Practica5;
/*
Ejercicio12.java
Fecha: 11/02/2022
Autor: Jonatan Gomez Garcia
Programa que, usando un método devuelve la fecha y hora actual actualizada cada segundo
*/
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ejercicio12 {
    public static void main(String[] args) throws InterruptedException{

        while (true){
        System.out.println("Fecha y hora: " + fechahoraActual());
        Thread.sleep(1000);
        }
    }
    
    static String fechahoraActual(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fecha = formato.format(LocalDateTime.now());

        return fecha;
    }
    
    
}
