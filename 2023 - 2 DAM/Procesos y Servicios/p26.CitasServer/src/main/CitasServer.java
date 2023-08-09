package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

import domain.Banco;
import domain.ContadorMesa;
import domain.MCastSender;
import domain.MesaService;

public class CitasServer {
	private static ServerSocket serverSocket;
	private static List<Socket> clientesRemotos;
	
	
	public CitasServer(int serverPort) {
		
		try {
			this.serverSocket = new ServerSocket(serverPort);
			this.clientesRemotos = new LinkedList<>();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//El primer terminal asignado tiene id 1
		int id = 1;
		int serverPort = 7878;
		boolean fin = false;
		int maxMesas = 10;
		
		//La clase ContadorMesa gestiona tolo lo relacionado
		//con los contadores y 
		// la asignación de las mesas a los terminales
		ContadorMesa mesas = new ContadorMesa(maxMesas);
		
		//Creamos un pipe para comunicar con MCastSender
		PrintWriter pipeS = null;
		BufferedReader pipeE = null;
		try {
			PipedWriter emisor = new PipedWriter();
			PipedReader receptor = new PipedReader(emisor);
			pipeS = new PrintWriter(emisor);
			pipeE = new BufferedReader(receptor);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//Creamos el MCastSender
		MCastSender mCastSender = new MCastSender(pipeE);
		try {
			CitasServer server = new CitasServer(serverPort);
			System.out.println("Servidor funcionando en "+serverPort);
			System.out.println("Esperando conexiones...");
			while (!fin) {
				Socket socket = serverSocket.accept();
				System.out.println("Conexión entrante desde "+socket.getInetAddress());
				clientesRemotos.add(socket);
				MesaService mesaService = new MesaService(id,socket,mesas,pipeS);
				id++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
