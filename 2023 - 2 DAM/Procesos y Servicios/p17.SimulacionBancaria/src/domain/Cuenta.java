package domain;

import java.util.concurrent.Semaphore;

public class Cuenta {
	private int saldo;
	private Semaphore lock;
	
	public Cuenta(int saldo) {
		this.saldo = saldo;
		this.lock = new Semaphore(1);
	}

	public int ingresar(int cantidadOp) {
		//Sección-crítica
		try {
			this.lock.acquire();
			saldo += cantidadOp;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.lock.release();
		//End-Sección-crítica
		return 0;
	}

	public int retirar(int cantidadOp) {
		int op = 0;
		//Sección-crítica
		try {
			this.lock.acquire();
			if (saldo >= cantidadOp) {
				saldo -= cantidadOp;
				op = 0;
			}
			else {
				saldo -= cantidadOp;
				op = -1;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.lock.release();
		//End-Sección-crítica
		return op;
	}

	public int getSaldo() {
		int valorSaldo = 0;
		//Sección-crítica
		try {
			this.lock.acquire();
			valorSaldo = saldo;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.lock.release();
		//End-Sección-crítica
		return valorSaldo;
	}


}
