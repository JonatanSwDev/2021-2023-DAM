package p28.UDPTimeServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UDPTimeServer {

	public static void main(String args[]) {
		DatagramSocket sock = null;
		int UDPPort = 7777;
		try {
			//1.Create the Datagram Socket
			sock = new DatagramSocket(UDPPort);
			
			//2.Crear buffer
			byte[] buffer = new byte[65536];
			
			//3. Crear datagram packet
			DatagramPacket entrada = 
					new DatagramPacket(buffer,buffer.length);
			
			//4. Bucle de comunicación
			System.out.println("Esperando conexión...");
			sock.receive(entrada);
			
			while (true) {
				
				//Crear el datagrama
				byte [] hora =  LocalDateTime.now().toString().getBytes();
				DatagramPacket salida =
						new DatagramPacket(hora,hora.length,
								entrada.getAddress(),
								entrada.getPort());
				String mensa = new String(hora); 
				System.out.println("Enviando: "+mensa);
				sock.send(salida);
				Thread.sleep(1000);
			}
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
