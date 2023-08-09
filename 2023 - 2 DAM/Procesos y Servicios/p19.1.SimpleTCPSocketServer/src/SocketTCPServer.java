import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketTCPServer {
	private ServerSocket serverSocket;
	private Socket socket;
	private int serverPort;
	private static Scanner flujoE;
	private static PrintWriter flujoS;
	
	public SocketTCPServer(int serverPort) {
		
		try {
			this.serverPort = serverPort;
			this.serverSocket = new ServerSocket(serverPort);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void start() {
		try {
			socket = serverSocket.accept();
		    flujoE = new Scanner(socket.getInputStream());
			flujoS = new PrintWriter(socket.getOutputStream());
			System.out.println("Conexión establecida");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void close() {
		System.out.println("Cerrando conexiones");
		try {
			flujoE.close();
			flujoS.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		int serverPort = 7878;
		String mensa;
		
		SocketTCPServer server = new SocketTCPServer(serverPort);
		System.out.println("Servidor funcionando en "+serverPort);
		server.start();
		boolean fin = false;
		while (!fin) {
			mensa = flujoE.nextLine();
			System.out.println("Recibido "+mensa);
			
			if (mensa.contains("quit")) {
				fin = true;
			}
			else {
				flujoS.println("SERVER :"+mensa);
				flujoS.flush();
			}
		}
		server.close();


	}



	

}
