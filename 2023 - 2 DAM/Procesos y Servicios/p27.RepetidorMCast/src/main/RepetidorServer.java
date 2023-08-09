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

import domain.ClienteTCPService;
import domain.MCastReceiver;

public class RepetidorServer {
	private static ServerSocket serverSocket;
	private static List<Socket> clientesRemotos;
	
	
	public RepetidorServer(int serverPort) {
		
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
		int maxClientes = 10;
		List<PipedWriter> emisores;
		List<PipedReader> receptores;
		
		//Creamos el MCastReceiver
		emisores = new LinkedList<PipedWriter>();
		receptores = new LinkedList<PipedReader>();
		
		MCastReceiver mCastSender = new MCastReceiver(emisores);
		
		try {
			RepetidorServer server = new RepetidorServer(serverPort);
			System.out.println("Servidor funcionando en "+serverPort);
			System.out.println("Esperando conexiones...");
			while (!fin) {
				Socket socket = serverSocket.accept();
				System.out.println("Conexión entrante desde "+socket.getInetAddress());
				clientesRemotos.add(socket);
				PipedWriter emisor = new PipedWriter();
				PipedReader receptor = new PipedReader(emisor);
				emisores.add(emisor);
				receptores.add(receptor);
				ClienteTCPService clienteTCPService = new ClienteTCPService(id,socket,receptor);
				id++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
