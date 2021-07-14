package main.java.com.songplayer.services;

import main.java.com.songplayer.dto.SongResponse;
import main.java.com.songplayer.entities.Song;
import main.java.com.songplayer.entities.User;
import main.java.com.songplayer.repositories.ISongRepository;

import java.util.ArrayList;
import java.util.List;

public class UserSongHistoryService implements IUserSongHistoryService {


    private ISongRepository iSongRepository;
    private User user;

    public UserSongHistoryService(User user, ISongRepository iSongRepository){
        this.iSongRepository = iSongRepository;
        this.user = user;
    }

    @Override
    public List<SongResponse> getLastNSongsOfUser(int N) {


        List<String> songIds =  this.user.lastNSongs(N);
        List<SongResponse> lastNSongs = new ArrayList<>();

        for(String id: songIds){
            Song s = this.iSongRepository.getSongById(id);
            lastNSongs.add(new SongResponse(s));
        }

        return lastNSongs;


    }
}
