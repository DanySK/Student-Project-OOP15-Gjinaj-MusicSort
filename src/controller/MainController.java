package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;


import model.IPlaylist;
import model.MpegInfo;
import model.Playlist;
import model.Song;
import model.SongQueue;
import model.LibraryManager;
import util.FileHelper;
import util.Mp3Player;
import util.PositionSongThread;
import view.CentralPanel;
import view.WestPanel;
import view.MainView;
import view.SouthPanel;
import controller.MusicControllerInterface;
import view.ProgressBarThread;
/**
 * Controller class.
 * @author Rrok Gjinaj
 *
 */
public class MainController implements MusicControllerInterface {

	private MpegInfo mp3Info;

	private boolean paused = true;
	private Mp3Player mp3Player;
	private String audioFilePath;
	private LibraryManager libraryManager;
	
	
	private MainView view; 
	private CentralPanel centralPanel;
	private SouthPanel southPanel;
	private WestPanel westPanel;
	
	private IPlaylist currentViewPlaylist;
	private ProgressBarThread progressBar;
	private PositionSongThread positionSongThread;


	/**
	 * Controller class.
	 * @author Rrok Gjinaj
	 *
	 * 
     * Controller constructor.
	 * @param libraryManager
     * @param view GUI
     * @param model MODEL
     
	 */
	public MainController(LibraryManager libraryManager) {
		this.mp3Player = Mp3Player.newInstance(this);
		this.mp3Info = MpegInfo.getInstance();
		this.libraryManager =libraryManager ;
		
		currentViewPlaylist = libraryManager.getCurrentPlaylist();
		positionSongThread = new PositionSongThread(this);
		positionSongThread.start();
	}

    /**
     * Set the main view with panels
     * 
     */
	public void setView(MainView view){
		this.view = view;
		this.centralPanel = view.centralPanel;
		this.westPanel= view.westPanel;
		this.southPanel = view.southPanel;
		updatePlaylistView(libraryManager.getCurrentPlaylist());
	}
	
    /**
     * Get Playlist by Id and update the that is playing
     * @param idPlaylist
     */
	public void onPlaylistSelected(String id){
		currentViewPlaylist = libraryManager.getPlaylistById(id);
		updatePlaylistView(currentViewPlaylist);
	}

    /**
     * Get Playlist Song by Index of playlist to play and set the playlist is playing and update current song 
     * if Playlist is istance og SongQueue, set current playlist SongQueue
     * @param Index
     * 
     */
	public void onSongSelected(int index){

		if(currentViewPlaylist instanceof SongQueue){
			libraryManager.setCurrentPlaylistAsQueue();
		} else {
			libraryManager.setCurrentPlaylist(currentViewPlaylist.getId());
		}
		libraryManager.setCurrentSong(index);
		this.startBarThread();
		Song song = libraryManager.getSongAtPosition(index);
		mp3Player.play(song.getPath());
		southPanel.setPauseIcon();
		this.setSouthData();
		positionSongThread.resetPositionThread();
		positionSongThread.setPausedThread(false);
		southPanel.enableButtons();
		
	}
    /**
     * Get Playlist Song by Index
     * @param Index
     * @return Song
     */
	public Song onSongSelectedToPlaylist(int index){
		return libraryManager.getSongAtPosition(index);
	}
	
    /**
     * Update Playlist View changing the model of playlist to show
     * @param IPlaylist
     */
	public void updatePlaylistView(IPlaylist playlist){
		centralPanel.changeModel(playlist);
	}

	/**
	 * Obtain the MpegInfo instance.
	 * 
	 * @return tagInfo
	 */
	public MpegInfo getMpegInfo() {
		return this.mp3Info;
	}
	
