package domain;

import java.util.concurrent.CountDownLatch;

public class Sincroniza {

	private CountDownLatch esperaPadreMisilesArmados;
	private CountDownLatch esperaMisilesLanzamiento;
	
	public Sincroniza(int maxMisiles) {
		this.esperaPadreMisilesArmados = new CountDownLatch(maxMisiles);
		this.esperaMisilesLanzamiento = new CountDownLatch(1);
	}

	public void esperarMisilesArmados() {
		try {
			this.esperaPadreMisilesArmados.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void misilArmado(int id) {
		System.out.println("Misil "+id+" armádo");
		esperaPadreMisilesArmados.countDown();
		
	}

	public void lanzarMisiles() {
		esperaMisilesLanzamiento.countDown();
		
	}

	public void esperaLanzamiento() {
		try {
			esperaMisilesLanzamiento.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
