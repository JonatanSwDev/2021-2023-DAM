package domain;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Cliente extends Thread {

	private int id;
	private CyclicBarrier inicioConcurrente;
	private CountDownLatch esperaFin;
	private Cuenta miCuenta;
	private char tipoOp;
	private int cantidadOp;
	
	public Cliente(int id, CyclicBarrier inicioConcurrente, 
			CountDownLatch esperaFin, 
			Cuenta miCuenta, 
			char tipoOp,
			int cantidadOp) {
		this.id = id;
		this.inicioConcurrente = inicioConcurrente;
		this.esperaFin = esperaFin;
		this.tipoOp = tipoOp;
		this.cantidadOp = cantidadOp;
		this.miCuenta = miCuenta; 
		this.start();
	}

	public void run() {
		int result;
		Random miRandom = new Random();
		long espera;
		String tipoOpTexto = ""; 
		
		//esperamos el inicio concurrente
		try {
			this.inicioConcurrente.await();
			espera = miRandom.nextInt(500);
			sleep(espera);
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	    result = 0;
		if (this.tipoOp == 'I') {
			result = miCuenta.ingresar(this.cantidadOp);
			tipoOpTexto = "ingresado ";
		} else if (this.tipoOp == 'R') {
			result = miCuenta.retirar(this.cantidadOp);
			tipoOpTexto = "retirado ";
		}
		System.out.println("El hilo "+id+" ha "
					+tipoOpTexto+this.cantidadOp+
					" "+result);
		//notificamos al padre la finalización
		esperaFin.countDown();
		
	}
}







