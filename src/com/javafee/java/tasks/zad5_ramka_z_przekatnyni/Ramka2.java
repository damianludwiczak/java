package com.javafee.java.tasks.zad5_ramka_z_przekatnyni;
public class Ramka2 {
    public static void main(String[] args) {
        char znak = '*';
        for (int i = 1, n = 5; i <= n; i++) {
            if (i == 1 || i == n) {
                for (int j = 1; j <= n; j++) {System.out.print(znak);}
            } else {
                for (int j = 1; j <= n; j++) {System.out.print(j == 1 || j == n || i == j || (i + j) == (n + 1) ? znak : " ");}
            }
            System.out.println();
        }
    }
}
