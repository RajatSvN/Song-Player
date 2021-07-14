package main.java.com.songplayer.entities;

import java.util.ArrayList;
import java.util.List;

public class Artist {

    private String name ;
    private List<String> songIds;

    public Artist(String name){
        this.name = name;
        this.songIds = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSongs(List<String> songIds){
        this.songIds.addAll(songIds);
    }

    public List<String> getSongIds(){
        return songIds;
    }

}
