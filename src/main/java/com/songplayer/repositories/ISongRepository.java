package main.java.com.songplayer.repositories;

import main.java.com.songplayer.dto.SongResponse;
import main.java.com.songplayer.entities.Song;

import java.util.List;

public interface ISongRepository {
    void addSong(Song s);
    List<SongResponse> listSongsByGenre(String genre);
    Song getSongById(String songId);
}
