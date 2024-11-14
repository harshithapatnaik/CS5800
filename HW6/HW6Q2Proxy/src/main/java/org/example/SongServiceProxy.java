package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceProxy implements SongService {
    private final SongService songService;
    private final Map<Integer, Song> songCache;

    public SongServiceProxy(SongService songService) {
        this.songService = songService;
        this.songCache = new HashMap<>();
    }

    @Override
    public Song searchById(Integer songID) {
        if (songCache.containsKey(songID)) {
            System.out.println("Fetching song metadata from cache for songID: " + songID);
            return songCache.get(songID);
        } else {
            System.out.println("Fetching song metadata from server for songID: " + songID);
            Song song = songService.searchById(songID);
            songCache.put(songID, song);
            return song;
        }
    }

    @Override
    public List<Song> searchByTitle(String title) {
        return songService.searchByTitle(title);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        return songService.searchByAlbum(album);
    }
}