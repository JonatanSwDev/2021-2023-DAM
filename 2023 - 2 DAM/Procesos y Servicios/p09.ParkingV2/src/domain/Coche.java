package domain;

import java.util.Random;

public class Coche extends Thread{
	private Parking parking;
	private int id;
	
	public Coche(int id, Parking parking) {
		this.id = id;
		this.parking = parking;
		this.start();
	}

	public void run() {
		Random aleatorio = new Random();
		
		try {
			Thread.sleep(aleatorio.nextInt(100));
			
			parking.entrarParking(this.id);
			System.out.println("El coche "+id+" entra al parking");
			
			Thread.sleep(aleatorio.nextInt(500));
			System.out.println("El coche "+id+" sale del parking");
			parking.salirParking();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
