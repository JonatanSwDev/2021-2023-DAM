package Practica4;
/*
Ejercicio5.java
Fecha: 21/12/2021
Autor: Jonatan Gomez Garcia
Programa que declara un metodo que recibe un array de caracter y comprueba el valor numérico asociado alfabéticamente
el método devuelve un número entero que determina si la comparativa entre dos vectores es mayor, menor o igual alfabéticamente
*/
public class Ejercicio5 {
    public static void main(String[] args) {

        char[] vector1 = {'a','b','c','d','e','f','h','i','j'};
        char[] vector2 = {'a','a','b','c','d','e','f','h','i'};
        char[] vector3 = {'j','b','c','d','e','f','h','i','j'};
        char[] vector4 = {'a','b','c','d','e','f','h','i','j'};

        int resultado1 = compararVectoresChar(vector1, vector2);
        int resultado2 = compararVectoresChar(vector1, vector3);
        int resultado3 = compararVectoresChar(vector1, vector4);
    
        System.out.println("El valor devuelto comparando vector1 y vector2 es: " + resultado1);
            if (resultado1 == 0){
                System.out.println("Los vectores son iguales");
            } else if (resultado1 == 1){
                System.out.println("Vector1 es mayor que Vector2");
            } else if (resultado1 == -1){
                System.out.println("Vector 1 es menor que Vector2");
            }

        System.out.println("\nEl valor devuelto comparando vector1 y vector3 es: " + resultado2);
            if (resultado2 == 0){
                System.out.println("Los vectores son iguales");
            } else if (resultado2 == 1){
                System.out.println("Vector1 es mayor que Vector3");
            } else if (resultado2 == -1){
                System.out.println("Vector 1 es menor que Vector3");
            }
            
            System.out.println("\nEl valor devuelto comparando vector1 y vector4 es: " + resultado3);
            if (resultado3 == 0){
                System.out.println("Los vectores son iguales");
            } else if (resultado3 == 1){
                System.out.println("Vector1 es mayor que Vector4");
            } else if (resultado3 == -1){
                System.out.println("Vector 1 es menor que Vector4");
            }
    }

    static int compararVectoresChar(char[] vector1, char[] vector2){
        int valorV1 = 0;
        int valorV2 = 0;
        for(int i = 0; i < vector1.length; i++){
            valorV1 += vector1[i];
        }
        for(int i = 0; i < vector2.length; i++){
            valorV2 += vector2[i];
        }
        
        if (valorV1 > valorV2){
            return 1;
        } else if (valorV1 < valorV2){
            return -1;
        } else {
            return 0;
        }
    }
}
