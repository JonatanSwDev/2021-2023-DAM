package p06.CarreraCaballos;

import java.util.Random;

public class Caballo extends Thread {
	private static final int PISTA = 1000;
	private static boolean corriendo = false;
	private static int caballoGanador = -1; 
	private int dorsal;
	private int posicion;
	
	public Caballo(int dorsal) {
		this.dorsal = dorsal;
		this.posicion = 0;
		//this.start();
	}

	public void run() {
		int avance;
		Random miAleatorio = new Random();
		
		//esperan ser lanzados
		while (!corriendo);
		//empiezan a correr
		while (this.posicion < PISTA) {
			avance = miAleatorio.nextInt(50);
			posicion = posicion + avance;
			System.out.println("Caballo "+dorsal+" posi:"+posicion);
			try {
				Thread.sleep(miAleatorio.nextInt(200));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//end-while
		System.out.println("Caballo "+dorsal+" meta!!");
		if (caballoGanador == -1) {
			caballoGanador = this.dorsal;
		}
	}//end-run
	
	public static void iniciarCarrera() {
		Caballo.corriendo = true;
	}
	
	public static int getCaballoGanador() {
		return caballoGanador;
	}
}
