package com.javafee.java.tasks.task10;
public class Task10 {
    public static void main(String[] args) {
        int n = 10, i = 1, k = 1, firstNumber = 2, secondNumber = 4;
        while (k < n) {
            while (i < n) {
                System.out.print(firstNumber + " " + secondNumber + " ");
                firstNumber++;
                secondNumber += i;
                i++;
            }
            System.out.println();
            while (i > 1) {
                firstNumber--;
                i--;
                secondNumber -= i;
                System.out.print(secondNumber + " " + firstNumber + " ");
            }
            System.out.println();
            firstNumber++;
            secondNumber++;
            k++;
        }
    }
}
