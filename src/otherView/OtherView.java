package otherView;



import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.sun.java.swing.plaf.windows.resources.windows;

import model.MyTableModel;
import sun.net.www.content.text.plain;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Vector;

public class OtherView {
	private JFrame frmMusicsort;
	private JTextField txtSearch;

	private JFrame frame;
	private JTable table;
	private JList list;
	private JTable showSongJTable;
	

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
	private void initialize()  {
		//list test
		//list test
		
		frmMusicsort = new JFrame();
		frmMusicsort.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMusicsort.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//to do 
			}
		});
		frmMusicsort.getContentPane().setForeground(Color.GRAY);
		frmMusicsort.setSize(1200, 750);
		frmMusicsort.setTitle("musicSortNew");
		frmMusicsort.getContentPane().setLayout(null);
		frmMusicsort.setResizable(false);
		
		JPanel westPanel = new JPanel();
		westPanel.setBackground(Color.DARK_GRAY);
		westPanel.setBounds(6, 6, 250, 641);
		
		
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
		

		
		
		 DefaultListModel<String> listModel= new DefaultListModel<>();
		  listModel.addElement("Recenti");
		  listModel.addElement("Preferiti");
		  listModel.addElement("Cantanti");
		  listModel.addElement("Brani");
		  listModel.addElement("Playlists");
		  
		  @SuppressWarnings("unchecked")
		JList jlst = new JList(listModel);
		  

		  jlst.setFont(new Font("Noteworthy", Font.PLAIN, 12));

		    jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    jlst.addListSelectionListener(new ListSelectionListener() {
		    	public void valueChanged(ListSelectionEvent le) {
		        int idx = jlst.getSelectedIndex();
		        if (idx != -1)
		          System.out.println("Current selection: " + listModel.getElementAt(idx));
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
		    		playlistname.getContentPane().setLayout(new BorderLayout());
		    		playlistname.setSize(200, 200);
		    		
		    		JTextField nameP= new JTextField();
		    		JButton add= new JButton("add");
		    		
		    		
		    		jlst.add(nameP.getText(), nameP);
		    		playlistname.getContentPane().add(nameP,BorderLayout.NORTH);
		    		playlistname.getContentPane().add(add,BorderLayout.SOUTH);
		    		playlistname.setVisible(true);
		    		playlistname.setLocation(150, 150);
		    		add.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (JOptionPane.showConfirmDialog(null, "Nome Playlist Corect??", "WARNING",
							        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							    listModel.addElement(nameP.getText());
							    playlistname.setVisible(false);
							} else {
							    // no option
							}
							
						}
					});
		    		frmMusicsort.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		    	}
		    });
		    btnNewPlaylist.setBounds(37, 603, 163, 29);
		    westPanel.add(btnNewPlaylist);
		
		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.DARK_GRAY);
		southPanel.setBounds(6, 658, 1188, 63);
		frmMusicsort.getContentPane().add(southPanel);
		southPanel.setLayout(null);
		
		JButton pausePlay = new JButton("");
		pausePlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		pausePlay.setForeground(Color.DARK_GRAY);
		pausePlay.setBackground(Color.DARK_GRAY);
		pausePlay.setIcon(new ImageIcon("/Users/rrok/Documents/workspace/musicSortGui/img/play-icon.png"));
		pausePlay.setBounds(101, 0, 60, 63);
		southPanel.add(pausePlay);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("/Users/rrok/Documents/workspace/musicSortGui/img/back avanti.png"));
		button.setBounds(174, 6, 60, 40);
		southPanel.add(button);
		
		JButton back = new JButton("");
		back.setIcon(new ImageIcon("/Users/rrok/Documents/workspace/musicSortGui/img/back.png"));
		back.setBounds(31, 6, 60, 40);
		southPanel.add(back);
		
		
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.DARK_GRAY);
		northPanel.setForeground(Color.MAGENTA);
		northPanel.setBounds(268, 6, 926, 89);
		frmMusicsort.getContentPane().add(northPanel);
		
		Choice choice = new Choice();
		choice.setBounds(827, 16, 89, 27);
		choice.setFont(new Font("Apple Color Emoji", Font.PLAIN, 12));
		choice.setName("choice");
		choice.add("Name");
		choice.add("Star");
		northPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sort By");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(769, 16, 52, 27);
		northPanel.add(lblNewLabel);
		
		
		northPanel.add(choice);
		
		JMenuBar menuBar= new JMenuBar();
		menuBar.setLocation(0, 0);
		menuBar.setSize(72, 20);
		JMenu menu = new JMenu("Options");
		
		
		menuBar.add(menu);
		
		

		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setBackground(Color.DARK_GRAY);
		menu.setForeground(Color.YELLOW);
		menu.setBounds(0, 0, 146, 22);
		
		
		JMenuItem mntmCrea = new JMenuItem("Crea Playlist");
		mntmCrea.setBackground(Color.DARK_GRAY);
		mntmCrea.setForeground(Color.YELLOW);
		menu.add(mntmCrea);
		
		JMenuItem mntmModificaPlaylist = new JMenuItem("Modifica Playlist");
		menu.add(mntmModificaPlaylist);
		
		JMenuItem mntmAggiungiPlaylist = new JMenuItem("Aggiungi a Playlist");
		menu.add(mntmAggiungiPlaylist);
		
		JMenuItem mntmRimuoviPlaylist = new JMenuItem("Rimuovi Playlist");
		menu.add(mntmRimuoviPlaylist);
		
		JMenuItem mntmImportaBrani = new JMenuItem("Apri file");
		menu.add(mntmImportaBrani);
		
		JMenuItem mntmEsci = new JMenuItem("Esci");
		menu.add(mntmEsci);
		
		northPanel.add(menuBar);
		
		/*--------------------
		
		uscire dal programma 
		
		*/
		
		mntmEsci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 System.exit(0);
			}
		});
		
		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.DARK_GRAY);
		centerPanel.setForeground(Color.LIGHT_GRAY);
		centerPanel.setBounds(268, 107, 926, 540);
		frmMusicsort.getContentPane().add(centerPanel);
		centerPanel.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPaneShowSongs = new JScrollPane();
		centerPanel.add(scrollPaneShowSongs, "name_9428167759486");
		
		
		
		
		
		String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};
		
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Jane", "White",
				     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Jane", "White",
					     "Speed reading", new Integer(20), new Boolean(true)},
			    
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};
		
		
		MyTableModel myTableModel = new MyTableModel();
		showSongJTable = new JTable(data, columnNames);
		showSongJTable.setPreferredScrollableViewportSize(showSongJTable.getPreferredSize());
		
		Vector<String> columnNameS = new Vector<String>();
        columnNameS.add("Date");
        columnNameS.add("String");
        columnNameS.add("Decimal");
        columnNameS.add("Remove");
        
        
        Vector<Object> row1 = new Vector<Object>();
        row1.add(new Date());
        row1.add("A");
        row1.add(new Double(5.1));
        row1.add("Remove");
        myTableModel.addRow(row1);
        
        
        
        myTableModel.setColumnNames(columnNameS);
		
		
		showSongJTable.setModel(myTableModel);
		showSongJTable.setSize(scrollPaneShowSongs.getWidth(),scrollPaneShowSongs.getHeight());
		
		scrollPaneShowSongs.setViewportView(showSongJTable);
		
	
	}
}
