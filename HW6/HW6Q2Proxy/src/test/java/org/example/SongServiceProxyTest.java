package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SongServiceProxyTest {

    @Test
    public void testSearchByIdCached() {
        // Arrange
        RealSongService realSongService = new RealSongService();
        SongServiceProxy proxy = new SongServiceProxy(realSongService);
        Song expectedSong = new Song(1, "Song A", "Artist 1", "Album X", 180);

        // Act
        Song firstCall = proxy.searchById(1); // Should call the real service
        Song secondCall = proxy.searchById(1); // Should use cache

        // Assert
        assertEquals(expectedSong.getSongID(), firstCall.getSongID(), "First call should return the expected song");
        assertEquals(expectedSong.getSongID(), secondCall.getSongID(), "Second call should return the cached song");
    }

    @Test
    public void testSearchByIdNotCached() {
        // Arrange
        RealSongService realSongService = new RealSongService();
        SongServiceProxy proxy = new SongServiceProxy(realSongService);
        Integer songID = 2;

        // Act
        Song song = proxy.searchById(songID);

        // Assert
        assertNotNull(song, "Song should not be null");
        assertEquals(songID, song.getSongID(), "Call should return the expected song");
    }

    @Test
    public void testSearchByTitle() {
        // Arrange
        RealSongService realSongService = new RealSongService();
        SongServiceProxy proxy = new SongServiceProxy(realSongService);
        String title = "Song A";

        // Act
        List<Song> songs = proxy.searchByTitle(title);

        // Assert
        assertFalse(songs.isEmpty(), "Songs list should not be empty");
        assertEquals(1, songs.size(), "There should be one song with the given title");
        assertEquals(title, songs.get(0).getTitle(), "Title should match");
    }

    @Test
    public void testSearchByAlbum() {
        // Arrange
        RealSongService realSongService = new RealSongService();
        SongServiceProxy proxy = new SongServiceProxy(realSongService);
        String album = "Album X";

        // Act
        List<Song> songs = proxy.searchByAlbum(album);

        // Assert
        assertFalse(songs.isEmpty(), "Songs list should not be empty");
        assertEquals(2, songs.size(), "There should be two songs with the given album");
        for (Song song : songs) {
            assertEquals(album, song.getAlbum(), "Album should match");
        }
    }
}
