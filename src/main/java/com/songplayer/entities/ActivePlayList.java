package main.java.com.songplayer.entities;

import main.java.com.songplayer.exceptions.PlayListEmptyException;
import main.java.com.songplayer.exceptions.SongNotFoundException;

import java.util.List;


public class ActivePlayList {

    private static ActivePlayList activePlayList;
    private PlayList playList;

    private int CURRENT_PLAYING = 0;

    private ActivePlayList(PlayList playList){
        this.playList = playList;
    }

    // Singleton so as only one active playList at a time
    public static ActivePlayList getInstance(PlayList playList){

        if(activePlayList == null){
            activePlayList =  new ActivePlayList(playList);
            return activePlayList;
        }

        return activePlayList;

    }

    public String play() throws PlayListEmptyException {

        if(this.playList.getSongs().size() == 0){
            throw new PlayListEmptyException();
        }

        return this.playList.getSongs().get(0);

    }

    public String play(String id) throws PlayListEmptyException, SongNotFoundException {

        if(this.playList.getSongs().size() == 0){
            throw new PlayListEmptyException();
        }

        List<String> songList = this.playList.getSongs();

        for(int i=0 ; i<songList.size() ; i++){
            if(id.equals(songList.get(i))){
                CURRENT_PLAYING = i ;
                return songList.get(i);
            }
        }

        throw new SongNotFoundException();

    }

    public String next() throws PlayListEmptyException{

        if(this.playList.getSongs().size() == 0){
            throw new PlayListEmptyException();
        }

        List<String> songList = this.playList.getSongs();

        if(CURRENT_PLAYING+1 >= songList.size()){
            CURRENT_PLAYING = 0;
            return songList.get(0);
        }


            CURRENT_PLAYING++;
            return songList.get(CURRENT_PLAYING);

    }

    public String back() throws PlayListEmptyException{

        if(this.playList.getSongs().size() == 0){
            throw new PlayListEmptyException();
        }

        List<String> songList = this.playList.getSongs();

        if(CURRENT_PLAYING-1 < 0){
            CURRENT_PLAYING = songList.size()-1;
            return songList.get(CURRENT_PLAYING);
        }


        CURRENT_PLAYING--;
        return songList.get(CURRENT_PLAYING);

    }

}
