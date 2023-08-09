package p24r.productorConsumidorPipes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;

public class Consumidor extends Thread {
	BufferedReader flujoE;
	int id;
	public Consumidor(int id, PipedReader receptor1) {
		this.flujoE = new BufferedReader(receptor1);
		this.id = id;
		this.start();
	}
	
	public void run() {
		boolean fin = false;
		String mensa;
		try {
			while (!fin) {
				mensa = flujoE.readLine();
				System.out.println(id+" Recibido "+mensa);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
