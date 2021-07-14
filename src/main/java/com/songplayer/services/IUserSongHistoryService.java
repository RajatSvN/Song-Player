package main.java.com.songplayer.services;

import main.java.com.songplayer.dto.SongResponse;

import java.util.List;

public interface IUserSongHistoryService {

    // there is only one User so no user Binding as Such
    List<SongResponse> getLastNSongsOfUser(int N);

}
