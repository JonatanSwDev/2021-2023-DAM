package p05.threadJoin;

public class MiHilo implements Runnable {
	public void run() {
		System.out.println("Iniciando Thread:::"+Thread.currentThread().getName());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finalizando	Thread:::"+Thread.currentThread().getName());
	}
}
