package domain;

import java.io.BufferedReader;
import java.util.Random;

public class Misil extends Thread {
	private int id;
	private Sincroniza sincro;
	
	public Misil(int id, BufferedReader bufferedReader, Resultado resultado, Sincroniza sincro) {
		this.id = id;
		this.sincro = sincro;
		this.start();
	}

	public void run() {
		Random aleatorio = new Random();
		try {
			System.out.println("Misil "+id+" armándose");
			Thread.sleep(aleatorio.nextInt(1000)+200);
			sincro.misilArmado(id);
			sincro.esperaLanzamiento();
			System.out.println("Misil "+id+" lanzado");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
