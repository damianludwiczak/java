package com.javafee.java.lessons.lesson7.view.impl;

import com.javafee.java.lessons.lesson7.view.View;

import java.util.Scanner;

public class ViewImpl implements View {
    private Scanner scanner = new Scanner(System.in);

    public void print(String msg) {
        System.out.println(msg);
    }

    public String getInputString(String msg) {
        System.out.println(msg);
        return scanner.next();
    }

    public Double getInputDouble(String msg) {
        System.out.println(msg);
        return scanner.nextDouble();
    }
}
