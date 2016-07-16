package model;

import java.util.ArrayList;
import java.util.List;

public class Favorits {
	List<Song> favoritSongs;
	List<Album> favoritAlbums;
	
	public Favorits() {
		// TODO Auto-generated constructor stub
		favoritAlbums = new ArrayList<>();
		favoritSongs = new ArrayList<>();
	}

	public List<Song> getFavoritSongs() {
		return favoritSongs;
	}

	public void addFavoritSong(Song favoritSong) {
		this.favoritSongs.add(favoritSong);
	}

	public List<Album> getFavoritAlbums() {
		return favoritAlbums;
	}

	public void addFavoritAlbum(Album favoritAlbum) {
		this.favoritAlbums.add(favoritAlbum);
	}
	
	
	
}
