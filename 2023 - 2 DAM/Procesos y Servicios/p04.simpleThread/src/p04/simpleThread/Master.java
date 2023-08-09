package p04.simpleThread;

import java.util.Random;

public class Master {

	public static void main(String[] args) {
		
		Hilo miHilo[] = new Hilo[10];
		//Creamos los hilos
		for (int i= 0; i < 10; i++) {
			miHilo[i] = new Hilo();
		}
		//Ejecutamos los hilos
		for (int i= 0; i < 10; i++) {
			miHilo[i].start();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Paramos los hilos
		for (int i= 0; i < 10; i++) {
			miHilo[i].setParar();
			//esperamos que termine
			try {
				miHilo[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//miHilo[i].interrupt();
		}
		System.out.println("Hemos terminado");
	}

}
