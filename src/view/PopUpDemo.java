package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import controller.MainController;
import model.Playlist;



public class PopUpDemo extends JPopupMenu{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuItem remove;
	JMenuItem salva_nei_preferiti;
	JMenu sectionsMenu = new JMenu("Aggiungi Alla Playlist");

	List<JMenuItem> menuPlaylisToAdd = new ArrayList<>();

	public PopUpDemo(MainController controller, int rowSelected){
		for(String name: controller.getPlaylistsNames()){
			menuPlaylisToAdd.add(new JMenuItem(name));
		}
		for (int i = 0; i < controller.getAllPlaylists().size(); i++) {
			sectionsMenu.add(menuPlaylisToAdd.get(i) );
			menuPlaylisToAdd.get(i).addActionListener( new listenerAddToPlaylist(rowSelected,menuPlaylisToAdd.get(i).getText(),controller));
			
		}
		remove = new JMenuItem("remove");
		remove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
	
					//se rimuovo la canzone che stavo ascoltando fermo il player.
					//controller.stop();
					System.out.println(rowSelected);

				controller.getLibraryManager().getCurrentPlaylist().removeSong(rowSelected);
				System.out.println("rimossa");
			}
		});
		this.add(remove);
		this.add(sectionsMenu);
	}
}

class listenerAddToPlaylist implements ActionListener
{
	int row;
	String playlist;
	MainController controller;

	public listenerAddToPlaylist(int rowSelected, String string, MainController controller) {
		// TODO Auto-generated constructor stub
		this.row=rowSelected;
		this.playlist= string;
		this.controller= controller;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("riga:"+row+"aggiunta alla playlist:"+playlist);
		for(Playlist p: controller.getAllPlaylists()){
			if(p.getName().equals(playlist)){
				p.addSong(controller.onSongSelectedToPlaylist(row));
			}
		}
	}

}