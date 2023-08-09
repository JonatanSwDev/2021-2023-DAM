package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCPService extends Thread{
	private int id;
	private Socket socket;
	private PipedReader receptor;
	private BufferedReader pipedE;
	private Scanner flujoE;
	private PrintWriter flujoS;
	private InetAddress IP;
	private int nterminal;
	private boolean suscrito;
	private Listener miListener  = null;
	
	public ClienteTCPService(int id, Socket socket, PipedReader receptor) {
		
		try {
			this.id = id;
			this.socket = socket;
			this.pipedE = new BufferedReader(receptor);
			this.flujoE = new Scanner(socket.getInputStream());
			this.flujoS = new PrintWriter(socket.getOutputStream());
			this.IP = socket.getInetAddress();
			this.suscrito = false;
			System.out.println("Cliente conectado desde "+IP);
			this.miListener = new Listener(flujoS,pipedE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.start();
	}
	
	public void run() {
		try {
			flujoS.println("--------------------------------------");
			flujoS.println("   Bienvenido al servicio de MCast    ");
			flujoS.println("--------------------------------------");
			flujoS.println(">");
			flujoS.flush();
			doService();
			//Cerramos el hilo que nos manda la info que el MCastReceiver ha generado
			miListener.close();
			flujoS.close();
			flujoE.close();
			System.out.println("El cliente se ha desconectado");
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
		
		comando = comando.toLowerCase();
		boolean op;
		String mensaIn;
		
		if (comando.contains("mensa-on") && !suscrito) {
			suscrito = true;
			flujoS.println("Cliente "+ id+" subscrito a los mensajes ");
			miListener.suscribir();
		}
		if (comando.contains("mensa-off") && suscrito) {
			suscrito = false;
			flujoS.println("Cliente "+ id+" no subscrito a los mensajes ");
			miListener.nosuscribir();
		}
		//-----------------------------
		flujoS.flush();
	}
}
