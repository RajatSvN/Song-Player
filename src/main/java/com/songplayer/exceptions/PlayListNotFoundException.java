package main.java.com.songplayer.exceptions;

public class PlayListNotFoundException extends Exception{

    @Override
    public String toString() {
        return "Playlist was not found!";
    }
}
