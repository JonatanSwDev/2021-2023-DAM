package domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class MesaService extends Thread {
	private Socket socket;
	private ContadorMesa mesas;
	private Scanner flujoE;
	private PrintWriter flujoS;
	private InetAddress IP;
	private int nterminal;
	private int nmesa;
	private PrintWriter pipeS;
	
	public MesaService(int id, Socket socket, ContadorMesa mesas, PrintWriter pipeS) {
		try {
			this.socket = socket;
			this.mesas = mesas;
			this.nterminal = id;
			this.flujoE = new Scanner(socket.getInputStream());
			this.flujoS = new PrintWriter(socket.getOutputStream());
			this.IP = socket.getInetAddress();
			this.pipeS = pipeS;
			System.out.println("Cliente conectado desde "+IP);
			this.nmesa = 0;
			this.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		
		try {
			flujoS.println("--------------------------------------");
			flujoS.println("Bienvenido al servicio de mesas SATAN ");
			flujoS.println("--------------------------------------");
			flujoS.println(">");
			flujoS.flush();
			doService();
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
		int nmesaIn;
		
		if (comando.contains("mesa")) {
			//Vemos si el terminal está asignado a una mesa
			if (nmesa == 0) {
				nmesaIn = flujoE.nextInt();
				if (nmesaIn != 0) {
					op = mesas.asignaMesa(nmesaIn,nterminal);
					if (op) {
						nmesa = nmesaIn;
						flujoS.println("Mesa "+nmesa+" asignada al terminal "+nterminal);
					}
				    else {
				    	flujoS.println("Error mesa ya asignada a un terminal");
				    }
			     }else {
			    	flujoS.println("El número de mesa no puede ser 0"); 
			     }
			}else {
				flujoS.println("Error el terminal está asignado a la mesa "+nmesa);
			}
		}
		//-----------------------------
		if (comando.contains("numero")) {
			int nEspera = mesas.getNumeroEspera();
			flujoS.println("Usted tiene el númeo: "+nEspera);
			flujoS.println("Espere ser llamado");
		}
		if (comando.contains("next")) {
			int nSiguiente = 0;
			//Vemos si el terminal está asignado a una mesa
			if (nmesa != 0) {
				nSiguiente = mesas.getSiguienteNumero();
				String mCastMsg = "Número: "+nSiguiente+ " Mesa "+nmesa;
				flujoS.println(mCastMsg);
				pipeS.println(mCastMsg);
			}
			else {
				flujoS.println("ERROR !!! El terminal no tiene mesa asignada");	
			}
		}
		flujoS.flush();
	}
}







