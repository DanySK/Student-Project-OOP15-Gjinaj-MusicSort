package model;

import java.util.List;

public class Artist extends Person {
	
	private static Integer DEFAULTSTARS = 0;
	private static Integer DEFAULLISTENDCOUNT = 0;
	private static String DEFAULTNAME = "VOID";
	private Song bestSong;
	private List<Song> artistAlbum;
	private String genre ;
	private Integer listenedCount;
	private Integer star;
	
	 
	public Artist(String name, String cf, String genre) {
		super(DEFAULTNAME, cf);
		this.genre=genre;
		this.listenedCount=DEFAULLISTENDCOUNT;
		this.star=DEFAULTSTARS;
		// TODO Auto-generated constructor stub
	}
	
	public Artist(String Name, String cf, List<Song> artistAlbum) {
		// TODO Auto-generated constructor stub
		super(Name, cf);
		this.artistAlbum=artistAlbum;
	}
	
	


	public Song getBestSong() {
		return bestSong;
	}


	public void setBestSong(Song bestSong) {
		this.bestSong = bestSong;
	}


	public List<Song> getArtistSong() {
		return artistAlbum;
	}


	public void setArtistAlbum(List<Song> artistAlbum) {
		this.artistAlbum = artistAlbum;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public Integer getListenedCount() {
		return listenedCount;
	}


	public void setListenedCount(Integer listenedCount) {
		this.listenedCount = listenedCount;
	}


	public Integer getStar() {
		return star;
	}


	public void setStar(Integer star) {
		this.star = star;
	}
	
	
	
}