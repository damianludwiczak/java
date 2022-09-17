package com.javafee.java.tasks.task5;

public class Task5 {
    public static void main(String[] args) {
        int n = 2, z = 4;

        for (int i = 1; i <= z; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(i + " ");
            }
            System.out.print("| ");
        }
    }
}
