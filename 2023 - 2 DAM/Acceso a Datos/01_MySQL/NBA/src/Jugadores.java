import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Jugadores extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtEquipo;
	/**
	 * Create the frame.
	 */
	public Jugadores() {
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 749, 402);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
	
		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Procedencia");
		model.addColumn("Altura");
		model.addColumn("Peso");
		model.addColumn("Posicion");
		model.addColumn("Nombre_Equipo");
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Equipo:");
		lblNewLabel.setBounds(10, 8, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtEquipo = new JTextField();
		txtEquipo.setBounds(66, 5, 86, 20);
		contentPane.add(txtEquipo);
		txtEquipo.setColumns(10);
		
		JButton butConsultar = new JButton("Consultar");
		butConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setNumRows(0);
				ejecutarConsulta(txtEquipo.getText());
			}
			private void ejecutarConsulta(String equipo) {
				ArrayList <String[]> lista = new ArrayList<String[]>();
				lista = Database.getJugadores(equipo);
				if (lista.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Equipo no encontrado");
				} else {
					for (String[] fila : lista) {
						model.addRow(fila);
					}
				}
			}
		});
		butConsultar.setBounds(170, 4, 89, 23);
		contentPane.add(butConsultar);
	}
}