package com.javafee.java.lessons.lesson1;

public class Main {
    public static void main(String[] args) {
//        int a;
//        double b = 2.0;
//
//        char c = 76;
//        System.out.println(c);
//
//        a = 1;
//        System.out.println(a++); // ?
//        System.out.println(++a); // ?
//
//        double d = a, e = 3.99;
//        int f = (int) e;
//        double g = a;
//
//
//        int h = 0;
//        for (int i = 5; ; ) {
//            System.out.print(h + " " + i + " ");
//            if (i == 0) break;
//            h++;
//            i--;
//        }

        // for input n = 4
        // 2 10 4 100 8 1000 16 10000
        int n = 4;
        for (int i = 0, dec = 10, pow = 2; i < 4; i++, dec *= 10, pow *= 2)
            System.out.print(pow + " " + dec + " ");
        System.out.println();
    }
}
