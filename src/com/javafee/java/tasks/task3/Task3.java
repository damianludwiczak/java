package com.javafee.java.tasks.task3;

public class Task3 {
    public static void main(String[] args) {
        for (int n = 4, m = n / 2, i = 1, x = 10; n > 0; n--) {
            if (n == m) {
                i /= x;
                System.out.print(i + " ");
                continue;
            } else if (n > m) {
                i *= x;
                System.out.print(i + " ");
                i *= x;
                System.out.print(i + " ");
            } else {
                i /= x;
                System.out.print(i + " ");
                i /= x;
                System.out.print(i + " ");
            }
        }
    }
}
