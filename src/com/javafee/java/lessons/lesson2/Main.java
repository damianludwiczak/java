package com.javafee.java.lessons.lesson2;

import java.text.MessageFormat;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program sprawdza czy liczba jest liczba pierwsza");
        long input = 10000000000L;
        // solution1(input);
        solution2(input);
        shortenV1();
        shortenV2();

        for (int i = 0, j = 5; i < 7; i++, j = (i % 2 == 0 ? j + 5 : j + 10))
            System.out.print(j + " ");
        System.out.println();

        for (int i = 0, j = 5; i < 7; i++) {
            System.out.print(j + " ");
            if (i % 2 == 0)
                j += 5;
            else
                j += 10;
        }
        System.out.println();

        System.out.println(resolveDayV1(new Random().nextInt(8) + 1));
        System.out.println(resolveDayV2(new Random().nextInt(8) + 1));
    }

    public static void solution1(long number) {
        long counter = 0, startTime = System.currentTimeMillis();
        for (long i = 2; i < number; i++)
            if (number % i == 0)
                counter++;
        System.out.println(System.currentTimeMillis() - startTime + " [ms]");
        if (counter == 1) System.out.println("to liczba pierwsza");
        else System.out.println("to nie jest liczba pierwsza");
    }

    public static void solution2(long number) {
        long startTime = System.currentTimeMillis();
        for (long i = 2; i < number; i++)
            if (number % i == 0) {
                System.out.println(System.currentTimeMillis() - startTime + " [ms]");
                System.out.println("to nie jest liczba pierwsza");
                return;
            }
        System.out.println(System.currentTimeMillis() - startTime + " [ms]");
        System.out.println("to liczba pierwsza");
    }

    public static void shortenV1() {
        for (int i = 0, g = 5, j = 1000; i < 5; i++, j = (j % 2 == 0 ? j - 1 : j - 10), g += 5)
            System.out.println(MessageFormat.format("{0} {1} {2}", i, j, g));
    }

    public static void shortenV2() {
        int j = 1000, g = 5;
        for (int i = 0; i < 5; i++) {
            System.out.println(MessageFormat.format("{0} {1} {2}", i, j, g));

            if (j % 2 == 0)
                j--;
            else
                j -= 10;

            g += 5;
        }
    }

    public static String resolveDayV1(int day) {
        return switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday <3";
            case 7 -> "Sunday <3";
            default -> "unknown";
        };
    }

    public static String resolveDayV2(int day) {
        String d;
        switch (day) {
            case 1:
                d = "Monday";
                break;
            case 2:
                d = "Tuesday";
                break;
            case 3:
                d = "Wenesday";
                break;
            case 4:
                d = "Thursday";
                break;
            case 5:
                d = "Friday";
                break;
            case 6:
                d = "Saturday <3";
                break;
            case 7:
                d = "Sunday <3";
                break;
            default:
                d = "unknown";
        }
        return d;
    }
}
