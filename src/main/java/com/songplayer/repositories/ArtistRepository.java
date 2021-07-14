package main.java.com.songplayer.repositories;

import main.java.com.songplayer.entities.Artist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArtistRepository implements IArtistRepository {

    private Map<String, Artist> artistMap;

    public ArtistRepository(){
        artistMap = new HashMap<>();
    }

    @Override
    public void addArtist(Artist artist) {
        artistMap.putIfAbsent(artist.getName(), artist);
    }

    @Override
    public Artist getArtistByName(String name) {

        if(artistMap.containsKey(name)){
            return artistMap.get(name);
        }

        return null;
    }

    @Override
    public void addSongs(Artist artist, List<String> songIds) {
        artist.addSongs(songIds);
    }

    @Override
    public List<String> getArtistsSongs(Artist artist) {

        return artist.getSongIds();

    }

}
