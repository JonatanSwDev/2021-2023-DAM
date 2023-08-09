package p28.UDPTimeServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.time.LocalDate;

public class UDPClientServer {

	public static void main(String args[]) {
		DatagramSocket sock = null;
		int UDPPort = 7777;
		String serverAddress = "127.0.0.1";
		DatagramPacket entrada = null;
		DatagramPacket salida = null;
		try {
			//1.Create the Datagram Socket
			sock = new DatagramSocket();
			byte [] bufferIn = new byte[65536];
			byte [] bufferOut = new byte[2048];
			InetAddress host = InetAddress.getByName(serverAddress);
			entrada = new DatagramPacket(bufferIn,bufferIn.length);
			salida = new DatagramPacket(bufferOut,bufferOut.length,
					host,UDPPort);
			//Abre la conexión al server
			sock.send(salida);
			
			//4. Bucle de comunicación
			while (true) {
				sock.receive(entrada);
				String mensa = new String(entrada.getData()).trim();
				System.out.println("Recibido >"+mensa);
				entrada.setLength(bufferIn.length);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
