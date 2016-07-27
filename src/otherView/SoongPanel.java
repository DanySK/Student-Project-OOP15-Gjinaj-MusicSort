package otherView;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.FlowLayout;
import java.awt.List;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SoongPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public SoongPanel() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JLabel lblBrano = new JLabel("Brano");
		lblBrano.setForeground(Color.YELLOW);
		lblBrano.setBounds(10, 0, 46, 14);
		add(lblBrano);
		
		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setForeground(Color.YELLOW);
		lblArtista.setBounds(120, 0, 46, 14);
		add(lblArtista);
		
		JLabel lblStelle = new JLabel("Stelle");
		lblStelle.setForeground(Color.YELLOW);
		lblStelle.setBounds(233, 0, 46, 14);
		add(lblStelle);
		
		JLabel lblDataAggiunta = new JLabel("Data Aggiunta");
		lblDataAggiunta.setForeground(Color.YELLOW);
		lblDataAggiunta.setBounds(348, 0, 76, 14);
		add(lblDataAggiunta);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 21, 450, 279);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		

	}
}
