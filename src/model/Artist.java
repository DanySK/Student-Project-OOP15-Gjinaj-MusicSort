package model;

import java.util.List;

public class Artist extends Person {
	
	private static Integer DEFAULTSTARS = 0;
	private static Integer DEFAULLISTENDCOUNT = 0;
	private static String DEFAULTNAME = "VOID";
	private Song bestSong;
	private List<Album> artistSong;
	private String genre ;
	private Integer listenedCount;
	private Integer star;
	
	 
	public Artist(String name, String id, String genre) {
		super(DEFAULTNAME, id);
		this.genre=genre;
		this.listenedCount=DEFAULLISTENDCOUNT;
		this.star=DEFAULTSTARS;
		// TODO Auto-generated constructor stub
	}
	
	
	
}
