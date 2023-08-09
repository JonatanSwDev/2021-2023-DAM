package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MCastSender extends Thread{
	final static String INET_ADDR ="224.0.0.1";
	final static int PORT = 9999;
	final static int WAIT = 1000;
	
	private BufferedReader pipeE;
	private boolean fin;
	 
	
	public MCastSender(BufferedReader pipeE) {
		this.pipeE = pipeE;
		this.fin = false;
		this.start();
	}
	
	public void run() {
		try {
			InetAddress serverAddr = InetAddress.getByName(INET_ADDR);
			DatagramSocket server = new DatagramSocket();
			String mensa;
			
			while (!fin) {
				mensa = pipeE.readLine();
				//Construimos paquete UDP
				DatagramPacket msgPacket = 
						new DatagramPacket (mensa.getBytes(),
								mensa.getBytes().length,
								serverAddr,
								PORT);
				server.send(msgPacket);
				System.out.println("Enviando "+mensa);
				Thread.sleep(WAIT);
			}
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void finalizar() {
		this.fin = true;
	}

}
