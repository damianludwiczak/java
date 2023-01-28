package com.javafee.java.lessons.lesson14.experiment;

import com.javafee.java.lessons.lesson14.experiment.testscenario.TestScenario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(new TestScenario(() -> {
                if (1 == 1) {
                }
            }, 1_00_000_000_000L));
            Thread thread2 = new Thread(new TestScenario(() -> {
                if (9_223_372_036_854_775_807L == 9_223_372_036_854_775_807L) {
                }
            }, 1_00_000_000_000L));
            System.out.println(thread1.getName());
            thread1.start();
            System.out.println(thread2.getName());
            thread2.start();
        }

        String exitCommand = "";
        Scanner scanner = new Scanner(System.in);
        while (!"exit".equals(exitCommand)) {
            System.out.println("In the meantime, please say something about u... :)");
            exitCommand = scanner.next();
            System.out.println("It's really awesome what u said! \"" + exitCommand + "\"");
        }
    }
}
