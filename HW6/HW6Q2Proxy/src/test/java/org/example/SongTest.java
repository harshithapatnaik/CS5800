package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SongTest {

    @Test
    public void testSongConstructorAndGetters() {
        // Arrange
        Integer expectedSongID = 1;
        String expectedTitle = "Title 1";
        String expectedArtist = "Artist 1";
        String expectedAlbum = "Album 1";
        int expectedDuration = 183;

        // Act
        Song song = new Song(expectedSongID, expectedTitle, expectedArtist, expectedAlbum, expectedDuration);

        // Assert
        assertEquals(expectedSongID, song.getSongID(), "Song ID should match");
        assertEquals(expectedTitle, song.getTitle(), "Title should match");
        assertEquals(expectedArtist, song.getArtist(), "Artist should match");
        assertEquals(expectedAlbum, song.getAlbum(), "Album should match");
        assertEquals(expectedDuration, song.getDuration(), "Duration should match");
    }

    @Test
    public void testSongWithNullID() {
        // Arrange
        Integer expectedSongID = null;
        String expectedTitle = "Title 2";
        String expectedArtist = "Artist 2";
        String expectedAlbum = "Album 2";
        int expectedDuration = 354;

        // Act
        Song song = new Song(expectedSongID, expectedTitle, expectedArtist, expectedAlbum, expectedDuration);

        // Assert
        assertNull(song.getSongID(), "Song ID should be null");
        assertEquals(expectedTitle, song.getTitle(), "Title should match");
        assertEquals(expectedArtist, song.getArtist(), "Artist should match");
        assertEquals(expectedAlbum, song.getAlbum(), "Album should match");
        assertEquals(expectedDuration, song.getDuration(), "Duration should match");
    }
}
