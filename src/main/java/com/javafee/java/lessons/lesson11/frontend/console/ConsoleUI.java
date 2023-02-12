package com.javafee.java.lessons.lesson11.frontend.console;

import com.javafee.java.lessons.lesson11.frontend.View;

import javax.swing.*;
import java.util.Scanner;

public class ConsoleUI implements View {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String getFirstVar() {
        return scanner.next();
    }

    @Override
    public String getSecondVar() {
        return scanner.next();
    }

    @Override
    public String getCalculationType() {
        return scanner.next();
    }

    @Override
    public void setMessage(String result) {
        System.out.println(result);
    }

    @Override
    public JButton getButtonCalculate() {
        throw new UnsupportedOperationException("Unsupported operation for console UI");
    }

    @Override
    public JFrame getFrame() {
        throw new UnsupportedOperationException("Unsupported operation for console UI");
    }
}
