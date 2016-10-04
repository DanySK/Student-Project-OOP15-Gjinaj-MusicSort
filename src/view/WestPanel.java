package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import controller.MainController;
import model.Playlist;
import model.WestTableModel;

@SuppressWarnings("unused")
public class WestPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private WestTableModel westTableModel = null;
	private JTable westMenuTable;
	private JScrollPane scrollPane = new JScrollPane();
	private JLabel lblPlaylist = new JLabel("Playlists");
	

	private List<Integer> listNotEditable = new ArrayList<>();
	private MainController controller;
	private JPopupMenu popMenuPlaylist = new JPopupMenu();
	private JMenuItem remove = new JMenuItem("Rimuovi");
	private Dimension di;
	

	private Vector<String> column = new Vector<>();
	int rowSelected;


	/**
	 * west panel 
	 * @param controller MainController
	 */
	public WestPanel(MainController controller) {


		westMenuTable = new JTable();
		List<Playlist> listPlaylist = new ArrayList<>();
		listPlaylist =controller.getAllPlaylists();
		
		westTableModel = new WestTableModel(column, listPlaylist, controller.getQueue());
		
		column.add("West Menu");
		westTableModel.setColumnNames(column);


		westMenuTable.setModel(westTableModel);
		this.controller = controller;

		popMenuPlaylist.add(remove);

		di = westMenuTable.getPreferredSize();
		di.width = 130;
		di.height = 550;


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
				if(rowSelected==0){
						JOptionPane.showMessageDialog(new Frame(),
								"non puoi rimovuere la coda.",
							    "Warning",JOptionPane.WARNING_MESSAGE);
				}
				else{
					controller.removePlaylist(controller.getAllPlaylists().get(rowSelected-1).getId(), rowSelected-1);
				}
			}
		});
		westMenuTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);

				JTable source = (JTable) e.getSource();
				rowSelected = source.rowAtPoint(e.getPoint());
				int column = source.columnAtPoint(e.getPoint());

				if (!source.isRowSelected(rowSelected))
					source.changeSelection(rowSelected, column, false, false);
				switch(rowSelected){
				case 0:
					controller.onQueueSelected();
					break;
				default:
				{
					controller.onPlaylistSelected(controller.getAllPlaylists().get(rowSelected-1).getId());
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
	public void changeModel(){
		westTableModel.refresh(controller.getAllPlaylists(),controller.getQueue());
	}
}