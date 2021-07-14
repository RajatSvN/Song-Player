package main.java.com.songplayer.repositories;

import main.java.com.songplayer.entities.Album;

import java.util.List;

public interface IAlbumRepository {

    void createAlbum(Album album);
    Album getAlbumByName(String albumName);
    void addSongs(Album album, List<String> songIds);
    List<String> getAlbumSongs(Album album);

}
