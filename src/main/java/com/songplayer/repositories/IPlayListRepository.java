package main.java.com.songplayer.repositories;

import main.java.com.songplayer.entities.PlayList;
import main.java.com.songplayer.exceptions.PlayListNotFoundException;
import main.java.com.songplayer.exceptions.SongNotFoundException;

import java.util.List;
import java.util.Set;

public interface IPlayListRepository {
    void savePlayList(PlayList p);
    PlayList getPlayListById(String id);
    void deletePlayList(String id) throws PlayListNotFoundException;
    void addSongs(PlayList playList, List<String> songIds) throws SongNotFoundException;
    void removeSongs(PlayList playList, Set<String> songIds) throws SongNotFoundException;
}
