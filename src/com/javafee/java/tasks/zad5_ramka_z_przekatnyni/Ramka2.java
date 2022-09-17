package com.javafee.java.tasks.zad5_ramka_z_przekatnyni;

public class Ramka2 {
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
                    if (j == 1 || j == n || i == j || (i + j) == (n + 1)) {
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
