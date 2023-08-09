package domain;

import java.io.PrintWriter;

public class Intervalo extends Thread {
	private int id;
	private float x_i;
	private float x_j;
	private PrintWriter flujoS;
	private Sincro sincro;
	
	public Intervalo(int id, float x_i, float x_j, PrintWriter flujoS, Sincro sincro) {
		this.id = id;
		this.x_i = x_i;
		this.x_j = x_j;
		this.flujoS = flujoS;
		this.sincro = sincro;
		this.start();
	}

	public void run() {
		float area = 0;
		//Espera para inicio concurrente
		sincro.inicioConcurrenteAwait();
		
		//Determinar el área
		//System.out.println("Hilo id F("+x_i+")="+F(x_i));
		area = ((F(x_i) + F(x_j)) / 2) * (x_j - x_i);
		flujoS.println(area);
		System.out.println("Hilo "+id+" calcula "+area);
		//Notificar al padre que hemos terminado
		sincro.esperaFinPadreFinHilo();
	}

	private float F(float x) {
		float y;
		//Función x²
		y = x * x;
		return y;
	}
}
