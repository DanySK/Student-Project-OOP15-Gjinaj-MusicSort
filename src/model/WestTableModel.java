package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;


public class WestTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private Vector<String> colNames;
	private List<String> playlists = new ArrayList<>();
	@SuppressWarnings("unused")
	private IPlaylist queue;

	
	public WestTableModel(Vector<String> colnames, List<Playlist> playlists, IPlaylist queue) {
		
		this.colNames = colnames;
		System.out.println(queue.getName());
		String s = queue.getName();
		System.out.println(queue.getName()+"dio porco");
		this.playlists.add(s);
;		for(Playlist p: playlists ){
			this.playlists.add(p.getName());
		}
	}

	/**
	 * reset table
	 */
	public void resetTable() {
		playlists.clear();
		this.colNames.removeAllElements();
	}
	
	
	/**
	 * set a column names and update model
	 * @param colNames Vectior of scring
	 */
	public void setColumnNames(Vector<String> colNames) {
		this.colNames = colNames;
		this.fireTableStructureChanged();
		
	}
	/**
	 * Number of Rows
	 * @return int
	 */
	@Override
	public int getRowCount() {
		return playlists.size();//la queue
	}

	/**
	 *Returns Object.class regardless of columnIndex. 
	 */
	@Override
	public Class<?> getColumnClass(int colNum) {
		switch (colNum) {
		case 0:
			return String.class;
		default:
			return String.class;
		}
	}

	@Override
	public int getColumnCount() {
		return colNames.size();
	}

	/**
	 * Get Column Names as String
	 */
	@Override
	public String getColumnName(int colNum) {
		return this.colNames.get(colNum);
	}

	@Override
	public String getValueAt(int row, int col) {
	    String pName = playlists.get(row);
	    return  pName;
	}
	public boolean isCellEditable(int rowIndex, int columnIndex, List<Integer> listNotEditable) {
		// TODO Auto-generated method stub
		return false;
	}

	public void refresh(List<Playlist> playlists, IPlaylist queue) {
		// TODO Auto-generated method stub
		this.playlists.clear();
		this.playlists.add(queue.getName());
		for(IPlaylist p : playlists){
			this.playlists.add(p.getName());
		}
		System.out.println(playlists.toString());
		fireTableChanged(null);
	}
}
