package main.java.com.songplayer.repositories;

import main.java.com.songplayer.entities.PlayList;
import main.java.com.songplayer.exceptions.PlayListNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PlayListRepository implements IPlayListRepository{

    private Map<String, PlayList> playListMap;

    public PlayListRepository(){
        this.playListMap = new HashMap<>();
    }

    @Override
    public void savePlayList(PlayList p) {
        playListMap.put(p.getId(), p);
    }

    @Override
    public PlayList getPlayListById(String id) {

        if(playListMap.containsKey(id)){
            return playListMap.get(id);
        }

        return null;
    }

    @Override
    public void deletePlayList(String id)  throws PlayListNotFoundException{

        if(!playListMap.containsKey(id)){
            throw new PlayListNotFoundException();
        }

        playListMap.remove(id);

    }

    @Override
    public void addSongs(PlayList playList, List<String> songIds) {

        playList.addSongs(songIds);

    }

    @Override
    public void removeSongs(PlayList playList, Set<String> songIds) {

        playList.removeSongs(songIds);

    }

}
