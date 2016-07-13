package model;

public class Artist extends Person {
	
	private static Integer DEFAULTSTARS = 0;
	private static Integer DEFAULLISTENDCOUNT = 0;
	private String bestSong;
	
	private String genre ;
	private Integer listenedCount;
	private Integer star;
	public Artist(String name, int id, String genre) {
		super(name, id);
		this.genre=genre;
		this.listenedCount=DEFAULLISTENDCOUNT;
		this.star=DEFAULTSTARS;
		// TODO Auto-generated constructor stub
	}
}
