package com.javafee.java.tasks.task9;
public class Task9 {
    public static void main(String[] args) {
        int n = 9, firstNumber = 2, secondNumber = 4;
        for (int i = 1; i <= n; i++) {
            System.out.print(firstNumber + " " + secondNumber + " ");
            firstNumber++;
            secondNumber += i;
        }
    }
}
