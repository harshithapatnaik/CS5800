package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.*;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DocumentTest {
    private static final String TEST_FILE = "test_document.txt";
    private Document document;

    @Before
    public void setUp() {
        document = new Document();
        document.addCharacter('A', new CharacterProperties("Arial", "Black", 12));
        document.addCharacter('B', new CharacterProperties("Times New Roman", "Red", 14));
    }

    @Test
    public void testAddCharacter() {
        List<Character> characters = document.getCharacters();
        assertEquals(2, characters.size());
        assertEquals('A', characters.get(0).getCharacter());
        assertEquals("Arial", characters.get(0).getProperties().getFont());
        assertEquals(12, characters.get(0).getProperties().getSize());
        assertEquals('B', characters.get(1).getCharacter());
        assertEquals("Times New Roman", characters.get(1).getProperties().getFont());
        assertEquals(14, characters.get(1).getProperties().getSize());
    }

    @Test
    public void testSaveAndLoad() throws IOException {
        document.save(TEST_FILE);
        Document loadedDoc = Document.load(TEST_FILE);
        List<Character> characters = loadedDoc.getCharacters();
        assertEquals(2, characters.size());
        assertEquals('A', characters.get(0).getCharacter());
        assertEquals("Arial", characters.get(0).getProperties().getFont());
        assertEquals(12, characters.get(0).getProperties().getSize());
        assertEquals('B', characters.get(1).getCharacter());
        assertEquals("Times New Roman", characters.get(1).getProperties().getFont());
        assertEquals(14, characters.get(1).getProperties().getSize());
    }

    @After
    public void tearDown() {
        File file = new File(TEST_FILE);
        if (file.exists()) {
            assertTrue(file.delete());
        }
    }
}