package com.javafee.java.tasks.task9;
public class Task9 {
    public static void main(String[] args) {
        int n = 9, firstNumber = 2, secondNumber = 4;
        for (int i = 1; i <= n; i++, firstNumber++) {
            System.out.print(firstNumber + " " + secondNumber + " ");
            secondNumber += i;
        }
    }
}
