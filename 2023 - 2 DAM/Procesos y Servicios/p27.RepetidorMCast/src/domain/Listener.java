package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;

public class Listener extends Thread{
	private DatagramPacket inS;
	private byte [] buffer = new byte[2048];
	private PrintWriter flujoS;
	private BufferedReader pipedE;
	private boolean fin;
	private boolean suscrito;
	
	public Listener(PrintWriter flujoS, BufferedReader pipedE) {
		this.flujoS = flujoS;
		this.pipedE = pipedE;
		this.fin = false;
		this.suscrito = false;
		this.start();
	}

	public void run() {
		String mensa;
		while (!fin) {
			try {
				mensa = pipedE.readLine();
				if (suscrito) {
					flujoS.println(mensa);
					flujoS.flush();
				}
			
			} catch (Exception e) {
				fin = true;
			}
		}
	}

	public void suscribir() {
		this.suscrito = true;
	}

	public void close() {
		try {
			fin = true;
			pipedE.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void nosuscribir() {
		this.suscrito = false;
	}
}
