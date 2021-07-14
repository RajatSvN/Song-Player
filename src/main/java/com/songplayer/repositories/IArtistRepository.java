package main.java.com.songplayer.repositories;

import main.java.com.songplayer.entities.Artist;

import java.util.List;

public interface IArtistRepository {

    void addArtist(Artist artist);
    Artist getArtistByName(String name);
    void addSongs(Artist artist, List<String> songIds);
    List<String> getArtistsSongs(Artist artist);

}
