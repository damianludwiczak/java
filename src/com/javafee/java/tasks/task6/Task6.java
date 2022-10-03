package com.javafee.java.tasks.task6;
public class Task6 {
    public static void main(String[] args) {
        for (int i = 1, n = 4, z = 0; i <= n;) {
            z++;
            if (z % 2 == 0) {
                for (int j = 1; j <= i; j++) { System.out.print(z + " ");}
                System.out.println();
                i++;
            }
        }
    }
}
