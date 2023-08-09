package domain;

public class Partida {
	private int maxTipo1;
	private int maxTipo2;
	private int maxTipo3;
	private int dineroJugador;
	private int dineroBanca;
	
	public Partida(int maxTipo1, int maxTipo2, int maxTipo3, int dineroJugador, int dineroBanca) {
		this.maxTipo1 = maxTipo1;
		this.maxTipo2 = maxTipo2;
		this.maxTipo3 = maxTipo3;
		this.dineroBanca = dineroBanca;
		this.dineroJugador = dineroJugador;
	}

	public void iniciar() {
		Ruleta ruleta = new Ruleta();
		Banca banca = new Banca(dineroBanca,ruleta, maxTipo1+maxTipo2+maxTipo3);
		Jugador [] jugador = new Jugador[maxTipo1+maxTipo2+maxTipo3];
		//Creamos todos los jugadores
		for (int i=0; i < maxTipo1; i++) {
			//tipo N juega a un número
			jugador[i] = new Jugador(i,'N',banca,ruleta,dineroJugador);
		}
		for (int i=maxTipo1; i < maxTipo1+maxTipo2; i++) {
			//tipo P juega a par/impar
			jugador[i] = new Jugador(i,'P',banca,ruleta,dineroJugador);
		}
		for (int i=maxTipo1+maxTipo2; i < maxTipo1+maxTipo2+maxTipo3; i++) {
			//tipo M juega a martingala
			jugador[i] = new Jugador(i,'M',banca,ruleta,dineroJugador);
		}
	}

}
