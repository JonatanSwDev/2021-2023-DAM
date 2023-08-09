import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JToggleButton;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuItem menuDivConf = new JMenuItem("Divisiones por conferencia");
		menuDivConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DivisionesConf divconf = new DivisionesConf();		
				divconf.setVisible(true);
				divconf.setLocationRelativeTo(null);
			}
		});
		menuDivConf.setBounds(46, 11, 220, 26);
		contentPane.add(menuDivConf);
		
		JMenuItem menuEqConf = new JMenuItem("Equipos por conferencia");
		menuEqConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquiposConf eqconf = new EquiposConf();		
				eqconf.setVisible(true);
				eqconf.setLocationRelativeTo(null);
			}
		});
		menuEqConf.setBounds(265, 11, 220, 26);
		contentPane.add(menuEqConf);
		
		JMenuItem menuJugadores = new JMenuItem("Jugadores");
		menuJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jugadores jugadores = new Jugadores();		
				jugadores.setVisible(true);
				jugadores.setLocationRelativeTo(null);
			}
		});
		menuJugadores.setBounds(90, 92, 135, 26);
		contentPane.add(menuJugadores);
		
		JMenuItem menuPartidos = new JMenuItem("Partidos");
		menuPartidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partidos partidos = new Partidos();		
				partidos.setVisible(true);
				partidos.setLocationRelativeTo(null);
			}
		});
		menuPartidos.setBounds(317, 92, 115, 26);
		contentPane.add(menuPartidos);
	}
	
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
