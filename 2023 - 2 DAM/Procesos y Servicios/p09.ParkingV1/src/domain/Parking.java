package domain;

import java.util.concurrent.Semaphore;

public class Parking {
	private Semaphore cochesParking;
	
	public Parking(int capacidad) {
		this.cochesParking = new Semaphore(capacidad);
	}

	public void entrarParking() {
		try {
			cochesParking.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void salirParking() {
		cochesParking.release();
		
	}

}
