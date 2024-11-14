package org.example;

import java.util.ArrayList;
import java.util.List;

// Real service with delay
public class RealSongService implements SongService {
    private final List<Song> songDatabase = new ArrayList<>();

    public RealSongService() {
        songDatabase.add(new Song(1, "Song A", "Artist 1", "Album X", 180));
        songDatabase.add(new Song(2, "Song B", "Artist 2", "Album Y", 200));
        songDatabase.add(new Song(3, "Song C", "Artist 1", "Album Z", 210));
        songDatabase.add(new Song(4, "Song D", "Artist 3", "Album X", 230));
        songDatabase.add(new Song(5, "Song E", "Artist 4", "Album Y", 190));
    }

    private void simulateNetworkDelay() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Song searchById(Integer songID) {
        simulateNetworkDelay();
        return songDatabase.stream().filter(song -> song.getSongID().equals(songID)).findFirst().orElse(null);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        simulateNetworkDelay();
        List<Song> result = new ArrayList<>();
        for (Song song : songDatabase) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                result.add(song);
            }
        }
        return result;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        simulateNetworkDelay();
        List<Song> result = new ArrayList<>();
        for (Song song : songDatabase) {
            if (song.getAlbum().equalsIgnoreCase(album)) {
                result.add(song);
            }
        }
        return result;
    }
}
