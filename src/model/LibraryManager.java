package model;

import java.io.File;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.apple.eio.FileManager;

import sun.util.logging.resources.logging;
import util.FileHelper;
/**
 * 
 * @author rrok
 *
 */
public class LibraryManager {
	/**
	 * There are songQueue and 
	 * @return userPlaylists List<Playlist>
	 */
	private List<Playlist> userPlaylists = new ArrayList<Playlist>();
	
	private SongQueue songQueue;
	/**
	 * currentPlaylist is teh playlist that i'm playing now
	 */
	private IPlaylist currentPlaylist;
	private CurrentSong currentSong;
	private static final String PLAYLISTS_FOLDER = "res/playlists";
	private static final String PLAYLIST_EXTENSION = ".txt";
	private static final String QUEUE_EXTENSION = ".queue";
	/**
	 * set first the song queue as the first selected Playlist
	 */
	public LibraryManager(){
		songQueue = SongQueue.getInstance();
		loadTracks();
	}
	/** 
	 * get Playlist Folder
	 * @return String
	 */
	public static String getPlaylistsFolder() {
		return PLAYLISTS_FOLDER;
	}
	
	/**
	 * loads all playlists (and queue) from playlist folder
	 * PLAYLISTS_FOLDER is the path where the user save all palylist
	 */
	private void loadTracks(){
		String playListFolderPath = new File(PLAYLISTS_FOLDER).getAbsolutePath();
		System.out.println(playListFolderPath);
		List<IPlaylist> list = FileHelper.loadPlayLists(playListFolderPath, PLAYLIST_EXTENSION, QUEUE_EXTENSION);
		for(IPlaylist p : list){
			if(p instanceof SongQueue){
				songQueue = (SongQueue)p;
			} else {
				userPlaylists.add((Playlist)p);
			}
		}
		currentPlaylist = songQueue;
	}
	
	
	/**
	 * 
	 *  Used to save all palylist that were created or were the have ad changes
	 */
	public void persistPlaylists(){
		FileHelper.persistPlaylist(songQueue, PLAYLISTS_FOLDER, QUEUE_EXTENSION);
		for(Playlist p: userPlaylists){
			FileHelper.persistPlaylist(p, PLAYLISTS_FOLDER, PLAYLIST_EXTENSION);
		}
	}
	
	/**
	 * Create a new palylist with name
	 * @param name
	 * @return Playlist
	 */
	public Playlist createNewPlaylist(String name){
		Playlist playlist = new Playlist(name, Playlist.Status.UPDATED);
		this.userPlaylists.add(playlist);
		return playlist;
	}
	
	/**
	 * get Song At Position
	 * @param index
	 * @return Song
	 */
	public Song getSongAtPosition(int index){

		return this.currentPlaylist.getSongsList().get(index);
	}
	
	/**
	 * (not uset yet) rename a playlist name
	 * @param id
	 * @param name
	 */
	public void renamePlaylist(String id, String name){
		FileHelper.renamePlaylist(getPlaylistById(id).getName(), name, PLAYLISTS_FOLDER, PLAYLIST_EXTENSION);
		getPlaylistById(id).renamePlaylist(name);
	}
	
	/**
	 * sets  queue as current palylist when it needs
	 */
	public void setCurrentPlaylistAsQueue(){
		this.currentPlaylist = this.songQueue;
	}
	
	/**
	 * Delete a playlist from id
	 * @param id
	 */
	public void deletePlaylist(String id){
		FileHelper.deletePlaylist(getPlaylistById(id), PLAYLISTS_FOLDER, PLAYLIST_EXTENSION);
	}
	
	public void addSongToQueue(Song song){
		this.songQueue.addSong(song);
	}
	
	/**
	 * 
	 * remove song form queue
	 *{not used yet}
	 * @param song
	 */
	public void removeSongFromQueue(Song song){
		this.songQueue.removeSong(song);
	}
	
	/**
	 * Get the queue 
	 * @return IPlaylist
	 */
	public IPlaylist getQueue(){
		return songQueue;
	}
	/**
	 *  Get all playlists 
	 * @return List<Playlist>
	 */
	public List<Playlist> getAllPlaylists(){
		return this.userPlaylists;
	}
	
	/**
	 * Add a song to the playlist by index
	 * @param song
	 * @param playListIndex
	 */
	public void addSongToPlaylist(Song song, int playListIndex){
		this.userPlaylists.get(playListIndex).addSong(song);
	}
	
	/**
	 * set Current playlist is playing using id
	 * @param id
	 */
	public void setCurrentPlaylist(String id){
		this.currentPlaylist = getPlaylistById(id);
		if(getPlaylistById(id) == null){
			System.out.println("current playlist null");
		}
	}
	
	/**
	 * Get is playling
	 * @return IPlaylist
	 */
	public IPlaylist getCurrentPlaylist(){
		return this.currentPlaylist;
	}
	
	
	
	/**
	 * set current song playing buy index
	 * @param index
	 */
	public void setCurrentSong(int index){
		this.currentSong = new CurrentSong(getSongAtPosition(index), index);
	}
	
	/**
	 * get A playlist By id
	 * @param id
	 * @return Playlist
	 */
	public Playlist getPlaylistById(String id){
		for(Playlist p : userPlaylists){
			if(p.getId().equals(id)){
				return p;
			}
		}
		return null;
	}
	
	/**
	 * get current song is playing 
	 * @return Song
	 */
	public Song getCurrentSong(){
		return this.currentSong.song;
	}

	/**
	 * Metod to print messages
	 * @param mes
	 */
	private void log(String mes){
		System.out.println(mes);
	}
	
	/**
	 * get the next Song
	 * @return Song
	 */
	public Song getNextSong(){
		int playListLength = currentPlaylist.size();
		if(currentSong == null){
			log("null");
		}
		Song nextSongToBePlayed = currentPlaylist.getSongsList().get((currentSong.getPositionInPlaylist()+1)%playListLength);
		currentSong.update(nextSongToBePlayed, currentSong.getPositionInPlaylist()+1);
		return nextSongToBePlayed;
	}
	/**
	 * get the previous SOng
	 * @return Song
	 */
	public Song getPreviousSong(){
		int playListLength = currentPlaylist.size();
		int nextSongToBePlayedIndex = (currentSong.getPositionInPlaylist()-1) == -1 ? 
				playListLength-1 : currentSong.getPositionInPlaylist()-1;
		Song nextSongToBePlayed = currentPlaylist.getSongsList().get(nextSongToBePlayedIndex);
		currentSong.update(nextSongToBePlayed, nextSongToBePlayedIndex);
		return nextSongToBePlayed;
	}
	
	/**
	 * 
	 * @author rrok
	 *
	 */
	private class CurrentSong{
		private Song song;
		private int positionInPlaylist;

		/**
		 * set the current song parameter
		 * @param song
		 * @param positionInPlaylist
		 */
		public CurrentSong(Song song, int positionInPlaylist){
			this.song = song;
			this.positionInPlaylist = positionInPlaylist;
		}
		/**
		 * return the current song
		 * @return Song
		 */
		public Song getSong() {
			return song;
		}
		/**
		 * Change the current song
		 * @param song
		 * @param positionInPlaylist
		 */
		public void update(Song song, int positionInPlaylist) {
			this.song = song;
			this.positionInPlaylist = positionInPlaylist;
		}
		/**
		 * get the index of the song in playlist
		 * @return int
		 */
		public int getPositionInPlaylist() {
			return positionInPlaylist;
		}
	}
}
