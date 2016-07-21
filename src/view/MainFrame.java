package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtCerca;

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
		leftpanel.setLayout(new BorderLayout(0, 0));
		
		txtCerca = new JTextField();
		txtCerca.setText("Cerca");
		leftpanel.add(txtCerca, BorderLayout.NORTH);
		txtCerca.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		leftpanel.add(panel_1, BorderLayout.CENTER);
        //final JPanel pnLeftButtons = new JPanel(new GridLayout(0, 1, 0, 0));
        panel_1.setPreferredSize(new Dimension(85, 0));
        final JButton btAlbum = new JButton("Albums");
        final JButton btArtist = new JButton("Artists");
        final JButton btPlaylist = new JButton("Yuor Playlists");
		
        
        
        JButton btAllSongs;
		panel_1.add(btAllSongs);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnBrani = new JButton("Brani");
		GridBagConstraints gbc_btnBrani = new GridBagConstraints();
		gbc_btnBrani.anchor = GridBagConstraints.WEST;
		gbc_btnBrani.insets = new Insets(0, 0, 5, 0);
		gbc_btnBrani.gridx = 0;
		gbc_btnBrani.gridy = 1;
		panel_1.add(btnBrani, gbc_btnBrani);
		
		JButton btnArtisti = new JButton("Artisti");
		GridBagConstraints gbc_btnArtisti = new GridBagConstraints();
		gbc_btnArtisti.anchor = GridBagConstraints.WEST;
		gbc_btnArtisti.insets = new Insets(0, 0, 5, 0);
		gbc_btnArtisti.gridx = 0;
		gbc_btnArtisti.gridy = 2;
		panel_1.add(btnArtisti, gbc_btnArtisti);
		
		JButton btnAlbum = new JButton("Album");
		GridBagConstraints gbc_btnAlbum = new GridBagConstraints();
		gbc_btnAlbum.anchor = GridBagConstraints.WEST;
		gbc_btnAlbum.insets = new Insets(0, 0, 5, 0);
		gbc_btnAlbum.gridx = 0;
		gbc_btnAlbum.gridy = 3;
		panel_1.add(btnAlbum, gbc_btnAlbum);
		
		JButton btnPlaylist = new JButton("Playlist");
		GridBagConstraints gbc_btnPlaylist = new GridBagConstraints();
		gbc_btnPlaylist.anchor = GridBagConstraints.WEST;
		gbc_btnPlaylist.insets = new Insets(0, 0, 5, 0);
		gbc_btnPlaylist.gridx = 0;
		gbc_btnPlaylist.gridy = 4;
		panel_1.add(btnPlaylist, gbc_btnPlaylist);
		
		JButton btnPreferiti = new JButton("Preferiti");
		GridBagConstraints gbc_btnPreferiti = new GridBagConstraints();
		gbc_btnPreferiti.anchor = GridBagConstraints.WEST;
		gbc_btnPreferiti.gridx = 0;
		gbc_btnPreferiti.gridy = 5;
		panel_1.add(btnPreferiti, gbc_btnPreferiti);
        pae.add(btAlbum);
        pnLeftButtons.add(btArtist);
        pnLeftButtons.add(btPlaylist);
        
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
