package org.example;

import java.util.*;

public class Book implements Cloneable {
    protected String title;
    protected String author;
    protected List<String> chapters;

    public Book(String title, String author, List<String> chapters) {
        this.title = title;
        this.author = author;
        this.chapters = chapters;
    }

    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "\ntitle= " + title +
                ", author= " + author +
                ", chapters= " + chapters ;
    }
}

