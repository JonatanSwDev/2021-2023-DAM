package domain;

import java.util.concurrent.Semaphore;

public class Almacen {

	private int productosRestantes;
	
	private Semaphore puerta = new Semaphore(1);
	
	public Almacen(int maxProductos) {
		this.productosRestantes = maxProductos;
	}

	public boolean getPuerta() {
		return puerta.tryAcquire();
	}

	public synchronized boolean getProducto() {
		if (productosRestantes > 0) {
			productosRestantes--;
			return true;
		}
		else {
			return false;
		}
	}

	public void liberaPuerta() {
		puerta.release();
		
	}

}
