package domain;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Resource {
	Semaphore maxConcurrencia;
	CyclicBarrier inicioConcurrente;
	CountDownLatch esperaFinHilos;

	public Resource(int maxConcurrencia, int maxHilos) {
		this.maxConcurrencia = new Semaphore(maxConcurrencia);
		this.inicioConcurrente = new CyclicBarrier(maxHilos);
		this.esperaFinHilos = new CountDownLatch(maxHilos);
		
	}

	public void getAcceso() {
		try {
			this.maxConcurrencia.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void releaseAcceso() {
		this.maxConcurrencia.release();
	}

	public void inicioConcurrente() {
		try {
			this.inicioConcurrente.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	
	public void esperaFinHilos() {
		try {
			esperaFinHilos.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void notificaFinHilo() {
		this.esperaFinHilos.countDown();;
	}
	
}