	 /**
     * {@inheritDoc}
     */
	public void resume() {
		try {
			mp3Player.resume();
			southPanel.setPauseIcon();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.paused = false;
		positionSongThread.setPausedThread(false);
	}
	
	
	 /**
     * {@inheritDoc}
     */
	@Override
	public void play() {
		Song song = libraryManager.getCurrentSong();
		southPanel.setPauseIcon();
		this.setSouthData();
		mp3Player.play(song.getPath());
		this.paused = false;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		positionSongThread.resetPositionThread();
		positionSongThread.setPausedThread(false);

	}
	
	/**
    * Show a JFile choser letting the user to open new track and 
    * sets audioFilePath of the new track opened
    * sets the south panel data to show new infromation of the new LibraryManager
    */
	public void openTrack(String audioFilePath) {
		this.audioFilePath=audioFilePath;
		libraryManager.addSongToQueue(FileHelper.loadSong(audioFilePath));
		libraryManager.setCurrentPlaylistAsQueue();
		libraryManager.setCurrentSong(libraryManager.getQueue().size()-1);
		centralPanel.changeModel(libraryManager.getQueue());
		
		
		
		southPanel.setPauseIcon();
		
		positionSongThread.resetPositionThread();
		positionSongThread.setPausedThread(false);
		setSouthData();
		this.startBarThread();
		southPanel.enableButtons();
		mp3Player.play(audioFilePath);
		
	}

/**
 * On track finished, controller calls libraryManager set ask the next Song to Play, if Playlist 
 * is finisced, it start form the fist palylist song
 * Reset position of song
 * 
 */
	public void onTrackFinished(){
		String nextSongPath = libraryManager.getNextSong().getPath();
		mp3Player.play(nextSongPath);
		southPanel.setPauseIcon();
		setSouthData();
		positionSongThread.resetPositionThread();
		positionSongThread.setPausedThread(false);
	}
	/**
	 * If user selcts Queue
	 * will be setted as current playlist the queue beacuse Queue is a particular playlist
	 * it update model of song to show
	 */
	public void onQueueSelected(){
		currentViewPlaylist = libraryManager.getQueue();
		centralPanel.changeModel(libraryManager.getQueue());
	}

	/**
	 *{Not used yet}  permit to rename palylist
	 * @param id
	 * @param name
	 */
	public void renamePlaylist(String id, String name){
		libraryManager.renamePlaylist(id, name);
	}

	 /**
     * {@inheritDoc}
     */
	@Override
	public boolean isPaused() {
		return this.paused;
	}
/**
 * Create new playlist by name given from north panel
 * @param name 
 * @return Playlist
 */
	public Playlist createPlaylist(String name){
		westPanel.addNewPlaylist(name);
		return libraryManager.createNewPlaylist(name);		
	}

	 /**
     * {@inheritDoc}
     */
	@Override
	public void pause() {
		mp3Player.pause();
		this.paused = true;
		positionSongThread.setPausedThread(true);
	}
	
	 /**
     * {@inheritDoc}
     */
	@Override
	public void nextTrack() {
		mp3Player.play(libraryManager.getNextSong().getPath());
		southPanel.setPauseIcon();
		setSouthData();
		positionSongThread.resetPositionThread();
		positionSongThread.setPausedThread(false);
	}
	 /**
     * {@inheritDoc}
     */
	@Override
	public void previuosTrack() {
		mp3Player.play(libraryManager.getNextSong().getPath());
		southPanel.setPauseIcon();
		positionSongThread.resetPositionThread();
		positionSongThread.setPausedThread(false);
	}

/**
 * Get a list of name of playlist stream().forEach
 * @return List<String>
 */
	public List<String> getPlaylistsNames(){
		List<String> names = new ArrayList<>();
		libraryManager.getAllPlaylists().stream().forEach(p -> {
			names.add(p.getName());
		});
		return names;
	}
	
	 /**
     * {@inheritDoc}
     */
	public LibraryManager getLibraryManager() {
		return libraryManager;
	}

	/**
	 * return teh list of playlists given by library Manager
	 * @return List<Playlist>
	 */
	public List<Playlist> getAllPlaylists() {
		return libraryManager.getAllPlaylists();
	}

	/**
	 * {not user yet}  remove a playlist from playlists by name but will be done using as param playlistId
	 * @param playlistName
	 */
	public void removePlaylist(String playlistName) {
		// TODO Auto-generated method stub
	}

	 /**
     * Start Thread of seekbar
     */
	public void startBarThread() {
		// TODO Auto-generated method stub
		if(progressBar==null){
			progressBar=this.southPanel.barThread;
			progressBar.start();
		}
		else {
			setSouthData();
		}
	}
	/**
	 * save Playlist if there are new one or one of them is modified
	 */
	public void persistPlaylists(){
		libraryManager.persistPlaylists();
	}

	/**
	 * set in pause icon play
	 * 
	 */
	public void setPauseIcon(){
		southPanel.setPauseIcon();
	}
	
	/**
	 * set in play icon pause
	 * 
	 */
	public void setPlayIcon(){
		southPanel.setPlayIcon();
	}
	/**
	 * set param of south panel when it is called
	 * 
	 */
	public void setSouthData() {
		int totSec= this.getCurrentSongSeconds();
		southPanel.setSouthData(this.libraryManager.getCurrentSong().getDuration().getMin()+":"+this.libraryManager.getCurrentSong().getDuration().getSec()+"  ",
						totSec);
	}
	
	 /**
     * {@inheritDoc}
     */
	public String getReproducingSongInfo() {
		return libraryManager.getCurrentSong().getTitle()+" - "+libraryManager.getCurrentSong().getArtist(); 
	}
	/**
	 * get the progress bar thread
	 * @return ProgressBarThread
	 */
	public ProgressBarThread getProgressBar() {
		return progressBar;
	}
	
	/**
	 * give the current song seconds used to set setMaximum of progress bar
	 * @return totalSecondSong int
	 */
	public int getCurrentSongSeconds(){
		return this.libraryManager.getCurrentSong().getDuration().getMin() * 60
				+ this.libraryManager.getCurrentSong().getDuration().getSec();
	}
	
	/**
	 * get the current song position using thread
	 * @return SongPos
	 */
	public int getSongPos(){
		return positionSongThread.getValue();
	}

	public void stop() {
		// TODO Auto-generated method stub
		southPanel.Stop();
		mp3Player.stop();
		this.paused=true;
		positionSongThread.resetPositionThread();
		
	}
}