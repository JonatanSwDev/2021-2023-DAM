package main;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import domain.Cliente;
import domain.Cuenta;

public class Main {

	public static void main(String[] args) {
		final int MAX_OP_100 = 40;
		final int MAX_OP_50  = 20;
		final int MAX_OP_20  = 60;
		final int totalHilos =  (MAX_OP_100+
                MAX_OP_50+MAX_OP_20) * 2;
		
		int offset = 0;
		int end = 0;
		
		CyclicBarrier inicioConcurrente = new CyclicBarrier(
											totalHilos);
		CountDownLatch esperaFin = new  CountDownLatch(
											totalHilos);
		
		Cuenta miCuenta = new Cuenta(100);
		
		Cliente [] cliente = new Cliente[totalHilos];
		
		end = MAX_OP_100;
		for (int i=0;i < end;i++) {
			cliente[i] = new Cliente(i, inicioConcurrente,
								esperaFin,miCuenta,'I',100);
			offset++;
		}
		end = end+MAX_OP_50;
		for (int i=offset;i < end;i++) {
			cliente[i] = new Cliente(i, inicioConcurrente,
								esperaFin,miCuenta,'I',50);
			offset++;
		}
		end = end+MAX_OP_20;
		for (int i=offset;i < end;i++) {
			cliente[i] = new Cliente(i, inicioConcurrente,
								esperaFin,miCuenta,'I',20);
			offset++;
		}

		// Reintegros
		end = end+MAX_OP_100;
		for (int i=offset;i < end;i++) {
			cliente[i] = new Cliente(i, inicioConcurrente,
								esperaFin,miCuenta,'R',100);
			offset++;
		}
		end = end+MAX_OP_50;
		for (int i=offset;i < end;i++) {
			cliente[i] = new Cliente(i, inicioConcurrente,
								esperaFin,miCuenta,'R',50);
			offset++;
		}
		end = end+MAX_OP_20;
		for (int i=offset;i < end;i++) {
			cliente[i] = new Cliente(i, inicioConcurrente,
								esperaFin,miCuenta,'R',20);
			offset++;
		}
		System.out.println("total hilos "+offset);
		//esperamos que la simulación termine
		try {
			esperaFin.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Saldo final "+miCuenta.getSaldo());
	}

}
