package domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class BankService extends Thread {
	private Socket socket;
	private Banco banco;
	private Scanner flujoE;
	private PrintWriter flujoS;
	private int id;
	
	public BankService(int id, Socket socket, Banco banco) {
		try {
			this.socket = socket;
			this.banco = banco;
			this.id = id;
			this.flujoE = new Scanner(socket.getInputStream());
			this.flujoS = new PrintWriter(socket.getOutputStream());
			this.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		
		try {
			flujoS.println("----------------------------");
			flujoS.println("Bienvenido a su banco online");
			flujoS.println("----------------------------");
			flujoS.flush();
			doService();
			flujoS.close();
			flujoE.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doService() {
		boolean finService = false;
		String comando;
		
		while (!finService) {
			try {
				comando = flujoE.next();
				//Procesar comando de cliente
				if (comando.contains("quit")) {
					finService = true;
				}
				else {
					procesarComando(comando);
				}
			} catch (Exception e) {
				finService = true;
			}
		}
		
	}

	private void procesarComando(String comando) {
		int cuenta;
		float importe;
		float nSaldo;
		boolean cuentaBloqueda;
		
		if (comando.contains("saldo")) {
			//Recuperamos el número de cuenta
			cuenta = flujoE.nextInt();
			flujoS.println("Recuperando el saldo de la cuenta "+cuenta+" ...");
			flujoS.println("El saldo de la cuenta "+cuenta+" es de:"+banco.getSaldo(cuenta));
		}
		else if (comando.contains("deposito")) {
			//Recuperamos el número de cuenta
			cuenta = flujoE.nextInt();
			importe = flujoE.nextFloat();
			
			flujoS.println("Realizando depósito en la cuenta "+cuenta+" de");
			flujoS.println("Ingresando en la cuenta "+cuenta+" la cantidad de "+importe);
			nSaldo = banco.setDeposito(cuenta, importe);
			flujoS.println("El saldo de la cuenta "+cuenta+" es de:"+nSaldo);
		}
		else if (comando.contains("reintegro")) {
			//Recuperamos el número de cuenta
			cuenta = flujoE.nextInt();
			importe = flujoE.nextFloat();
			
			flujoS.println("Realizando reintegro la cuenta "+cuenta+" de");
			flujoS.println("Reintegrando de la cuenta "+cuenta+" la cantidad de "+importe);
			nSaldo = banco.setReintegro(cuenta, importe);
			if (nSaldo != 0) {
				flujoS.println("El saldo de la cuenta "+cuenta+" es de:"+banco.getSaldo(cuenta));
			}else {
				flujoS.println("Error saldo insuficiente");
			}
		}
		else if (comando.contains("bloquea")) {
			cuenta = flujoE.nextInt();
			banco.bloqueaCuenta(cuenta);
			flujoS.println("Realizando el bloqueo de la cuenta "+cuenta+" de");			
		}
		else if (comando.contains("libera")) {
			cuenta = flujoE.nextInt();
			banco.liberaCuenta(cuenta);
			flujoS.println("Realizando la liberación de la cuenta "+cuenta+" de");			
		}
		flujoS.flush();
	}
}







