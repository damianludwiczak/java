package com.javafee.java.lessons.lesson12.view;

import javax.swing.*;
import java.awt.*;

public class Utils {
    public static void displayPopup(String message, String title, int type, Component component) {
        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage("<html>" + message + "</html>");
        optionPane.setMessageType(type);
        JDialog dialog = optionPane.createDialog(component, title);
        dialog.setVisible(true);
    }
}
