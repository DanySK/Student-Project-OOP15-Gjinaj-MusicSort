package otherView;



import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;


import model.MyTableModel;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Vector;

public class OtherView {
	private JFrame frmMusicsort;
	private JTextField txtSearch;

	private JTable showSongJTable;
	JPanel westPanel = new JPanel();
	JPanel southPanel = new JPanel();
	JPanel northPanel = new JPanel();
	JPanel centerPanel = new JPanel();

	
	DefaultListModel<String> listModel= new DefaultListModel<>();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JList jlst = new JList(listModel);
    JScrollPane jsp= new JScrollPane(jlst);
	private AudioPlayer player = new AudioPlayer();
	private Thread playbackThread;
	private PlayingTimer timer;
	
	JSlider sliderTime = new JSlider();
	
	
	

	private boolean isPlaying = false;
	private boolean isPause = true;
	
	private String audioFilePath;
	private String lastOpenPath;
	JButton btnNewPlaylist = new JButton("new Playlist");
	JTextField nameP= new JTextField();
	JButton addNewPlaylist= new JButton("add");
	private JButton buttonOpen = new JButton("Open");
	private JButton buttonPlay = new JButton("Play");
	private JButton buttonPause = new JButton("Pause");
	JButton avanti = new JButton("");
	JButton back = new JButton("");
	
	
	private ImageIcon iconOpen = new ImageIcon(getClass().getResource(
			"/images/Open.png"));
	private ImageIcon iconPlay = new ImageIcon(getClass().getResource(
			"/images/Play.gif"));
	private ImageIcon iconStop = new ImageIcon(getClass().getResource(
			"/images/Stop.gif"));
	private ImageIcon iconPause = new ImageIcon(getClass().getResource(
			"/images/Pause.png"));
	
	private JLabel labelFileName = new JLabel("Playing File:");
	private JLabel labelTimeCounter = new JLabel("00:00:00");
	private JLabel labelDuration = new JLabel("00:00:00");
	
	
	
	

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
		

		
		
		 
		  listModel.addElement("Recenti");
		  listModel.addElement("Preferiti");
		  listModel.addElement("Cantanti");
		  listModel.addElement("Brani");
		  listModel.addElement("Playlists");
		
		  

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


		    jsp.setSize(153, 541);
		    jsp.setLocation(47, 50);
		
		    westPanel.add(jsp);
		    
		    
		    btnNewPlaylist.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		JFrame playlistname= new JFrame("Set Playlist Name");
		    		playlistname.getContentPane().setLayout(new BorderLayout());
		    		playlistname.setSize(200, 200);
		    		

		    		
		    		
