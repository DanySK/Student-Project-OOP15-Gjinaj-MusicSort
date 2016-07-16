package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.ErrorManager;

public class Album {
	
	private static String DEFAULT = "VOID";
	private Integer id;
	private String title;
	private String genre;
	private Integer pubblicatedYear;
	private List <Artist> Artists; 
	private List< Song> AlbumSongs;
	
	public Album() {
		// TODO Auto-generated constructor stub
		
		this.title=DEFAULT;
		this.genre=DEFAULT;
		this.Artists= new ArrayList<>();
		this.AlbumSongs= new ArrayList<>();
	}
	
	public Album(List<Artist> artist, List< Song> albumSong) {
		// TODO Auto-generated constructor stub
		this.Artists= artist;
		this.AlbumSongs= albumSong;
		
	}
	

	public static String getDEFAULT() {
		return DEFAULT;
	}

	public static void setDEFAULT(String dEFAULT) {
		DEFAULT = dEFAULT;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getPubblicatedYear() {
		return pubblicatedYear;
	}

	public void setPubblicatedYear(Integer pubblicatedYear) {
		this.pubblicatedYear = pubblicatedYear;
	}

	public List<Artist> getArtists() {
		return Artists;
	}

	public void setArtists(List<Artist> artists) {
		Artists = artists;
	}

	public List< Song> getAlbumSongs() {
		return AlbumSongs;
	}

	public void setAlbumSongs(List< Song> albumSongs) {
		AlbumSongs = albumSongs;
	}
	
	public void addSong(Song song) {
		if(!this.AlbumSongs.contains(song)){
			this.AlbumSongs.add(song);
		}
		else{
			throw new IllegalArgumentException("Song Exists Yet");
		}
	}
	
	public void removeSong(Song song) {
		if(this.AlbumSongs.contains(song)){
			AlbumSongs.remove(song);
		}
		else{
			throw new IllegalArgumentException("No Song Found");
		}
		
	}
	
	

}
