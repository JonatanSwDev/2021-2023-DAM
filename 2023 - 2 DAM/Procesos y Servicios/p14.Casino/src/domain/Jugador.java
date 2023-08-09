package domain;

import java.util.Random;

public class Jugador extends Thread{
	private int id;
	private char tipoJugador;
	private Banca banca;
	private Ruleta ruleta;
	private int dineroJugador;
	private boolean finPartida;
	
	public Jugador(int id, char tipoJugador, Banca banca, Ruleta ruleta, int dineroJugador) {
		this.id = id;
		this.tipoJugador = tipoJugador;
		this.banca = banca;
		this.ruleta = ruleta;
		this.dineroJugador = dineroJugador;
		this.finPartida = false;
	}

	public void run() {
		Random aleatorio = new Random();
		int numeroApostar;
		int saleNumero;
		
		while (!finPartida) {
			if (tipoJugador == 'N') {
				numeroApostar = aleatorio.nextInt(36)+1;
				banca.apostar(id,'N',numeroApostar,10);
				dineroJugador -= 10;
				saleNumero = ruleta.getNumero();
			}
		}
	}
}
