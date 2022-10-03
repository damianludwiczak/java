package com.javafee.java.tasks.zad1_kwadrat;

public class Kwadrat {
    public static void main(String[] args) {

        int n = 5;
        char znak = '*';

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(znak);
            }
            System.out.println();
        }


    }
}
