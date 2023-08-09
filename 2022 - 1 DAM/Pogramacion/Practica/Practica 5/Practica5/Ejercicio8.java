package Practica5;
/*
Ejercicio8.java
Fecha: 09/02/2022
Autor: Jonatan Gomez Garcia
Programa que, usando un método que recibe una URL devuelve las diferentes partes de la URL
Protocolo, Host, y Ruta
*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio8 {
    public static void main(String[] args){
        String url = "http://www.devbg.org/forum/index.php";
        String[] urlSeparado = separarURL(url);
        for(int i = 0; i < urlSeparado.length; i++){
            System.out.println(urlSeparado[i]);
        }
    }

    static String[] separarURL(String url){
        String regex = "^(?:([^:]*):(?://))([^/]*)(/.*)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        String[] resultado = new String[3];
        
        if (matcher.find()) {
            resultado[0] = matcher.group(1);
            resultado[1] = matcher.group(2);
            resultado[2] = matcher.group(3);
        }
        return resultado;
    }
}
    

