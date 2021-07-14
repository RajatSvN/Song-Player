package main.java.com.songplayer.services;

import main.java.com.songplayer.dto.SongResponse;
import main.java.com.songplayer.entities.Song;
import main.java.com.songplayer.repositories.IAlbumRepository;
import main.java.com.songplayer.repositories.IArtistRepository;
import main.java.com.songplayer.repositories.ISongRepository;

import java.util.ArrayList;
import java.util.List;

public class ListSongService implements IListSongService {

    private ISongRepository iSongRepository;
    private IArtistRepository iArtistRepository;
    private IAlbumRepository iAlbumRepository;

    public ListSongService(ISongRepository iSongRepository, IArtistRepository iArtistRepository, IAlbumRepository iAlbumRepository) {
        this.iSongRepository = iSongRepository;
        this.iArtistRepository = iArtistRepository;
        this.iAlbumRepository = iAlbumRepository;
    }

    @Override
    public List<SongResponse> getSongsByGenre(String genre) {
        return iSongRepository.listSongsByGenre(genre);
    }

    @Override
    public List<SongResponse> getSongsByArtist(String artistName) {

        List<String> songIds = iArtistRepository.getArtistByName(artistName).getSongIds();

        List<SongResponse> songsOfArtist = new ArrayList<>();
        for(String id : songIds){
            Song s = iSongRepository.getSongById(id);
            songsOfArtist.add(new SongResponse(s));
        }

        return songsOfArtist;

    }

    @Override
    public List<SongResponse> getSongsByAlbum(String albumName) {

        List<String> songIds = iAlbumRepository.getAlbumByName(albumName).getSongIds();

        List<SongResponse> songsOfAlbum = new ArrayList<>();
        for(String id : songIds){
            Song s = iSongRepository.getSongById(id);
            songsOfAlbum.add(new SongResponse(s));
        }

        return songsOfAlbum;

    }



}
