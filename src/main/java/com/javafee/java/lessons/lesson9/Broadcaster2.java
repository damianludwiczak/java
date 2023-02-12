package com.javafee.java.lessons.lesson9;

public class Broadcaster2 implements Broadcast {
    @Override
    public void broadcast(News news) {
        System.out.println(news);
    }
}
