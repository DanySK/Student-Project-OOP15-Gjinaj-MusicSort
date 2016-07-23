package otherView;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class OtherView {
	private JFrame frmMusicsort;
	private JTextField txtSearch;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OtherView window = new OtherView();
					window.frmMusicsort.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OtherView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmMusicsort = new JFrame();
		frmMusicsort.getContentPane().setForeground(Color.GRAY);
		frmMusicsort.setSize(1200, 800);
		frmMusicsort.setTitle("musicSortNew");
		frmMusicsort.getContentPane().setLayout(null);
		frmMusicsort.setResizable(false);
		
		JPanel westPanel = new JPanel();
		westPanel.setBackground(Color.GREEN);
		westPanel.setBounds(6, 6, 250, 691);
		
		
		
		
		
		frmMusicsort.getContentPane().add(westPanel);
		westPanel.setLayout(null);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(37, 6, 170, 33);
		txtSearch.setFont(new Font("Noteworthy", Font.ITALIC, 14));
		txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearch.setText("SEARCH");
		westPanel.add(txtSearch);
		txtSearch.setColumns(10);
		
		JList list = new JList();
		list.setBounds(103, 83, 1, 1);
		westPanel.add(list);
		
		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.WHITE);
		southPanel.setBounds(6, 706, 1188, 66);
		frmMusicsort.getContentPane().add(southPanel);
		southPanel.setLayout(null);
		
		JButton pausePlay = new JButton("");
		pausePlay.setIcon(new ImageIcon("/Users/rrok/Documents/workspace/musicSortGui/img/play-icon.png"));
		pausePlay.setBounds(102, 6, 60, 54);
		southPanel.add(pausePlay);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("/Users/rrok/Documents/workspace/musicSortGui/img/back avanti.png"));
		button.setBounds(174, 6, 60, 40);
		southPanel.add(button);
		
		JButton back = new JButton("");
		back.setIcon(new ImageIcon("/Users/rrok/Documents/workspace/MusicSort/img/back.png"));
		back.setBounds(31, 6, 60, 40);
		southPanel.add(back);
		
		
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.CYAN);
		northPanel.setForeground(Color.MAGENTA);
		northPanel.setBounds(268, 6, 926, 89);
		frmMusicsort.getContentPane().add(northPanel);
		
		Choice choice = new Choice();
		choice.setBounds(77, 16, 89, 27);
		choice.setFont(new Font("Apple Color Emoji", Font.PLAIN, 12));
		choice.setName("choice");
		choice.add("Name");
		choice.add("Star");
		northPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sort By");
		lblNewLabel.setBounds(24, 16, 61, 27);
		northPanel.add(lblNewLabel);
		
		
		northPanel.add(choice);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.DARK_GRAY);
		centerPanel.setForeground(Color.LIGHT_GRAY);
		centerPanel.setBounds(268, 107, 926, 587);
		frmMusicsort.getContentPane().add(centerPanel);
		centerPanel.setLayout(null);
		
	}

}
