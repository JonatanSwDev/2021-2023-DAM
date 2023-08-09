package main;

import domain.Barbero;
import domain.Cliente;
import domain.GestorSillas;

public class Main {

	public static void main(String[] args) {
		int MAX_BARBEROS = 5;
		int MAX_SILLAS = 10;
		int MAX_CLIENTES = 100;
		Barbero [] barbero = new Barbero[MAX_BARBEROS];
		Cliente [] cliente = new Cliente[MAX_CLIENTES];
		
		GestorSillas gestorSillas = new GestorSillas(MAX_SILLAS);
		boolean fin = false;
		
		//Creamos los barberos
		for (int i=0; i<MAX_BARBEROS;i++) {
			barbero[i] = new Barbero(i,gestorSillas);
		}
		
		//Creamos los clientes
		for (int i=0; i<MAX_CLIENTES;i++) {
			cliente[i] = new Cliente(i,gestorSillas);
		}
		
		//Esperamos que todos los clientes terminen
		//o por sentarse o porque no se han atendido
		for (int i=0; i<MAX_CLIENTES;i++) {
			try {
				cliente[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//Finalizar los barberos
		
		while (!fin) {
			if (gestorSillas.isEmpty()) {
				fin = true;
			}
			else {
				System.out.println("No termina");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i=0; i<MAX_BARBEROS;i++) {
			barbero[i].cerrarBarberia();
		}
		System.out.println("Barbería terminada");
	}

}
