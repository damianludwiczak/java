package com.javafee.java.tasks.lesson12;

import com.javafee.java.tasks.lesson12.controller.Controller;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new Controller().run();
    }
}
