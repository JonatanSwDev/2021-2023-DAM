package p05.threadJoin;

public class ThreadJoin {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MiHilo(), "t1");
		Thread t2 = new Thread(new MiHilo(), "t2");
		Thread t3 = new Thread(new MiHilo(), "t3");
		t1.start();
		//iniciar segunda tarea después de esperar 2 segundos o que t1
		try {
			t1.join(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		//iniciar tercera tarea después de que t1 haya terminado
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t3.start();
		//esperamos que todas las tareas finalicen antes de continuar
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Todas las tareas han terminado, terminando el main");

	}

}
