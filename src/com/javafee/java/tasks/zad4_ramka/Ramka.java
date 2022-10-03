package com.javafee.java.tasks.zad4_ramka;
public class Ramka {
    public static void main(String[] args) {
        char znak = '*';
        for (int i = 1, n = 5; i <= n; i++) {
            if (i == 1 || i == n) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(znak);
                }
            } else {
                for (int j = 1; j <= n; j++) { System.out.print(j == 1 || j == n ? znak: " ");}
            }
            System.out.println();
        }
    }
}
