package practica1;

/**
 * Saludos.java
 * Programa simple con ejemplos de declaración de variables y uso de las mismas mostrando mensajes en pantalla
 * JGG - 8/10/2021
 */

import java.util.Scanner;

public class Saludos {
	public static void main(String[] args) {
		/* teclado es un canal de entrada por teclado a través de un Scanner.
		   Necesita importar el paquete java.util
		 */
		Scanner teclado = new Scanner(System.in); //Declaración de un objeto tipo Scaner, no será utilizado

		int numOrden;			// Declaración de una variable numérica
		String nombre = "";		// Declaración de variable de texto, no va a ser usada 

			// Configura y muestra mensajes de bienvenida.
		numOrden = 1 ; 	//Definición del valor para la varible previamente definida
		System.out.println("Hola,");	//Salida de texto
		System.out.print("Soy un modesto "); 	//Salida de texto
		System.out.print("programa de ordenador...\n");		//Salida de texto
		System.out.println("Bienvenido al Curso.\t" + "Este es el saludo nº " + numOrden);	//Salida de texto con ejecución de variable
		numOrden++;		//Suma del valor de la variable
		System.out.println("Bienvenido a Java.\t" + "Este es el saludo nº " + numOrden);	//Salida de texto con ejecución de variable previamente sumada
		System.out.println("\nFin programa..."); 	//Salida de texto
	}
}