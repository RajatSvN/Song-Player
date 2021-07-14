package main.java.com.songplayer.dto;

import main.java.com.songplayer.entities.Artist;
import main.java.com.songplayer.entities.Song;

import java.util.List;

public class SongResponse {

    private final String id ;
    private final String name;
    private final String genre;
    private final String albumName;
    private final String albumOwner;
    private final String artists;

    public SongResponse(Song s){

        this.id = s.getId();
        this.name = s.getName();
        this.genre = s.getGenre();
        this.albumName = s.getAlbumName();
        this.albumOwner = s.getOwnerArtist().getName();

        String artistCommaSeparated = "";

        List<Artist> songAssociatedArtists = s.getSongArtists();

        for(int i=0 ; i<songAssociatedArtists.size()-1 ; i++){
            artistCommaSeparated += songAssociatedArtists.get(i).getName()+", ";
        }

        if(songAssociatedArtists.size()>=1)
        artistCommaSeparated += songAssociatedArtists.get(songAssociatedArtists.size()-1).getName();

        this.artists = artistCommaSeparated;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getAlbumOwner() {
        return albumOwner;
    }

    public String getArtists() {
        return artists;
    }

    @Override
    public String toString() {
        return this.getId() + "\n"
                + this.getName() + "\n"
                + this.getGenre() + "\n"
                + this.getAlbumName() + "\n"
                + this.getAlbumOwner() + "\n"
                + this.getArtists() ;
    }
}
