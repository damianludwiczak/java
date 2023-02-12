package com.javafee.java.lessons.lesson9;

public class BBC {
    private String name;

    public BBC(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void createNews(Broadcast broadcast) {
        broadcast.broadcast(new News("xD", "xD 2", "BBC"));
    }
}
