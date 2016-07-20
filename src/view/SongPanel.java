package view;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.CardLayout;

public class SongPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SongPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel lblSortBy = new JLabel("Sort By");
		panel.add(lblSortBy);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(SortChoose.values()));
		panel.add(comboBox);
		
		JButton btnOk = new JButton("OK");
		panel.add(btnOk);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new CardLayout(0, 0));

	}

}
