package com.javafee.java.tasks.task8;
public class Task8 {
    public static void main(String[] args) {
        int n = 5, m = n;
        int[] board = new int[n];
        if (n % 2 == 1) // n - 1 powtorzen dla nieparzystych
            m -= 1;
        for (int i = 0; i < board.length; i++) {board[i] = i + 1;} // wypełniam tablice
        for (int j:board) {System.out.print(j + " ");}
        for (int i = 1; i < m; ) {
            if (i % 2 == 0) {
                for (int j = 1; j < board.length; j++) {System.out.print(board[j] + " ");}
                i++;
            } else {
                for (int j = n - 2; j >= 0; j--) {System.out.print(board[j] + " ");}
                i++;
            }
        }
    }
}
