package main.java.com.songplayer.services;

import main.java.com.songplayer.entities.PlayList;
import main.java.com.songplayer.exceptions.PlayListNotFoundException;
import main.java.com.songplayer.repositories.IPlayListRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayListService implements IPlayListService {

    private IPlayListRepository iPlayListRepository;

    public PlayListService(IPlayListRepository iPlayListRepository) {
        this.iPlayListRepository = iPlayListRepository;
    }

    @Override
    public void createPlayList(String id, String name) {

        PlayList p = new PlayList(id, name);
        iPlayListRepository.savePlayList(p);

    }

    @Override
    public void deletePlayList(String id) throws PlayListNotFoundException {

        iPlayListRepository.deletePlayList(id);

    }

    @Override
    public void addSongs(String id, List<String> songIds) {

        iPlayListRepository.getPlayListById(id).addSongs(songIds);

    }

    @Override
    public void deleteSongs(String id, List<String> songIds) {
        Set<String> songIdsSet = new HashSet<>(songIds);
        iPlayListRepository.getPlayListById(id).removeSongs(songIdsSet);
    }
}
