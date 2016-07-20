package model;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.nio.file.Path;
import java.util.Random;

public class Song {
	
	private static Integer DEFAULTSTARS = 0;
	private static Integer DEFAULLISTENDCOUNT = 0;
	
	
	private Integer id;
	private Integer len;
	private Integer star;
	private Integer listenedCount;
	private String addedDate;
	private double duration;
	private String title;
	private String album;
	private String artist;
	private String genre;
	private Path songPath;
	
	public Song(Integer len, double duration, String title, String Album, String artist, String Genre, Path songPath) {
		// TODO Auto-generated constructor stub
		 
		Random rand = new Random();
		int  n = rand.nextInt(50) + 1;
		this.id = n;
		
		this.len=len;
		this.star=DEFAULTSTARS;
		this.listenedCount=DEFAULLISTENDCOUNT;
		this.addedDate= this.getDateTime();
		this.duration = duration;
		this.title= title;
		this.album= Album;
		this.genre= Genre;
		this.songPath= songPath;
		
		
		
	}
	
	private String getDateTime() {
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();
	    return dateFormat.format(date);
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getLen() {
		return len;
	}



	public void setLen(Integer len) {
		this.len = len;
	}



	public Integer getStar() {
		return star;
	}



	public void setStar(Integer star) {
		this.star = star;
	}



	public Integer getListenedCount() {
		return listenedCount;
	}



	public void setListenedCount(Integer listenedCount) {
		this.listenedCount = listenedCount;
	}



	public String getAddedDate() {
		return addedDate;
	}



	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
	}



	public double getDuration() {
		return duration;
	}



	public void setDuration(double duration) {
		this.duration = duration;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAlbum() {
		return album;
	}



	public void setAlbum(String album) {
		this.album = album;
	}



	public String getArtist() {
		return artist;
	}



	public void setArtist(String artist) {
		this.artist = artist;
	}



	public String getGenre() {
		return genre;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}



	public Path getSongPath() {
		return songPath;
	}



	public void setSongPath(Path songPath) {
		this.songPath = songPath;
	}

}
