package domain;

public class Banca {

	private int dineroBanca;
	private Ruleta ruleta;
	private int numJugadores;
	private int [][] apuestas;
	
	public Banca(int dineroBanca, Ruleta ruleta, int numJugadores) {
		this.dineroBanca = dineroBanca;
		this.ruleta = ruleta;
		// para cada jugador guardo el número y la cantidad
		apuestas = new int [numJugadores][2];
	}

	public void apostar(int id, char tipoApuesta, int numero, int cantidad) {
		if (tipoApuesta == 'N') {
			apuestas[id][0] = numero;
			apuestas[id][1] = cantidad;
		}
		
	}

}
