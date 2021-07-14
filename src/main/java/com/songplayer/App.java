package main.java.com.songplayer;

import main.java.com.songplayer.dto.SongResponse;
import main.java.com.songplayer.entities.*;
import main.java.com.songplayer.repositories.*;
import main.java.com.songplayer.services.*;

import java.util.*;

public class App {

    public static void main(String[] args) {

        /* As asked by the Problem Statement Please note that this is a designed keeping in view that only a
        * single user is using it. Although I have still implemented the User class and one can extend the functionality
        * if they like. It will involve Binding User and Playlist simply which I have omitted for simplicity*/

        List<Artist> artists = new ArrayList<>();

        Artist edSheeran = new Artist("Ed Sheeran");
        Artist charliePuth = new Artist("Charlie Puth");
        Artist shawnMendes = new Artist("Shawn Mendes");
        Artist camilaCabelo = new Artist("Camila Cabelo");
        Artist cardiB = new Artist("Cardi B");
        Artist khalid = new Artist("Khalid");
        Artist kehlani = new Artist("Kehlani");
        List<String> songIds = new ArrayList<>();

        artists.add(edSheeran);
        Song song1 = new Song("1",
                "Galway Girl",
                "Pop",
                "Deluxe",
                edSheeran,
                artists);


        artists = new ArrayList<>();
        artists.add(edSheeran);
        artists.add(camilaCabelo);
        artists.add(cardiB);
        Song song2 = new Song("2",
                "South of the Border",
                "Pop",
                "Collabortions Project",
                edSheeran,
                artists);

        artists = new ArrayList<>();
        artists.add(edSheeran);
        artists.add(khalid);
        Song song3 = new Song("3",
                "Beautiful People",
                "Pop",
                "Collabortions Project",
                edSheeran,
                artists);

        Album album1 = new Album("Collaborations Project", edSheeran);
         songIds = new ArrayList<>();
        songIds.add("2");
        songIds.add("3");
        album1.addSongs(songIds);

        Album album2 = new Album("Deluxe", edSheeran);
        songIds = new ArrayList<>();
        songIds.add("1");
        album2.addSongs(songIds);

        artists = new ArrayList<>();
        artists.add(charliePuth);
        Song song4 = new Song("4",
                "The Way I Am",
                "Soul Pop",
                "Voicenotes",
                charliePuth,
                artists);

        Song song5 = new Song("5",
                "Attention",
                "Soul Pop",
                "Voicenotes",
                charliePuth,
                artists);

        artists.add(kehlani);
        Song song6 = new Song("6",
                "Done For Me",
                "Soul Pop",
                "Voicenotes",
                charliePuth,
                artists);

        Album album3 = new Album("Voicenotes", shawnMendes);
        songIds = new ArrayList<>();
        songIds.add("4");
        songIds.add("5");
        songIds.add("6");
        album3.addSongs(songIds);

        artists = new ArrayList<>();
        artists.add(shawnMendes);
        Song song7 = new Song("7",
                "Mercy",
                "Pop",
                "Illuminate",
                shawnMendes,
                artists);

        Song song8 = new Song("8",
                "Treat You Better",
                "Pop",
                "Illuminate",
                shawnMendes,
                artists);

        Album album4 = new Album("Illuminate", shawnMendes);
        songIds = new ArrayList<>();
        songIds.add("7");
        songIds.add("8");
        album4.addSongs(songIds);

        IAlbumRepository iAlbumRepository;
        IArtistRepository iArtistRepository;
        ISongRepository iSongRepository;
        IPlayListRepository iPlayListRepository;

        iSongRepository = new SongRepository();
        iAlbumRepository = new AlbumRepository();
        iArtistRepository = new ArtistRepository();
        iPlayListRepository = new PlayListRepository();

        iSongRepository.addSong(song1);
        iSongRepository.addSong(song2);
        iSongRepository.addSong(song3);
        iSongRepository.addSong(song4);
        iSongRepository.addSong(song5);
        iSongRepository.addSong(song6);
        iSongRepository.addSong(song7);
        iSongRepository.addSong(song8);

        iAlbumRepository.createAlbum(album1);
        iAlbumRepository.createAlbum(album2);
        iAlbumRepository.createAlbum(album3);
        iAlbumRepository.createAlbum(album4);


        iArtistRepository.addArtist(edSheeran);
        iArtistRepository.addArtist(charliePuth);
        iArtistRepository.addArtist(camilaCabelo);
        iArtistRepository.addArtist(cardiB);
        iArtistRepository.addArtist(kehlani);
        iArtistRepository.addArtist(khalid);
        iArtistRepository.addArtist(shawnMendes);

        iArtistRepository.getArtistByName("Ed Sheeran").addSongs(Arrays.asList("1","2","3"));
        iArtistRepository.getArtistByName("Charlie Puth").addSongs(Arrays.asList("4","5","6"));
        iArtistRepository.getArtistByName("Camila Cabelo").addSongs(Collections.singletonList("2"));
        iArtistRepository.getArtistByName("Cardi B").addSongs(Collections.singletonList("2"));
        iArtistRepository.getArtistByName("Kehlani").addSongs(Collections.singletonList("6"));
        iArtistRepository.getArtistByName("Khalid").addSongs(Collections.singletonList("3"));
        iArtistRepository.getArtistByName("Shawn Mendes").addSongs(Arrays.asList("7","8"));




        try{

            // Create a User, Note that there is only a Single User

            User user = User.getInstance("Rajat");

            IPlayListService playListService = new PlayListService(iPlayListRepository);

            // create 3 playlists
            // playlist 1 -> song 1, 3, 5
            // playlist 2 -> song 2, 4 , 8
            // playlist 3 -> song 6, 7

            playListService.createPlayList("1", "Playlist 1");
            playListService.addSongs("1", Arrays.asList("1","3","5"));

            playListService.createPlayList("2", "Playlist 2");
            playListService.addSongs("2", Arrays.asList("2","4","8"));

            playListService.createPlayList("3", "Playlist 3");
            playListService.addSongs("3", Arrays.asList("6","7"));

            // add playLists for User

            user.addPlayList(iPlayListRepository.getPlayListById("1"));
            user.addPlayList(iPlayListRepository.getPlayListById("2"));
            user.addPlayList(iPlayListRepository.getPlayListById("3"));


            IListSongService listSongService = new ListSongService(iSongRepository, iArtistRepository, iAlbumRepository);

            // list Song by Genre Service
            System.out.println(listSongService.getSongsByGenre("Soul Pop").toString());

            // list song by Artist Name Service
            System.out.println(listSongService.getSongsByArtist("Ed Sheeran").toString());

            // list song by Album Name Service
            System.out.println(listSongService.getSongsByAlbum("Voicenotes").toString());


            IPlayService playService = new PlayService(iPlayListRepository, iSongRepository);

            PlayList playList = playService.getPlayListByName("1");

            playService.select(playList);

            playService.play(user);
            System.out.println("Now Playing..");
            System.out.println();
            System.out.println(playService.next(user).toString());
            System.out.println();

            System.out.println("Now Playing..");
            System.out.println();
            System.out.println(playService.next(user).toString());
            System.out.println();

            //back
            System.out.println("Now Playing..");
            System.out.println();
            System.out.println(playService.back(user).toString());
            System.out.println();

            System.out.println("Now Playing..");
            System.out.println();
            System.out.println(playService.next(user).toString());
            System.out.println();

            System.out.println("Now Playing..");
            System.out.println();
            System.out.println(playService.next(user).toString());
            System.out.println();

            System.out.println("Now Playing..");
            System.out.println();
            System.out.println(playService.next(user).toString());
            System.out.println();

            IUserSongHistoryService iUserSongHistoryService = new UserSongHistoryService(user, iSongRepository);

            List<SongResponse> lastNSongs = iUserSongHistoryService.getLastNSongsOfUser(2);

            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println();

            System.out.println("Now listing Last N=2 songs played");
            System.out.println();

            for(SongResponse sr : lastNSongs){
                System.out.println(sr.toString());
                System.out.println("--------------------------------------------------------------------------------");
            }


        }catch (Exception e){
            System.out.println(e.toString());
        }

    }

}
