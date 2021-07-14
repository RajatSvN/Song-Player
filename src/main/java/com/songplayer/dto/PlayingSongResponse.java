package main.java.com.songplayer.dto;

import main.java.com.songplayer.entities.Artist;
import main.java.com.songplayer.entities.Song;

import java.util.List;

public class PlayingSongResponse {

    private final String name;
    private final String albumName;
    private final String artists;

    public PlayingSongResponse(Song s){

        this.name = s.getName();

        this.albumName = s.getAlbumName();


        String artistCommaSeparated = "";

        List<Artist> songAssociatedArtists = s.getSongArtists();

        for(int i=0 ; i<songAssociatedArtists.size()-1 ; i++){
            artistCommaSeparated += songAssociatedArtists.get(i).getName()+", ";
        }

        if(songAssociatedArtists.size()>=1)
            artistCommaSeparated += songAssociatedArtists.get(songAssociatedArtists.size()-1).getName();

        this.artists = artistCommaSeparated;

    }

    public String getName() {
        return name;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getArtists() {
        return artists;
    }

    @Override
    public String toString() {
        return this.getName() + "\n" + this.getAlbumName() + "\n" + this.getArtists();
    }
}
