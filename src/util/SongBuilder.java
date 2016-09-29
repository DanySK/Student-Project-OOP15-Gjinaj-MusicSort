package util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import model.Duration;
import model.MpegInfo;
import model.Song;

public class SongBuilder {
	
	/**
	 * Create a new songe From path with datas
	 * If the song doesn't have title there will show Unknow
	 * @param mp3Info
	 * @param path
	 * @return Song
	 */
	public static Song buildSong(MpegInfo mp3Info, String path){
		Duration duration = new Duration(mp3Info.getDurationInMinutes().getMin(),mp3Info.getDurationInMinutes().getSec());
		Path p = Paths.get(path);
		String fileName = new File(path).getName();
		String artist = mp3Info.getArtist().orElse("Unknow");
		String title = mp3Info.getTitle().orElse(fileName);
		String album = mp3Info.getAlbum().orElse("Unknow");
		String genre = mp3Info.getGenre().orElse("Unknow");
		return new Song(title, artist, album, genre, path, duration);
	}
}
