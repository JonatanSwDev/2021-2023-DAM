package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;

public class Consumidor extends Thread{
	private BufferedReader flujoE;
	
	public Consumidor(BufferedReader flujoE) {
		this.flujoE = flujoE;
	}

	public void run() {
		System.out.println("Consumidor funcionando");
		try {
			String msg = flujoE.readLine();
			System.out.println("Recibido > "+msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
