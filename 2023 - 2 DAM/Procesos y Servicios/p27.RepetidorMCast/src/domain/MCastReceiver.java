package domain;

import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.util.List;

public class MCastReceiver extends Thread {

	private String serverIP = "224.0.0.1";
	private int serverPort = 9999;
	private MulticastSocket s;
	private InetAddress mCastAddr;
	private InetSocketAddress grupoMCast;
	private NetworkInterface netIf;
	private boolean fin;
	private DatagramPacket inS;
	private byte [] buffer = new byte[2048];
	private List<PipedWriter> emisores;

	public MCastReceiver(List<PipedWriter> emisores) {
		fin = false;
		this.emisores = emisores;
		this.start();
	}

	public void run() {
		conectaMCastGroup();
		String mensa;
		while (!fin) {
			try {
				inS = new DatagramPacket(buffer,buffer.length);
				s.receive(inS);
				mensa = new String(inS.getData()).trim();
				inS.setLength(buffer.length);
			    //System.out.println("Recibido MCast "+mensa);
				//Hay que enviar a los clientes por el pipe
				enviarPipes(mensa);
				
			} catch (Exception e) {
				fin = true;
			}
		}
	}

	private void enviarPipes(String mensa) {
		for (PipedWriter emisor : emisores) {
			PrintWriter flujoS = new PrintWriter(emisor);
			flujoS.println(mensa);
		}
		
	}

	private void conectaMCastGroup() {
		try {
			mCastAddr = InetAddress.getByName(serverIP);
			grupoMCast = new InetSocketAddress(
					mCastAddr,
					serverPort);
			s = new MulticastSocket(serverPort);
			netIf = NetworkInterface.getByName("wlp1s0");
			s.joinGroup(grupoMCast,netIf);
			System.out.println("Conectado a grupo "+serverIP+":"+serverPort);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
}
