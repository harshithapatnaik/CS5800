package org.example;

import java.util.*;

// Deep Copy Class
public class BookDeepCopy extends Book {
    public BookDeepCopy(String title, String author, List<String> chapters) {
        super(title, author, new ArrayList<>(chapters));
    }

    @Override
    public Book clone() {
        // Deep copy: New list is created and each chapter is copied individually
        return new BookDeepCopy(this.title, this.author, new ArrayList<>(this.chapters));
    }

    public void addChapter(String chapter) {
        this.chapters.add(chapter);
    }
}