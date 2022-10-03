package com.javafee.java.tasks.zad4_ramka;

public class Ramka {
    public static void main(String[] args) {

        int n = 5;
        char znak = '*';

        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == n) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(znak);
                }
            } else {
                for (int j = 1; j <= n; j++) {
                    if (j == 1 || j == n) {
                        System.out.print(znak);
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }

    }
}
