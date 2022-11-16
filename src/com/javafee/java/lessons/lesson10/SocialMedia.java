package com.javafee.java.lessons.lesson10;

import java.util.ArrayList;
import java.util.List;

public class SocialMedia {
    private String name;
    private List<String> listMesaages = new ArrayList<>();

    public SocialMedia(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printListMesaages() {
        listMesaages.forEach(System.out::println);
    }

    void sentMessage(String message) {
        listMesaages.add(message);
    }
}
