package p04.simpleThread;

import java.util.Random;

public class Hilo extends Thread{
	boolean parar = false;
	
	public void run() {
		Random rnd = new Random();
		int espera;
		
		
		while(!parar) {
			try {
				espera = rnd.nextInt(1000)+500;
				System.out.println(Thread.currentThread().getName() + 
					" funcionando");
				Thread.sleep(espera);
				if (Thread.interrupted()) {
					throw new InterruptedException();
				}
			} catch (InterruptedException e) {
					this.setParar();
			}
				//e.printStackTrace();
		}//end-while
		
		System.out.println(Thread.currentThread().getName() + 
				" finalizado");
	}

	public void setParar() {
		this.parar = true;
	}
}
