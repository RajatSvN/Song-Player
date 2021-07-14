package main.java.com.songplayer.services;

import main.java.com.songplayer.dto.PlayingSongResponse;
import main.java.com.songplayer.entities.ActivePlayList;
import main.java.com.songplayer.entities.PlayList;
import main.java.com.songplayer.entities.Song;
import main.java.com.songplayer.entities.User;
import main.java.com.songplayer.exceptions.PlayListEmptyException;
import main.java.com.songplayer.exceptions.SongNotFoundException;
import main.java.com.songplayer.repositories.IPlayListRepository;
import main.java.com.songplayer.repositories.ISongRepository;

import javax.swing.plaf.multi.MultiSeparatorUI;

public class PlayService implements IPlayService{

    private IPlayListRepository iPlayListRepository;
    private ISongRepository iSongRepository;

    private ActivePlayList activePlayList;

    public PlayService(IPlayListRepository iPlayListRepository, ISongRepository iSongRepository){
        this.iPlayListRepository = iPlayListRepository;
        this.iSongRepository = iSongRepository;
    }


    @Override
    public PlayList getPlayListByName(String name) {
        return iPlayListRepository.getPlayListById(name);
    }

    @Override
    public void select(PlayList playList) {

        this.activePlayList = ActivePlayList.getInstance(playList);

    }

    @Override
    public PlayingSongResponse play(User user) throws PlayListEmptyException {

        if(this.activePlayList != null){
            String songId = this.activePlayList.play();
            Song s = iSongRepository.getSongById(songId);
            user.addSongToCache(songId);
            return new PlayingSongResponse(s);
        }

        return null;
    }

    @Override
    public PlayingSongResponse playSongById(User user, String id) throws PlayListEmptyException, SongNotFoundException {

        if(this.activePlayList != null){
            String songId = this.activePlayList.play(id);
            Song s = iSongRepository.getSongById(songId);
            user.addSongToCache(songId);
            return new PlayingSongResponse(s);
        }

        return null;
    }

    @Override
    public PlayingSongResponse next(User user) throws PlayListEmptyException {

        if(this.activePlayList != null){
            String songId = this.activePlayList.next();
            Song s = iSongRepository.getSongById(songId);
            user.addSongToCache(songId);
            return new PlayingSongResponse(s);
        }

        return null;
    }

    @Override
    public PlayingSongResponse back(User user) throws PlayListEmptyException {

        if(this.activePlayList != null){
            String songId = this.activePlayList.back();
            Song s = iSongRepository.getSongById(songId);
            user.addSongToCache(songId);
            return new PlayingSongResponse(s);
        }

        return null;
    }

}
