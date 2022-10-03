package com.javafee.java.tasks.zad2_trojkat1;
public class Trojkat1 {
    public static void main(String[] args) {
        char znak = '*';
        for (int i = 1, n = 5; i <= n;i++){
            for (int j = 0; j < i; j++) { System.out.print(znak);}
            System.out.println();
        }
    }
}
