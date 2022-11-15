package com.javafee.java.lessons.lesson9;

public class News {
    private String tittle;
    private String description;
    private String author;

    public News(String tittle, String description, String author) {
        this.tittle = tittle;
        this.description = description;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "News{" +
                "tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
