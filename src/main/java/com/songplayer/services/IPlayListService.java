package main.java.com.songplayer.services;


import main.java.com.songplayer.exceptions.PlayListNotFoundException;

import java.util.List;

// add USer here

public interface IPlayListService {

    void createPlayList(String id, String name);

    void deletePlayList(String id) throws PlayListNotFoundException;

    void addSongs(String id, List<String> songIds);

    void deleteSongs(String id, List<String> songIds);

}
