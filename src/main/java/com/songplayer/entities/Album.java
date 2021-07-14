package main.java.com.songplayer.entities;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private String name;
    private Artist artist;
    private List<String> songs;


    public Album(String name, Artist artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getArtistName() {
        return artist.getName();
    }

    public void addSongs(List<String> songIds){
        songs.addAll(songIds);
    }

    public List<String> getSongIds() {
        return songs;
    }

}
