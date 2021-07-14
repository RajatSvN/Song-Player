package main.java.com.songplayer.repositories;

import main.java.com.songplayer.dto.SongResponse;
import main.java.com.songplayer.entities.Song;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongRepository implements ISongRepository{

    private Map<String, Song> songMap;
    private Map<String, List<SongResponse>> songByGenreMap;


    public SongRepository(){
        songMap = new HashMap<>();
        songByGenreMap = new HashMap<>();
    }

    @Override
    public void addSong(Song s) {

        songMap.put(s.getId(), s);

        songByGenreMap.putIfAbsent(s.getGenre(), new ArrayList<>());

        SongResponse sr = new SongResponse(s);

        songByGenreMap.get(s.getGenre()).add(sr);

    }

    @Override
    public List<SongResponse> listSongsByGenre(String genre) {

        if(songByGenreMap.containsKey(genre)){
            return songByGenreMap.get(genre);
        }

        return null;
    }

    @Override
    public Song getSongById(String songId) {

        if(songMap.containsKey(songId)){
            return songMap.get(songId);
        }

        return null;
    }

}
