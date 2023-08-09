package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class MCastClienteGrafico {

	private JFrame frame;
	private JTextField txtURL;
	private JTextArea txtRecibir;
	private JButton btnCerrar;
	private JTextField txtEnviar;
	private JButton btnEnviar;
	private JLabel lblEnviar;
	
	private boolean conectado = false;
	private String serverIP = "224.0.0.1";
	private int serverPort = 9999;
	private MulticastSocket s;
	private InetAddress mCastAddr;
	private InetSocketAddress grupoMCast;
	private NetworkInterface netIf;
	private PrintWriter flujoS;
	private Receptor receptor;
	private JScrollPane scrollPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MCastClienteGrafico window = new MCastClienteGrafico();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MCastClienteGrafico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//frame
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//lblURL
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setBounds(29, 25, 70, 15);
		frame.getContentPane().add(lblUrl);
		
		//lblEnviar
		lblEnviar = new JLabel("Enviar");
		lblEnviar.setBounds(41, 307, 70, 15);
		frame.getContentPane().add(lblEnviar);
		
		
		//btnConectar
		JButton btnConectar = new JButton("Login");
		btnConectar.setBounds(392, 12, 80, 38);
		frame.getContentPane().add(btnConectar);
		
		//btnCerrar
		btnCerrar = new JButton("Salir");
		btnCerrar.setBounds(484, 12, 83, 38);
		frame.getContentPane().add(btnCerrar);
		
		//btnEnviar
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(487, 331, 80, 25);
		frame.getContentPane().add(btnEnviar);
		
		//txtURL
		txtURL = new JTextField();
		txtURL.setEditable(false);
		txtURL.setBounds(104, 23, 134, 19);
		frame.getContentPane().add(txtURL);
		txtURL.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 64, 526, 220);
		frame.getContentPane().add(scrollPane);
		
		//txtRecibir
		txtRecibir = new JTextArea();
		scrollPane.setViewportView(txtRecibir);
		txtRecibir.setEditable(false);
		
		//txtEnviar
		txtEnviar = new JTextField();
		txtEnviar.setEditable(false);
		txtEnviar.setBounds(41, 334, 431, 19);
		frame.getContentPane().add(txtEnviar);
		txtEnviar.setColumns(10);
		
		//combioBox Interfaces
		JComboBox comboInterfaces = new JComboBox();
		comboInterfaces.setBounds(250, 20, 130, 24);
		frame.getContentPane().add(comboInterfaces);
		completaInterfaces(comboInterfaces);
		
		//ACCIONES
		
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!conectado) {
					try {
						mCastAddr = InetAddress.getByName(serverIP);
						grupoMCast = new InetSocketAddress(
								mCastAddr,
								serverPort);
						s = new MulticastSocket(serverPort);
						netIf = NetworkInterface.getByName(
								comboInterfaces.getSelectedItem().toString());
						s.joinGroup(grupoMCast,netIf);
						conectado = true;
						txtURL.setText("Conectado a "+serverIP+":"+serverPort);
						//flujoS = new PrintWriter(s.getOutputStream());
						receptor = new Receptor(s,txtRecibir,scrollPane);
						//No podemos mandar solo escuchar
						txtEnviar.setEditable(false);
					} catch (IOException e1) {
						//e1.printStackTrace();
						txtURL.setText("ERROR DE CONEXIÓN");
					}
					
				}
			}
		});
		
		
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desconectar();
				btnConectar.grabFocus();
				txtEnviar.setEditable(false);
				
			}
		});
		
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String comando = txtEnviar.getText();
				flujoS.println(comando);
				flujoS.flush();
				txtEnviar.setText("");
				txtEnviar.grabFocus();
				if (comando.contains("quit")) {
					desconectar();
					btnConectar.grabFocus();
				}
			}
		});
		
		txtEnviar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 if(e.getKeyCode() == KeyEvent.VK_ENTER){
					 String comando = txtEnviar.getText();
						flujoS.println(comando);
						flujoS.flush();
						txtEnviar.setText("");
						txtEnviar.grabFocus();
						if (comando.contains("quit")) {
							desconectar();
							btnConectar.grabFocus();
						}
		         }
			}
		});
		
	}
	private void completaInterfaces(JComboBox comboInterfaces) {
		Enumeration<NetworkInterface> interfaces;
		
		try {
			interfaces = NetworkInterface.getNetworkInterfaces();
			for (NetworkInterface iface : Collections.list(interfaces)) {
				comboInterfaces.addItem(iface.getDisplayName().toString());
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void desconectar() {
		if(conectado) {
			s.close();
			txtURL.setText("");
			conectado = false;
			
		}
	}
}
