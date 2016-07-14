package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Album {
	
	private static String DEFAULT = "VOID";
	
	private String title;
	private String genre;
	private Integer pubblicatedYear;
	private List <Artist> Artists; 
	private Map< Integer, Song> AlbumSongs;
	
	public Album() {
		// TODO Auto-generated constructor stub
		
		this.title=DEFAULT;
		this.genre=DEFAULT;
		this.Artists= new ArrayList<>();
		this.AlbumSongs= new HashMap<>();
	}
	
	public Album(List<Artist> artist, Map<Integer, Song> albumSong) {
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

	public Map<Integer, Song> getAlbumSongs() {
		return AlbumSongs;
	}

	public void setAlbumSongs(Map<Integer, Song> albumSongs) {
		AlbumSongs = albumSongs;
	}
	
	public void addSong(Song song) {
		if(!this.AlbumSongs.containsKey(song.getId())){
			this.AlbumSongs.put(song.getId(), song);
		}
		
	}
	
	

}
