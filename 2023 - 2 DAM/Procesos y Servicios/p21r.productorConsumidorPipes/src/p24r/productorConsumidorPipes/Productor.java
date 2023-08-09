package p24r.productorConsumidorPipes;

import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.Random;

public class Productor extends Thread {
    private PrintWriter flujoS;
    private int contador;
	
    public Productor(PipedWriter emisor1) {
		this.flujoS = new PrintWriter(emisor1);
		this.contador = 0;
		this.start();
	}

	public void run() {
		boolean fin = false;
		Random aleatorio = new Random();
		long espera;
		while (!fin) {
			generarMensaje();
			espera = aleatorio.nextInt(500)+1000;
			try {
				sleep(espera);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void generarMensaje() {
		String mensa = "Mensaje# "+contador;
		contador++;
		flujoS.println(mensa);
		System.out.println("Productor crea "+mensa);
		
	}
}
