package com.javafee.java.lessons.lesson6;

import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public Double getInputDouble(String msg) {
        printMessage(msg);
        return scanner.nextDouble();
    }

    public Integer getInputInteger(String msg) {
        printMessage(msg);
        return scanner.nextInt();
    }

    public String getInputString(String msg) {
        printMessage(msg);
        return scanner.next();
    }
}
