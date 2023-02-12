package com.javafee.java.lessons.lesson9;

public class SkyNews {
    private String name;

    public SkyNews(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void createNews(Broadcast broadcast) {
        broadcast.broadcast(new News("tittle", "desc", "BBC"));
    }
}
