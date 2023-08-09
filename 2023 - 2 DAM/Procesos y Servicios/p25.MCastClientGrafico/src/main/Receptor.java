package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Receptor extends Thread{
	private MulticastSocket s;
	private JTextArea txtRecibir;
	private boolean fin;
	private JScrollPane scrollPane;
	private JScrollBar vertical;
	private DatagramPacket inS;
	private byte [] buffer = new byte[2048];
	
	public Receptor(MulticastSocket s, JTextArea txtRecibir, JScrollPane scrollPane) {
		this.s = s;
		this.txtRecibir = txtRecibir;
		this.scrollPane = scrollPane;
		this.vertical = scrollPane.getVerticalScrollBar();
		fin = false;
		this.start();
	}

	public void run() {
		String mensa;
		while (!fin) {
			try {
				inS = new DatagramPacket(buffer,buffer.length);
				s.receive(inS);
				mensa = new String(inS.getData()).trim();
				txtRecibir.append(mensa+"\n");
				vertical.setValue(vertical.getMaximum() );
				inS.setLength(buffer.length);
			
			} catch (Exception e) {
				fin = true;
				txtRecibir.setText("");
			}
		}
	}

}
