package main.java.com.songplayer.entities;

import java.util.List;

public class Song {

    private final String id;
    private String name;
    private String genre;
    private String albumName;
    private Artist albumArtist; // albumArtist is the song owner
    private List<Artist> songArtists;

    public Song(String id, String name, String genre, String albumName, Artist albumArtist, List<Artist> songArtists){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.albumName = albumName;
        this.albumArtist = albumArtist;
        this.songArtists = songArtists;
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

    public Artist getOwnerArtist() {
        return albumArtist;
    }

    public List<Artist> getSongArtists() {
        return songArtists;
    }
}
