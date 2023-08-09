package domain;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Sincro {
	private int maxIntervalos;
	private CyclicBarrier inicioConcurrente;
	private CountDownLatch esperaFinPadre;
	
	public Sincro(int maxIntervalos) {
		this.maxIntervalos = maxIntervalos;
		this.inicioConcurrente = new CyclicBarrier(maxIntervalos);
		this.esperaFinPadre = new CountDownLatch(maxIntervalos);
	}

	public void inicioConcurrenteAwait() {
		try {
			this.inicioConcurrente.await();
			
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
	public void esperaFinPadreFinHilo() {
		this.esperaFinPadre.countDown();
	}
	
	public void esperaFinPadreEspera() {
		try {
			this.esperaFinPadre.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
