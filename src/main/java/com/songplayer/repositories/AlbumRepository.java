package main.java.com.songplayer.repositories;

import main.java.com.songplayer.entities.Album;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlbumRepository implements IAlbumRepository{

    private Map<String, Album> albumMap ;

    public AlbumRepository(){
        this.albumMap = new HashMap<>();
    }

    @Override
    public void createAlbum(Album album) {
        albumMap.putIfAbsent(album.getName(), album);
    }

    @Override
    public Album getAlbumByName(String albumName) {

        if(albumMap.containsKey(albumName)){
            return albumMap.get(albumName);
        }

        return null;

    }

    @Override
    public void addSongs(Album album, List<String> songIds) {
            album.addSongs(songIds);
    }

    @Override
    public List<String> getAlbumSongs(Album album) {

        return album.getSongIds();

    }

}
