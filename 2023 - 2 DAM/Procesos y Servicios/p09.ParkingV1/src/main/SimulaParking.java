package main;

import domain.Coche;
import domain.Parking;

public class SimulaParking {
	static final int CAPACIDAD = 50;
	static final int SIMULA = 250;
	
	public static void main(String[] args) {
		//Creamos array de coches
		Coche [] coche = new Coche[SIMULA];
		Parking parking = new Parking(CAPACIDAD);
		
		//tiempo simulación
		long inicioSimulacion = System.currentTimeMillis();
		long finSimulacion;
		long tiempoSimulacion;
		System.out.println("Iniciando Simulación");
		for (int i = 0; i < SIMULA; i++) {
			coche[i] = new Coche(i,parking);
			
		}
		
		//Esperamos que todos los coches terminen
		for (Coche co : coche) {
			try {
				co.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		finSimulacion = System.currentTimeMillis();
		tiempoSimulacion = finSimulacion - inicioSimulacion;
		
		System.out.println("La Simulación ha tardado "+tiempoSimulacion+" ms");
	}

}
