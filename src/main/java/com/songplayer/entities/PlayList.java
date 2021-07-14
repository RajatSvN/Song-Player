package main.java.com.songplayer.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PlayList  {

    private String id ; // assigned by system, unique
    private String name;
    private List<String> songs;


    public PlayList( String id, String name) {
        this.id = id;
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void addSongs(List<String> songIds){

        Set<String> currentSongIds = new HashSet<>(songs);

        for(String songId : songIds){
            if(!currentSongIds.contains(songId)){
                songs.add(songId);
            }
        }

    }

    public void removeSongs(Set<String> songIds){

        this.songs.removeIf(songIds::contains);

    }

}
