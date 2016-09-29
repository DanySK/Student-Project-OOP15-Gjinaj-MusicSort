package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.sun.javafx.scene.control.skin.LabeledText;

import controller.MainController;
import model.Playlist;

import java.awt.CardLayout;
import java.awt.Color;

@SuppressWarnings("unused")
public class WestPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable westMenuTable;
	private JScrollPane scrollPane = new JScrollPane();
	private DefaultTableModel model;
	private JLabel lblPlaylist = new JLabel("Playlists");
	private List<Integer> listNotEditable = new ArrayList<>();
	private MainController controller;
	private JPopupMenu popMenuPlaylist = new JPopupMenu();
	private JMenuItem remove = new JMenuItem("remove");
	private Dimension di;
	private List<Playlist> playlists;
	private Vector<Object> rows = new Vector<>();
	int rowSelected;


	public WestPanel(MainController controller) {
		this.controller = controller;
		playlists = controller.getAllPlaylists();
		listNotEditable.add(0);
		listNotEditable.add(1);
		listNotEditable.add(2);
		listNotEditable.add(3);
		westMenuTable = new JTable(model);
		popMenuPlaylist.add(remove);

		model = new DefaultTableModel() {
			String playListSelected;
			/**
			 * change DefaultTableModel to set editable cells that i need
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return (listNotEditable.contains(row)) ? false : true;
			}

			@Override
			public void setValueAt(Object aValue, int row, int column) {
				// TODO Auto-generated method stub
				super.setValueAt(aValue, row, column);
				System.out.println("h");
			}


		};
		di = westMenuTable.getPreferredSize();
		di.width = 130;
		di.height = 550;

		rows.add(" Preferiti");
		rows.add(" Coda");
		rows.add(" Brani");
		rows.add(" Playlists");
		for (Playlist playlist : playlists) {
			rows.add(playlist.getName());
		}
		System.out.println(rows.toString());
		model.addColumn("", rows);

		westMenuTable = new JTable(model);

		model.isCellEditable(0, 1);
		model.isCellEditable(1, 1);
		model.isCellEditable(2, 1);
		scrollPane.add(westMenuTable);
		scrollPane.setViewportView(westMenuTable);

		/*
		 * westMenuTable propertis
		 */
		scrollPane.setPreferredSize(di);
		westMenuTable.setRowHeight(30);
		westMenuTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		westMenuTable.setFont(new Font("Kokonor", Font.PLAIN, 16));


		remove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("to be removed");
				controller.removePlaylist(controller.getLibraryManager().getCurrentPlaylist().getName());

			}
		});


		westMenuTable.addMouseListener(new MouseAdapter() {


			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);


				JTable source = (JTable) e.getSource();
				rowSelected = source.rowAtPoint(e.getPoint());
				int column = source.columnAtPoint(e.getPoint());

					if (!source.isRowSelected(rowSelected))
						source.changeSelection(rowSelected, column, false, false);
					System.out.println("riga numero " + rowSelected + " " + "colonna numero:" + column);
					switch(rowSelected){
					case 0:
						// preferiti
						break;
					case 1:
						// recenti
						controller.onQueueSelected();
						break;
					case 2:
						// brani
						break; 
					case 3:
						// playlist
						break;
					default:
					{
						controller.onPlaylistSelected(playlists.get(rowSelected-4).getId());
					}
					}
					System.out.println(e.getClickCount());
				if(SwingUtilities.isRightMouseButton(e)){
					popMenuPlaylist.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});

		this.add(scrollPane);
		System.out.println(rowSelected);
	}
	public void addNewPlaylist(String name) {
		// TODO Auto-generated method stub
		rows.add(name);
		System.out.println(rows.toString());
		model.insertRow(rows.size()-1, new Object[] { name });
	}
	
	

}