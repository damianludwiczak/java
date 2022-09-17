package com.javafee.java.tasks.zad3_trojkat2;

public class Trojkat2 {
    public static void main(String[] args) {
        int n = 5;
        char znak = '*';
        int m = n;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= m) {
                    System.out.print(znak);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            m--;
        }

    }
}
