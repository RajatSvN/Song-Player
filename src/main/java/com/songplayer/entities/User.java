package main.java.com.songplayer.entities;

import main.java.com.songplayer.exceptions.PlayListNotFoundException;

import java.util.*;

public class User {

    // No Id because design is for Single User, Using Singleton to try to achieve that
    private static User user;
    private String name;
    private List<PlayList> playLists = new ArrayList<>();
    private List<String> SONG_HISTORY_CACHE = new ArrayList<>();

    private User(String name){

        this.name = name;
        this.playLists = new ArrayList<>();
        this.SONG_HISTORY_CACHE = new ArrayList<>();

    }

    public static User getInstance(String name){

        if(user == null){
            user = new User(name);
            return user;
        }

        return user;

    }

    public String getName() {
        return name;
    }

    public void addPlayList(PlayList p){
        playLists.add(p);
    }

    public List<PlayList> getPlayLists() {
        return playLists;
    }

    public PlayList getPlayListById(String id) throws PlayListNotFoundException{

        for(PlayList p : this.playLists){
            if(p.getId().equals(id)){
                return p;
            }
        }

        throw new PlayListNotFoundException();

    }

    public void addSongToCache(String songId){

        // maintain a cache of last 100 played songs
        int CACHE_SIZE = 100;

        if(SONG_HISTORY_CACHE.size() == CACHE_SIZE){
            SONG_HISTORY_CACHE.remove(CACHE_SIZE-1);
        }

        SONG_HISTORY_CACHE.add(0,songId);

    }

    public List<String> lastNSongs(int N){

        N = Math.min(N,100);

        List<String> lastNSongIds = new ArrayList<>();

        for(int i=1 ; i<=N ; i++){
            lastNSongIds.add(SONG_HISTORY_CACHE.get(i-1));
        }

        return lastNSongIds;

    }

}
