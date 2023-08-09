package domain;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Parking {
	private Semaphore cochesParking;
	
	public Parking(int capacidad) {
		this.cochesParking = new Semaphore(capacidad);
	}

	public void entrarParking(int id) {
		Random aleatorio = new Random();
		try {
			while (!cochesParking.tryAcquire()) {
				System.out.println("El coche "+id+" intenta entra al parking");
				Thread.sleep(aleatorio.nextInt(500)+500);
			}
			//cochesParking.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void salirParking() {
		cochesParking.release();
		
	}

}
