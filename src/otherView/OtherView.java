package otherView;



import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import sun.net.www.content.text.plain;

import java.awt.*;
import java.awt.event.*;

public class OtherView {
	private JFrame frmMusicsort;
	private JTextField txtSearch;

	private JFrame frame;
	private JTable table;
	private JList list;
	

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
		//list test
		//list test
		
		
		
		
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
		
		
		//fonte http://www.java2s.com/Code/Java/Swing-JFC/AsingleselectionJList.htm
		

		
		
		  Object tree[] = { "#Recenti","Preferiti","Cantanti", "Brani","Playlists" };

		  JList jlst = new JList(tree);
		  jlst.setFont(new Font("Noteworthy", Font.PLAIN, 12));

		    jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    jlst.addListSelectionListener(new ListSelectionListener() {
		    	public void valueChanged(ListSelectionEvent le) {
		        int idx = jlst.getSelectedIndex();
		        if (idx != -1)
		          System.out.println("Current selection: " + tree[idx]);
		        else
		          System.out.println("Please choose a language.");
		      }
		    });

		    JScrollPane jsp= new JScrollPane(jlst);
		    jsp.setSize(153, 541);
		    jsp.setLocation(47, 50);
		
		    westPanel.add(jsp);
		    
		    JButton btnNewPlaylist = new JButton("new Playlist");
		    btnNewPlaylist.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		JFrame playlistname= new JFrame("Set Playlist Name");
		    		playlistname.setLayout(new BorderLayout());
		    		playlistname.setSize(200, 200);
		    		
		    		JTextField nameP= new JTextField();
		    		JButton add= new JButton("add");
		    		
		    		
		    		jlst.add(nameP.getText(), nameP);
		    		playlistname.add(nameP,BorderLayout.NORTH);
		    		playlistname.add(add,BorderLayout.SOUTH);
		    		playlistname.setVisible(true);
		    		add.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							String infoMessage, titleBar;
							infoMessage= "Nome playlist Corretto?";
							titleBar= "new playlist";
							if (JOptionPane.showConfirmDialog(null, "Nome Playlist Corrett??", "WARNING",
							        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							    jlst.add(nameP.getText(), nameP);
							    playlistname.setVisible(false);
							} else {
							    // no option
							}
							
						}
					});
		    		playlistname.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		    	}
		    });
		    btnNewPlaylist.setBounds(37, 603, 163, 29);
		    westPanel.add(btnNewPlaylist);
		
		
		
		
		
		
		
		
		
		
		
		
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
