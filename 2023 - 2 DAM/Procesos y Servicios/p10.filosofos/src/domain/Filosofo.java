package domain;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
	
public class Filosofo extends Thread{
	private final int MAX_COMIDAS = 3;
	private int id;
	private Semaphore palilloIzq;
	private Semaphore palilloDer;
	private int comidas;
	private CyclicBarrier inicioConcurrente;
	
	public Filosofo(int id, Semaphore palilloIzq, Semaphore palilloDer, CyclicBarrier inicioConcurrente) {
		this.id = id;
		this.palilloIzq = palilloIzq;
		this.palilloDer = palilloDer;
		this.inicioConcurrente = inicioConcurrente;
		this.start();
	}
	
	public void run() {
		try {
			inicioConcurrente.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		while(comidas < MAX_COMIDAS) {
			pensar();
			comer();
		}
		System.out.println("Filósofo "+id+" terminado");
	}

	private void comer() {
		//intentar coger palillo izquierdo
		if (palilloIzq.tryAcquire()) {
			System.out.println("Filósofo "+id+" tiene palillo Izquierdo");
			//intenta coger palillo derecho
			if (palilloDer.tryAcquire()) {
				System.out.println("Filósofo "+id+" comiendo");
				esperar();
				comidas++;
				//hemos terminado liberamos todo
				palilloIzq.release();
				palilloDer.release();
			}
			//si no coge palillo izq lo debe liberar
			else {
				System.out.println("Filósofo "+id+" libera palillo Izquierdo");
				palilloIzq.release();
			}
		}
		else {
			esperar();
		}
	}

	private void pensar() {
		System.out.println("Filósofo "+id+" pensado");
		esperar();
	}

	private void esperar() {
		Random aleatorio = new Random();
		try {
			Thread.sleep(aleatorio.nextInt(500)+500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
