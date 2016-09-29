package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import controller.MainController;
import model.Playlist;
import model.LibraryManager;
import util.FileHelper;

public class RemoveListener implements ActionListener {
	MainController controller;
	int playlistIdToRemove;
	Playlist p;
	private static final String PLAYLISTS_FOLDER = "res/playlists";

	private static final String PLAYLIST_EXTENSION = ".txt";

	public RemoveListener(MainController controller, int string,List<Playlist> playlists) {
		// TODO Auto-generated constructor stub
		this.controller = controller;
		playlistIdToRemove = string;
		p = playlists.get(string);
		//p = controller.getTracksManager().getPlaylistById(playlistIdToRemove);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(playlistIdToRemove);
		// TODO Auto-generated method stub
		//FileHelper.deletePlaylist(p, PLAYLISTS_FOLDER, PLAYLIST_EXTENSION);
	}

}
