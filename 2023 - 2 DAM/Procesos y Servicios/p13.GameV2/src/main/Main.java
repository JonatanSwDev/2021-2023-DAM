package main;

import domain.Partida;

public class Main {

	private static int DISPAROS = 30;
	private static int TIEMPO_JUEGO = 180;
	
	public static void main(String[] args) {
	  Partida miPartida = new Partida(DISPAROS,TIEMPO_JUEGO);
	  miPartida.start();

	}

}
