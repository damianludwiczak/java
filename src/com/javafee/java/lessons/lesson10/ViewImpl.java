package com.javafee.java.lessons.lesson10;

import java.util.Scanner;

public class ViewImpl implements View {
    Scanner scanner = new Scanner(System.in);

    public void print(String msg) {
        System.out.println(msg);
    }

    public String getString(String msg){
        System.out.println(msg);
        return scanner.next();
    }
}