package p03.simpleThreadRunnable;

import java.util.Random;

public class HelloRunnable implements Runnable {
	public void run() {
		Random rnd = new Random();
		int espera = rnd.nextInt(1000);
		try {
			Thread.sleep(espera);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hello from a thread! "+
				Thread.currentThread().getName());
	}
	
	public static void main(String args[]) {
		Thread h1 = new Thread(new HelloRunnable());
		Thread h2 = new Thread(new HelloRunnable());
		h1.start();
		h2.start();
	}
}