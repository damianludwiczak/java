package com.javafee.java.lessons.lesson9;

public class CNN {
    private String name;

    public CNN (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void createNews(Broadcast broadcast) {
        broadcast.broadcast(new News("tittle", "desc", "CNN"));
    }
}
