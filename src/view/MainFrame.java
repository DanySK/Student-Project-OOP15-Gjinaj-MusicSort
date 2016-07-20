package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import java.awt.CardLayout;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout mainlayout = new GridBagLayout();
		mainlayout.columnWidths = new int[] {200, 400};
		mainlayout.rowHeights = new int[] {600};
		mainlayout.columnWeights = new double[]{1.0, 0.0};
		mainlayout.rowWeights = new double[]{1.0};
		contentPane.setLayout(mainlayout);
		
		JPanel leftpanel = new JPanel();
		GridBagConstraints gbc_leftpanel = new GridBagConstraints();
		gbc_leftpanel.insets = new Insets(0, 0, 5, 0);
		gbc_leftpanel.fill = GridBagConstraints.BOTH;
		gbc_leftpanel.gridx = 0;
		gbc_leftpanel.gridy = 0;
		contentPane.add(leftpanel, gbc_leftpanel);
		
		JPanel rightpanel = new JPanel();
		GridBagConstraints gbc_rightpanel = new GridBagConstraints();
		gbc_rightpanel.fill = GridBagConstraints.BOTH;
		gbc_rightpanel.gridx = 1;
		gbc_rightpanel.gridy = 0;
		contentPane.add(rightpanel, gbc_rightpanel);
		rightpanel.setLayout(new BorderLayout(0, 0));
		
		JPanel buttonspanel = new JPanel();
		rightpanel.add(buttonspanel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnPrev = new JButton("Prev");
		buttonspanel.add(btnPrev);
		buttonspanel.add(btnNewButton);
		
		JButton btnNext = new JButton("Next");
		buttonspanel.add(btnNext);
		
		JSlider slider = new JSlider();
		buttonspanel.add(slider);
		
		JPanel panel = new JPanel();
		rightpanel.add(panel, BorderLayout.CENTER);
		CardLayout panelcard = new CardLayout(0 ,0);
		panel.setLayout(panelcard);
	}

}
