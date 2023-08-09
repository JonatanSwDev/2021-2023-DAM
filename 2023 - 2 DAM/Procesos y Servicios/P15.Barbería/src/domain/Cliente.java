package domain;

import java.util.Random;

public class Cliente extends Thread {

	private int id;
	private GestorSillas gestorSillas;
	
	
	public Cliente(int id, GestorSillas gestorSillas) {
		this.id = id;
		this.gestorSillas = gestorSillas;
		this.start();
	}

	public void run() {
		Random miAleatorio = new Random();
		int espera;
		int sillaAsignada;
		
		espera = miAleatorio.nextInt(1000)+300;
		try {
			Thread.sleep(espera);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sillaAsignada = gestorSillas.getSilla(id);
		if (sillaAsignada != -1) {
			//Esperamos ser afeitados
			System.out.println("El cliente "+id+" se sienta en la silla "+sillaAsignada);
		}
		else {
			System.out.println("No hay silla libres, me marcho "+id);
		}
	}
}
