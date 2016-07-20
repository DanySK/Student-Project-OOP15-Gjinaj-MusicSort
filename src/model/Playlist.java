package model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
	
	private static Playlist playlist = null;
	
	List<Song> songsList;
	String palylistTitle;
	
	//work in progress
	public Playlist(String title) {
		// TODO Auto-generated constructor stub
		songsList = new ArrayList<>();
		this.palylistTitle=title;
	}
	
	
	   public static Playlist getInstance(String title) {
	      if(playlist == null) {
	    	  playlist = new Playlist( title);
	      }
	      return playlist;
	   }


	public static Playlist getPlaylist() {
		return playlist;
	}


	public static void setPlaylist(Playlist playlist) {
		Playlist.playlist = playlist;
	}


	public List<Song> getSongsList() {
		return songsList;
	}

//
//	public void setSongsList(List<Song> songsList) {
//		this.songsList = songsList;
//	}


	public String getPalylistTitle() {
		return palylistTitle;
	}


	public void setPalylistTitle(String palylistTitle) {
		this.palylistTitle = palylistTitle;
	}
	   

}
