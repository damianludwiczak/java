package com.javafee.java.lessons.lesson11;

import com.javafee.java.lessons.lesson11.backend.controller.gui.Controller;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new Controller().run();
    }
}
