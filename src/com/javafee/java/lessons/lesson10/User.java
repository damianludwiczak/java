package com.javafee.java.lessons.lesson10;

public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    void sentMessage(SentMessage sentMessage, String message){
        sentMessage.sentMessage(message);
    }

    @Override
    public String toString() {
        return id + "," + name;
    }
}
