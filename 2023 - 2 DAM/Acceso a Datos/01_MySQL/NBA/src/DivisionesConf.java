import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DivisionesConf extends JFrame {

	private JPanel contentPane;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public DivisionesConf() {
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
	
		model.addColumn("Division");
		model.addColumn("Conferencia");
		
		scrollPane.setViewportView(table);
		
		JButton butConsultar = new JButton("Consultar");
		butConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejecutarConsulta();
			}

			private void ejecutarConsulta() {
				ArrayList <String[]> lista = new ArrayList<String[]>();
				lista = Database.getDivisionesConf();
				
				for (String[] fila : lista) {
					model.addRow(fila);
				}
				
			}
		});
		butConsultar.setBounds(22, 11, 89, 23);
		contentPane.add(butConsultar);
	}
}
