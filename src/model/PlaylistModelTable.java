package model;

import java.util.*;

import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

public class PlaylistModelTable extends AbstractTableModel {

	/**
	 * 
	 * set show music table
	 */
	private static final long serialVersionUID = 1L;
	private Vector<String> colNames;
	private boolean[] columnsVisible = { true, true, true, true };
	private IPlaylist playlist;
	
	/**
	 * Returns false. This is the default implementation for all cells.
	 */
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	/**
	 * sets Column names
	 */
	public PlaylistModelTable() {
		this.colNames = new Vector<String>();
	}

	/**
	 * associate to playlist model col names 
	 * @param playlist
	 */
	public PlaylistModelTable(IPlaylist playlist) {
		this.colNames = new Vector<String>();
		this.playlist = playlist;
	}
	/**
	 * set  other metod to set playlist column names using A vector passed
	 * @param colnames
	 * @param playlist
	 */
	public PlaylistModelTable(Vector<String> colnames, IPlaylist playlist) {
		this.colNames = colnames;
		this.playlist = playlist;
	}

	/**
	 * reset table
	 */
	public void resetTable() {
		playlist.getSongsList().clear();
		this.colNames.removeAllElements();
	}

	/**
	 * set a column names and update model
	 * @param colNames
	 */
	public void setColumnNames(Vector<String> colNames) {
		this.colNames = colNames;
		this.fireTableStructureChanged();
	}
/**
 * get number of columns
 */
	@Override
	public int getColumnCount() {
		return this.colNames.size();
	}

	/**
	 *Returns Object.class regardless of columnIndex. 
	 */
	@Override
	public Class<?> getColumnClass(int colNum) {
		switch (colNum) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		default:
			return String.class;
		}
	}

	/**
	 * Get Column Names as String
	 */
	@Override
	public String getColumnName(int colNum) {
		return this.colNames.get(colNum);
	}

	/**
	 * Number of Rows
	 * @return int
	 */
	@Override
	public int getRowCount() {
		return playlist.size();
	}

	/**
	 * Retrurn an object in a particular Position
	 * @return Object
	 */
	@Override
	public Object getValueAt(int row, int col) {

	    Song song = playlist.getSongsList().get(row);
	    switch (col)
	    {
	        case 0: return song.getArtist();
	        case 1: return song.getTitle();
	        case 2: return song.getAlbum();
	        default: return null;
	    } 
	}

	/**
	 * set value 
	 * @param newVal
	 * @param row
	 * @param col
	 */
	@Override
	public void setValueAt(Object newVal, int row, int col) {
		
	}
	
	/**
	 * get selected Song
	 * @param row
	 * @return Song
	 */
	public Song getSelectedSong(int row){
		return playlist.getSongsList().get(row);
	}
	/**
	 * Add Song and update model
	 * @param song
	 */
	public void addSong(Song song){
	    playlist.addSong(song);
	    fireTableRowsInserted(getRowCount(), getRowCount());
	}
	/**
	 * Romove Song
	 * @param row
	 */
	public void removeSong(int row){
	    playlist.removeSong(row);
	    fireTableRowsDeleted(getRowCount(), getRowCount());
	}

	/**
	 * Sets Column Visible
	 * @param index
	 * @param visible
	 */
	public void setColumnVisible(int index, boolean visible) {
		this.columnsVisible[index] = visible;
		this.fireTableStructureChanged();
	}
	/**
	 * refresh Model
	 * @param playlist
	 */
	public void refresh(IPlaylist playlist){
		this.playlist = playlist;
	    //make the changes to the table, then call fireTableChanged
	    fireTableChanged(null);
	}
}
