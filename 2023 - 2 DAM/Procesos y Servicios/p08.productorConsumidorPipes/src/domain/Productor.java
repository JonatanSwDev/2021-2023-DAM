package domain;

import java.io.PipedWriter;
import java.io.PrintWriter;

public class Productor  extends Thread{
	private PrintWriter flujoS;

	public Productor(PrintWriter flujoS) {
		this.flujoS = flujoS;
	}

	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flujoS.println("Emitiendo");
	}
}
