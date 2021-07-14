package main.java.com.songplayer.exceptions;

public class PlayListEmptyException extends Exception{

    @Override
    public String toString() {
        return "Playlist has no songs";
    }

}
