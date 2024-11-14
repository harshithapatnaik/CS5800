package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class RealSongServiceTest {

    @Test
    public void testSearchById() {
        // Arrange
        RealSongService songService = new RealSongService();
        Integer songID = 1;

        // Act
        Song song = songService.searchById(songID);

        // Assert
        assertNotNull(song, "Song should not be null");
        assertEquals(songID, song.getSongID(), "Song ID should match");
    }

    @Test
    public void testSearchByTitle() {
        // Arrange
        RealSongService songService = new RealSongService();
        String title = "Song A";

        // Act
        List<Song> songs = songService.searchByTitle(title);

        // Assert
        assertFalse(songs.isEmpty(), "Songs list should not be empty");
        assertEquals(1, songs.size(), "There should be one song with the given title");
        assertEquals(title, songs.get(0).getTitle(), "Title should match");
    }

    @Test
    public void testSearchByAlbum() {
        // Arrange
        RealSongService songService = new RealSongService();
        String album = "Album X";

        // Act
        List<Song> songs = songService.searchByAlbum(album);

        // Assert
        assertFalse(songs.isEmpty(), "Songs list should not be empty");
        assertEquals(2, songs.size(), "There should be two songs with the given album");
        for (Song song : songs) {
            assertEquals(album, song.getAlbum(), "Album should match");
        }
    }
}