		    		jlst.add(nameP.getText(), nameP);
		    		playlistname.getContentPane().add(nameP,BorderLayout.NORTH);
		    		playlistname.getContentPane().add(addNewPlaylist,BorderLayout.SOUTH);
		    		playlistname.setVisible(true);
		    		playlistname.setLocation(150, 150);
		    		addNewPlaylist.addActionListener(new ActionListener() {
						
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
		
		
		southPanel.setBackground(Color.DARK_GRAY);
		southPanel.setBounds(6, 658, 1188, 63);
		frmMusicsort.getContentPane().add(southPanel);
		
		
		buttonPlay.setBounds(101, 0, 60, 63);
		buttonPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		southPanel.setLayout(null);
		buttonPlay.setForeground(Color.DARK_GRAY);
		buttonPlay.setBackground(Color.DARK_GRAY);
		//pausePlay.setIcon(new ImageIcon("/Users/rrok/Documents/workspace/musicSortGui/img/play-icon.png"));
		buttonPlay.setIcon(iconPlay);
		southPanel.add(buttonPlay);
		
		
		avanti.setBounds(174, 6, 60, 40);
		avanti.setIcon(new ImageIcon("/Users/rrok/Documents/workspace/musicSortGui/img/back avanti.png"));
		southPanel.add(avanti);
		
		
		back.setBounds(31, 6, 60, 40);
		back.setIcon(new ImageIcon("/Users/rrok/Documents/workspace/musicSortGui/img/back.png"));
		southPanel.add(back);
		buttonOpen.setLocation(248, 6);
		buttonOpen.setSize(50, 50);
		
		southPanel.add(buttonOpen);
		
		
		ActionListener MusicListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				Object source = event.getSource();
				if (source instanceof JButton) {
					JButton button = (JButton) source;
					if (button == buttonPlay) {
						this.openFile();
					} else if (button == back) {
						if (!isPlaying) {
							playBack();
						} else {
							stopPlaying();
						}
					} else if (button == buttonPause) {
						if (!isPause) {
							pausePlaying();
						} else {
							resumePlaying();
						}
					}
				}
			}

			private void pausePlaying() {
				buttonPause.setText("Resume");
				isPause = true;
				player.pause();
				timer.pauseTimer();
				playbackThread.interrupt();
			}
			
			private void resumePlaying() {
				buttonPause.setText("Pause");
				isPause = false;
				player.resume();
				timer.resumeTimer();
				playbackThread.interrupt();		
			}
			
			private void resetControls() {
				timer.reset();
				timer.interrupt();

				buttonPlay.setText("Play");
				buttonPlay.setIcon(iconPlay);
				
				buttonPause.setEnabled(false);
				
				isPlaying = false;		
			}

			private void stopPlaying() {
				isPause = false;
				buttonPlay.setText("Pause");
				buttonPause.setEnabled(false);
				timer.reset();
				timer.interrupt();
				player.stop();
				playbackThread.interrupt();
			}
			

			private void openFile() {
				// TODO Auto-generated method stub
				JFileChooser fileChooser = null;
				
				if (lastOpenPath != null && !lastOpenPath.equals("")) {
					fileChooser = new JFileChooser(lastOpenPath);
				} else {
					fileChooser = new JFileChooser();
				}
				
				FileFilter wavFilter = new FileFilter() {
					@Override
					public String getDescription() {
						return "Sound file (*.WAV)";
					}

					@Override
					public boolean accept(File file) {
						if (file.isDirectory()) {
							return true;
						} else {
							return file.getName().toLowerCase().endsWith(".wav");
						}
					}
				};

				
				fileChooser.setFileFilter(wavFilter);
				fileChooser.setDialogTitle("Open Audio wav File ");
				fileChooser.setAcceptAllFileFilterUsed(false);

				int userChoice = fileChooser.showOpenDialog(fileChooser);
				if (userChoice == JFileChooser.APPROVE_OPTION) {
					audioFilePath = fileChooser.getSelectedFile().getAbsolutePath();
					lastOpenPath = fileChooser.getSelectedFile().getParent();
					if (isPlaying || isPause) {
						stopPlaying();
						while (player.getAudioClip().isRunning()) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException ex) {
								ex.printStackTrace();
							}
						}
					}
					playBack();
				}
				
			}
			/**
			 * Start playing back the sound.
			 */
			private void playBack() {
				timer = new PlayingTimer(labelTimeCounter, sliderTime);
				timer.start();
				isPlaying = true;
				playbackThread = new Thread(new Runnable() {

					@Override
					public void run() {
						try {

							buttonPlay.setText("Stop");
							buttonPlay.setIcon(iconPlay);
							buttonPlay.setEnabled(true);
							
							//buttonPause.setText("Pause");
							//buttonPause.setEnabled(true);
							
							player.load(audioFilePath);
							timer.setAudioClip(player.getAudioClip());
							labelFileName.setText("Playing File: " + audioFilePath);
							sliderTime.setMaximum((int) player.getClipSecondLength());
							
							labelDuration.setText(player.getClipLengthString());
							player.play();
							
							resetControls();

						} catch (UnsupportedAudioFileException ex) {
							JOptionPane.showMessageDialog(frmMusicsort,  
									"The audio format is unsupported!", "Error", JOptionPane.ERROR_MESSAGE);
							resetControls();
							ex.printStackTrace();
						} catch (LineUnavailableException ex) {
							JOptionPane.showMessageDialog(frmMusicsort,  
									"Could not play the audio file because line is unavailable!", "Error", JOptionPane.ERROR_MESSAGE);
							resetControls();
							ex.printStackTrace();
						} catch (IOException ex) {
							JOptionPane.showMessageDialog(frmMusicsort,  
									"I/O error while playing the audio file!", "Error", JOptionPane.ERROR_MESSAGE);
							resetControls();
							ex.printStackTrace();
						}

					}
				});

				playbackThread.start();
			}

		};
		
		
		
		buttonPlay.addActionListener(MusicListener);
		
		 labelTimeCounter.setHorizontalAlignment(SwingConstants.CENTER);
		 labelTimeCounter.setForeground(Color.WHITE);
		 labelTimeCounter.setBounds(339, 0, 97, 48);
		 JLabel labelDuration = new JLabel("00:00:00");
		 labelDuration.setHorizontalAlignment(SwingConstants.CENTER);
		 labelDuration.setForeground(Color.WHITE);
		 labelDuration.setBackground(Color.WHITE);
		 labelDuration.setBounds(1033, -2, 97, 48);
		 
		 
		 
		 
		 southPanel.add(labelDuration);
		 southPanel.add(labelTimeCounter);
		 southPanel.add(labelDuration);
		 
		 
		 sliderTime.setBounds(423, 17, 625, 29);
		 
		 sliderTime.setEnabled(false);
		 sliderTime.setValue(0);
		 
		 southPanel.add(sliderTime);
		 
		
		
		
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
		
		
		JMenuItem mntmImportaBrani = new JMenuItem("Apri file");
		menu.add(mntmImportaBrani);
		

		
		mntmImportaBrani.addActionListener(new ActionListener() {
			
			public void actionPerformed1(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("priva click");
				
				JFileChooser fileChooser = new JFileChooser();;
				
				
				FileFilter wavFilter = new FileFilter() {
					@Override
					public String getDescription() {
						return "Sound file (*.WAV)";
					}

					@Override
					public boolean accept(File file) {
						if (file.isDirectory()) {
							return true;
						} else {
							return file.getName().toLowerCase().endsWith(".wav");
						}
					}
				};

				
				fileChooser.setFileFilter(wavFilter);
				fileChooser.setDialogTitle("Open Audio File");
				fileChooser.setAcceptAllFileFilterUsed(false);
				//Create a file chooser
				
				//In response to a button click:
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(new JPanel());
				

				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
				
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		
		
		//------metodi per riproduzione
		
		
		
		
		
		
		
		
		JMenuItem mntmCrea = new JMenuItem("Crea Playlist");
		menu.add(mntmCrea);
		
		
		
		JMenuItem mntmModificaPlaylist = new JMenuItem("Modifica Playlist");
		menu.add(mntmModificaPlaylist);
		
		JMenuItem mntmAggiungiPlaylist = new JMenuItem("Aggiungi a Playlist");
		menu.add(mntmAggiungiPlaylist);
		
		JMenuItem mntmRimuoviPlaylist = new JMenuItem("Rimuovi Playlist");
		menu.add(mntmRimuoviPlaylist);
		

		
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
		
		// Then on your component(s)
		showSongJTable.addMouseListener(new PopClickListener());
		
	
	}
}
