package domain;

public class Cuenta {
	float saldo;
	
	public Cuenta(int saldo) {
		this.saldo = saldo;
	}

	public float getSaldo() {
		return this.saldo;
	}

	public float setSaldo(int nSsaldo) {
		this.saldo = nSsaldo;
		return this.saldo;
	}

	public float setDeposito(float cantidad) {
		this.saldo += cantidad;
		return this.saldo;
	}

	public float Reintegro(float cantidad) {
		if (saldo >= cantidad) {
			this.saldo -= cantidad;
			return cantidad;
		}
		else {
			return 0;
		}
	}

}
