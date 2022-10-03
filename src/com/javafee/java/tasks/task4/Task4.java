package com.javafee.java.tasks.task4;
public class Task4 {
    public static void main(String[] args) {
        for (int i = 1, n = 4, k = -5; n > 0; n--) {
            if (n % 2 == 0) {
                k += 6;
                for (int j = 1; j <= 5; j++) {
                    System.out.print(k + " ");
                    k++;
                }
                System.out.println();
            } else {
                k += 4;
                for (int j = 1; j <= 5; j++) {
                    System.out.print(k + " ");
                    k--;
                }
                System.out.println();
            }
        }
    }
}
