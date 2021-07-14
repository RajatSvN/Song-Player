package main.java.com.songplayer.exceptions;

public class SongNotFoundException extends Exception {
    @Override
    public String toString() {
        return "Song was not Found";
    }
}
