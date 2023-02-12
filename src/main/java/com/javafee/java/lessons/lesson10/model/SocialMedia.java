package com.javafee.java.lessons.lesson10.model;

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

    public void printListMesaages(int id) {
        String[] tab = new String[2];
        for (String message : listMesaages) {
            tab = message.split(",");
            if (Integer.parseInt(tab[1]) == id) {
                System.out.println(tab[0]);
            }
        }
    }

    public void sentMessage(String message) {
        listMesaages.add(message);
    }
}
