package main;

import domain.Partida;

public class Main {
	private static final int MAX_TIPO1 = 4;
	private static final int MAX_TIPO2 = 4;
	private static final int MAX_TIPO3 = 4;
	private static final int DINERO_JUGADOR = 1000;
	private static final int DINERO_BANCA = 50000;
	
	public static void main(String[] args) {
		
		 Partida miPartida = new Partida(MAX_TIPO1,MAX_TIPO2,MAX_TIPO3,
				 DINERO_JUGADOR,DINERO_BANCA);
		 miPartida.iniciar();

	}

}
