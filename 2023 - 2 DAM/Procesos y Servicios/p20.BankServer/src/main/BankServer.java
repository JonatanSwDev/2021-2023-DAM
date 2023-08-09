package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

import domain.Banco;
import domain.BankService;

public class BankServer {
	private static ServerSocket serverSocket;
	private static List<Socket> clientesRemotos;
	private static Banco banco = new Banco();
	
	public BankServer(int serverPort) {
		
		try {
			this.serverSocket = new ServerSocket(serverPort);
			this.clientesRemotos = new LinkedList<>();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int id = 0;
		int serverPort = 7878;
		boolean fin = false;
		
		try {
			BankServer server = new BankServer(serverPort);
			System.out.println("Servidor funcionando en "+serverPort);
			System.out.println("Esperando conexiones...");
			while (!fin) {
				Socket socket = serverSocket.accept();
				System.out.println("Conexión entrante desde "+socket.getInetAddress());
				clientesRemotos.add(socket);
				BankService bankService = new BankService(id,socket,banco);
				id++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
