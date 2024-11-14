package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class MainTest {
    @Test
    void testShallowCopy() {
        List<String> chapters = new ArrayList<>();
        chapters.add("Chapter 1: Introduction");
        BookShallowCopy originalShallow = new BookShallowCopy("Shallow Book", "Author A", chapters);
        BookShallowCopy clonedShallow = (BookShallowCopy) originalShallow.clone();

        // Modify the chapters of the original book
        originalShallow.addChapter("Chapter 2: Shallow Copy Details");

        // Verify that the cloned book also has the new chapter (since it's a shallow copy)
        assertEquals(originalShallow.chapters, clonedShallow.chapters);
        assertEquals(2, clonedShallow.chapters.size());
        assertEquals("Chapter 2: Shallow Copy Details", clonedShallow.chapters.get(1));
    }
    @Test
    void testDeepCopy() {
        List<String> chapters = new ArrayList<>();
        chapters.add("Chapter 1: Deep Introduction");
        BookDeepCopy originalDeep = new BookDeepCopy("Deep Book", "Author B", chapters);
        BookDeepCopy clonedDeep = (BookDeepCopy) originalDeep.clone();

        // Modify the chapters of the original book
        originalDeep.addChapter("Chapter 2: Deep Copy Details");

        // Verify that the cloned book does not have the new chapter (since it's a deep copy)
        assertNotEquals(originalDeep.chapters, clonedDeep.chapters);
        assertEquals(1, clonedDeep.chapters.size());
        assertEquals("Chapter 1: Deep Introduction", clonedDeep.chapters.get(0));
        assertEquals(2, originalDeep.chapters.size());
    }

    @Test
    void testCloneAttributes() {
        List<String> chapters = new ArrayList<>();
        chapters.add("Chapter 1: Introduction");
        BookShallowCopy originalShallow = new BookShallowCopy("Shallow Book", "Author A", chapters);
        BookShallowCopy clonedShallow = (BookShallowCopy) originalShallow.clone();

        // Verify that title and author are copied correctly
        assertEquals(originalShallow.title, clonedShallow.title);
        assertEquals(originalShallow.author, clonedShallow.author);
    }
}