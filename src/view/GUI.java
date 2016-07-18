package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.DefaultListCellRenderer.UIResource;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;


public class GUI extends JFrame{

	private static final double PERC_HALF = 0.5;
    private static final double PERC_QUATER = 0.25;
    private final JFrame frame;
    private final JScrollPane scrollPane = new JScrollPane();
    private JList<String> songList;
    private boolean playing = false;
    private boolean stopped = true;
    private String selectedSongName;
    private String selectedPlaylistName;
    private JSlider seekBar = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 0);
    private Integer[] infoLibraryArray = new Integer[3];
    //private final JLabel lbInfoLibrary = new JLabel("Numero brani + minutaggio: ");
    private final JButton brani = new JButton("Brani");
    private final JButton artisti = new JButton("Artisti");
    private final JButton playlist = new JButton("Plalist");
    private final JSlider volume = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 50);
    
    
    public GUI() {

        seekBar.setDoubleBuffered(true);
        frame = new JFrame("Music Sort Player");
        final JPanel pnLanding = new JPanel(new BorderLayout());
        frame.setFont(new Font("Trajan Pro", Font.PLAIN, 12));
        final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        final int x = (int) (dimension.getWidth() * PERC_HALF - dimension.getWidth() * PERC_QUATER);
        final int y = (int) (dimension.getHeight() * PERC_HALF - dimension.getHeight() * PERC_QUATER);
        frame.setSize((int) (dimension.getWidth() * 0.55), (int) (dimension.getHeight() * 0.55));
        frame.setLocation(x, y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(200, 100));
        
        ////////////// right PANEL FOR IMAGE AND INFO CURRENT SONG ///////////////////

        final JPanel destro = new JPanel();
        destro.setLayout(new BoxLayout(destro, BoxLayout.Y_AXIS));
        destro.setBackground(new Color(140, 220, 170));
       // final URL imgURL = UIResource.class.getResource("/beesound.jpg");
        final JLabel lbImage = new JLabel();
       /* BufferedImage img = null;
        try {
            img = ImageIO.read(imgURL); 
        } catch (IOException e) {
            e.printStackTrace();
        }
        final Image resizedImg = img.getScaledInstance((int) (frame.getWidth() * 0.42),
                (int) (frame.getHeight() * 0.72), Image.SCALE_SMOOTH);
        final ImageIcon newImg = new ImageIcon(resizedImg);
        lbImage.setIcon(newImg);
        lbImage.setAlignmentX(Component.CENTER_ALIGNMENT);*/
        final JLabel songCorrente = new JLabel("Informazioni canzone");
        songCorrente.setPreferredSize(new Dimension((int) (frame.getWidth() * 0.45),
                (int) (frame.getHeight() * 0.2)));
        songCorrente.setAlignmentX(Component.CENTER_ALIGNMENT);

        destro.add(lbImage);
        destro.add(this.seekBar);
        destro.add(songCorrente);
        
        ////////////// CENTER PANEL: LIST SELECTION & INFO LABEL ////////////////////////

        final JPanel pnListView = new JPanel();
        pnListView.setLayout(new BoxLayout(pnListView, BoxLayout.Y_AXIS));
        final JPanel pnInfoLibrary = new JPanel();
        pnInfoLibrary.setMaximumSize(new Dimension(32767, 30));
        pnInfoLibrary.setBackground(new Color(100, 100, 255));

        pnListView.add(scrollPane);
        //pnListView.add(pnInfoLibrary);
        //pnInfoLibrary.add(lbInfoLibrary, FlowLayout.LEFT);

        ////////////// SOUTH PANEL: CONTROL PLAYER'S BUTTONS ////////////////////////

        final JPanel pnPlayerButtons = new JPanel(new FlowLayout());
        final JButton play = new JButton(" ▶ ");
        final JButton stop = new JButton(" ■ ");
        final JButton prec = new JButton(" << ");
        final JButton succ = new JButton(" >> ");
        final JButton shuffle = new JButton("Shuffle");
        //final JButton btLinear = new JButton("Linear");
        final JLabel vol = new JLabel(" volume ");

        // PLAY
        /*action listeners*/
        
        
        
        
        
        /////////////////// LEFT PANEL & BUTTONS ////////////////////////

        final JPanel sinistro = new JPanel(new GridLayout(0, 1, 0, 0));
        sinistro.setPreferredSize(new Dimension(85, 0));
        final JButton btAlbum = new JButton("Album");
        final JButton btArtist = new JButton("Artisti");
        final JButton btPlaylist = new JButton("Playlist");
   /*action listeners */
        
        
        
        
        
        sinistro.add(brani);
        sinistro.add(btAlbum);
        sinistro.add(btArtist);
        sinistro.add(btPlaylist);
        
        
        
        
    }  
    public void setVisible(final boolean visible) {
        this.frame.setVisible(visible);
    }
}