package main;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import domain.Almacen;
import domain.Cliente;

public class Main {

	public static void main(String[] args) {
		final int MAX_CLIENTES = 200;
		final int MAX_PRODUCTOS = 10;
		
		Cliente [] cliente = new Cliente[MAX_CLIENTES];

		CyclicBarrier inicioConcurrente = 
				new CyclicBarrier(MAX_CLIENTES);
		CountDownLatch esperaFinClientes = 
				new CountDownLatch(MAX_CLIENTES);
		Almacen almacen = new Almacen(MAX_PRODUCTOS);
		
		for (int i=0; i < MAX_CLIENTES; i++) {
			cliente[i] = new Cliente(i,inicioConcurrente,
					esperaFinClientes,almacen);
		}
		
		//Esperamos que todos los clientes finalicen
		try {
			esperaFinClientes.await();
			Thread.sleep(300);
			System.out.println("Simulación terminada");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
