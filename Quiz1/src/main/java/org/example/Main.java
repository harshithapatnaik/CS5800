package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Part 2: Shallow Copy
        List<String> chapters = new ArrayList<>();
        chapters.add("Chapter 1: Introduction");
        BookShallowCopy originalShallow = new BookShallowCopy("Shallow Book", "Author A", chapters);
        BookShallowCopy clonedShallow = (BookShallowCopy) originalShallow.clone();

        // Modify the chapters of the original book
        originalShallow.addChapter("Chapter 2: Shallow Copy Details");

        // Outputs of both books
        System.out.println("\nOriginal Shallow Copy Book: " + originalShallow);
        System.out.println("Cloned Shallow Copy Book: " + clonedShallow);

        // Part 3: Deep Copy
        List<String> deepChapters = new ArrayList<>();
        deepChapters.add("Chapter 1: Deep Introduction");
        BookDeepCopy originalDeep = new BookDeepCopy("Deep Book", "Author B", deepChapters);
        BookDeepCopy clonedDeep = (BookDeepCopy) originalDeep.clone();

        // Modify the chapters of the original book
        originalDeep.addChapter("Chapter 2: Deep Copy Details");

        // Outputs of both books
        System.out.println("\nOriginal Deep Copy Book: " + originalDeep);
        System.out.println("Cloned Deep Copy Book: " + clonedDeep);
    }
}