package domain;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Cliente extends Thread{
	private int id;
	private CyclicBarrier inicioConcurrente;
	private CountDownLatch esperaFinClientes;
	private Almacen almacen;
	private final int MAX_INTENTOS = 10;
	
	public Cliente(int id, CyclicBarrier inicioConcurrente, CountDownLatch esperaFinClientes, Almacen almacen) {
		this.id = id;
		this.inicioConcurrente = inicioConcurrente;
		this.esperaFinClientes = esperaFinClientes;
		this.almacen = almacen;
		this.start();
	}
	
	public void run() {
		//Inicio concurrente
		try {
			this.inicioConcurrente.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		//////////////////////////////////
		// intentamos entrar un número de veces 
		for (int i=0;i<MAX_INTENTOS;i++) {
			if (almacen.getPuerta()) {
				if (almacen.getProducto()) {
					System.out.println("El cliente "+id+
							" ha conseguido comprar");
				}
				almacen.liberaPuerta();
				break;
			}
			else {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		//////////////////////////////////
		//Comunicamos fin al padre
		this.esperaFinClientes.countDown();
	}

}
