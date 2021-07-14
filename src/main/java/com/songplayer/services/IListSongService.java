package main.java.com.songplayer.services;

import main.java.com.songplayer.dto.SongResponse;

import java.util.List;

public interface IListSongService {

    List<SongResponse> getSongsByGenre(String genre);
    List<SongResponse> getSongsByArtist(String artistName);
    List<SongResponse> getSongsByAlbum(String albumName);

}
