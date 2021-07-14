package main.java.com.songplayer.services;

import main.java.com.songplayer.dto.PlayingSongResponse;
import main.java.com.songplayer.entities.PlayList;
import main.java.com.songplayer.entities.User;
import main.java.com.songplayer.exceptions.PlayListEmptyException;
import main.java.com.songplayer.exceptions.SongNotFoundException;

public interface IPlayService {

    PlayList getPlayListByName(String name);
    void select(PlayList playList);
    PlayingSongResponse play(User user) throws PlayListEmptyException;
    PlayingSongResponse playSongById(User user, String id) throws PlayListEmptyException, SongNotFoundException;
    PlayingSongResponse next(User user) throws PlayListEmptyException;
    PlayingSongResponse back(User user) throws PlayListEmptyException;

}
