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

public class EquiposConf extends JFrame {

	private JPanel contentPane;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public EquiposConf() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 414, 205);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
	
		model.addColumn("Equipos");
		model.addColumn("Conferencia");
		
		scrollPane.setViewportView(table);
		
		JRadioButtonMenuItem jButOeste = new JRadioButtonMenuItem("Oeste");
		jButOeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					model.setNumRows(0);

				ejecutarConsulta("Oeste");
			}
			private void ejecutarConsulta(String conferencia) {
				ArrayList <String[]> lista = new ArrayList<String[]>();
				lista = Database.getEqConf(conferencia);
				
				for (String[] fila : lista) {
					model.addRow(fila);
				}
				
			}
			
		});
		jButOeste.setBounds(10, 8, 133, 26);
		contentPane.add(jButOeste);
		
		JRadioButtonMenuItem jButEste = new JRadioButtonMenuItem("Este");
		jButEste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setNumRows(0);
				ejecutarConsulta("Este");
			}
			private void ejecutarConsulta(String conferencia) {
				ArrayList <String[]> lista = new ArrayList<String[]>();
				lista = Database.getEqConf(conferencia);
				
				for (String[] fila : lista) {
					model.addRow(fila);
				}
				
			}
		});
		jButEste.setBounds(291, 8, 133, 26);
		contentPane.add(jButEste);
	}
}

