package com.javafee.java.lessons.lesson12.view;

import javax.swing.*;

public class LoginForm {
    private JFrame frame;
    private JPanel panel;
    private JTextField textFieldLogin;
    private JPasswordField passwordField;
    private JButton buttonLogin;

    public LoginForm() {
        frame = new JFrame("Login (c) myCMS");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTextField getTextFieldLogin() {
        return textFieldLogin;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getButtonLogin() {
        return buttonLogin;
    }
}
