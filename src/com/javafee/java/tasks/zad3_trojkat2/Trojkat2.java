package com.javafee.java.tasks.zad3_trojkat2;
public class Trojkat2 {
    public static void main(String[] args) {
        char znak = '*';
        for (int i = 1, n = 5, m = n; i <= n; i++, m--) {
            for (int j = 1; j <= n; j++) { System.out.print(j >= m ? znak: " ");}
            System.out.println();
        }
    }
}
