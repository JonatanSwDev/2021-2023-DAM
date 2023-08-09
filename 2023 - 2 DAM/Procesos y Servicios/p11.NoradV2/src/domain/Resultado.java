package domain;	

public class Resultado {
	private int aciertos;
	
	public Resultado() {
		this.aciertos = 0;
	}

	public void contarAcierto() {
		//cección crítica poner semáforo
		this.aciertos++;
		
	}

}
