package domain;

import java.util.concurrent.Semaphore;

public class Banco {
	private final int MAXCUENTAS = 1000;
	private Cuenta [] cuentas;
	private Semaphore [] bloqueo;
	private Semaphore lock = new Semaphore(1);
	
	public Banco() {
		super();
		cuentas = new Cuenta[MAXCUENTAS];
		bloqueo = new Semaphore[MAXCUENTAS];
		
		for (int i=0;i < MAXCUENTAS;i++) {
			cuentas[i] = new Cuenta(0);
			bloqueo[i] = new Semaphore(1);
		}
	}
	
	public float getSaldo(int nCuenta) {
		float saldo = 0;
		try {
			if (nCuenta < MAXCUENTAS) {
				lock.acquire();
				saldo = cuentas[nCuenta].getSaldo();
				lock.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return saldo;
	}
	
	public float setSaldo(int nCuenta, int saldo) {
		float nSaldo = 0;
		try {
			if (nCuenta < MAXCUENTAS) {
				lock.acquire();
				nSaldo = cuentas[nCuenta].setSaldo(saldo);
				lock.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return nSaldo;
	}
	
	public float setDeposito(int nCuenta, float cantidad) {
		float nSaldo = 0;
		try {
			if (nCuenta < MAXCUENTAS) {
				if (isBloqueada(nCuenta)== false) {
					lock.acquire();
					nSaldo = cuentas[nCuenta].setDeposito(cantidad);
					lock.release();
				}
				else {
					nSaldo = 0;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return nSaldo;
	}
	
	public float setReintegro(int nCuenta, float cantidad) {
		float nCantidad = 0;
		try {
			if (nCuenta < MAXCUENTAS) {
				if (isBloqueada(nCuenta)== false) {
					lock.acquire();
					nCantidad = cuentas[nCuenta].Reintegro(cantidad);
					lock.release();
				}
				else {
					return 0;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return nCantidad;
	}
	
	public int bloqueaCuenta(int nCuenta) {
		int op = 0;
		if (nCuenta < MAXCUENTAS) {
			if (bloqueo[nCuenta].tryAcquire()) {
				op = 1;
			}
			else {
				op = 0;
			}
		}
		return op;
	}
	
	public void liberaCuenta(int nCuenta) {
		if (nCuenta < MAXCUENTAS) {
			bloqueo[nCuenta].release();
		}
	}

	public boolean isBloqueada(int cuenta) {
		boolean cuentaBloqueda;
		if (bloqueo[cuenta].tryAcquire()) {
			bloqueo[cuenta].release();
			cuentaBloqueda = false;
		}
		else {
			cuentaBloqueda = true;
		}
		return cuentaBloqueda;
	}
}
