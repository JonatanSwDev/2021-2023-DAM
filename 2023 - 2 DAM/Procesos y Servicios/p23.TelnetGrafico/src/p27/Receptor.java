package p27;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Receptor extends Thread{
	private Socket s;
	private JTextArea txtRecibir;
	private Scanner flujoE;
	private boolean fin;
	private JScrollPane scrollPane;
	private JScrollBar vertical;
	
	public Receptor(Socket s, JTextArea txtRecibir, JScrollPane scrollPane) {
		try {
			this.s = s;
			this.txtRecibir = txtRecibir;
			this.scrollPane = scrollPane;
			this.vertical = scrollPane.getVerticalScrollBar();
			flujoE = new Scanner(s.getInputStream());
			fin = false;
			this.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		String mensa;
		while (!fin) {
			try {
				mensa = flujoE.nextLine();
				txtRecibir.append(mensa+"\n");
				vertical.setValue(vertical.getMaximum() );
			
			} catch (Exception e) {
				fin = true;
				txtRecibir.setText("");
			}
		}
	}

}
