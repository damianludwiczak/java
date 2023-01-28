package com.javafee.java.lessons.lesson12.view;

import javax.swing.*;
import java.awt.*;

public class LoginForm {
    private JFrame frame;
    private JPanel panel;
    private JTextField textFieldLogin;
    private JPasswordField passwordField;
    private JButton buttonLogin;

    public LoginForm() {
        frame = new JFrame("Login (c) myCMS");
        frame.setIconImage(new ImageIcon(AddClientForm.class.getResource("btnLogOut-ico.png")).getImage());
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        buttonLogin.setIcon(new ImageIcon(new ImageIcon(AddClientForm.class.getResource("btnLogIn-ico.png"))
                .getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH)));
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
