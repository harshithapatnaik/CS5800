package org.example;

import java.util.*;

// Shallow Copy Class
public class BookShallowCopy extends Book {
    public BookShallowCopy(String title, String author, List<String> chapters) {
        super(title, author, chapters);
    }

    @Override
    public Book clone() {
        // Shallow copy: The chapters list reference is copied, not the content
        return new BookShallowCopy(this.title, this.author, this.chapters);
    }

    public void addChapter(String chapter) {
        this.chapters.add(chapter);
    }
}