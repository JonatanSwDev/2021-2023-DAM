package Practica6;

import java.util.LinkedList;
import java.util.Queue;

public class E07Cola {

	public static void main(String[] args) {
		Queue<String> mensajes = new LinkedList<String>();
		mensajes.offer("Mensaje Uno");
		mensajes.offer("Mensaje Dos");
		mensajes.offer("Mensaje Tres");
		mensajes.offer("Mensaje Cuatro");
		
		while (mensajes.size() > 0) {
			String msg = mensajes.poll();
			System.out.println("\nElemento actual: " + msg);
			System.out.println("Cola: " + mensajes);
		}
	}
}
