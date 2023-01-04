package com.javafee.java.lessons.lesson12.controller;

import com.javafee.java.lessons.lesson12.service.LoginService;
import com.javafee.java.lessons.lesson12.view.LoginForm;
import com.javafee.java.lessons.lesson12.view.Utils;

import javax.swing.*;

/**
 * Store all the actions and manage them.
 * Broker between front-end and back-end.
 */
public class LoginController {
    private LoginForm loginForm;
    private LoginService loginService;
    private ClientController clientController;

    public LoginController() {
        loginForm = new LoginForm();
        loginService = new LoginService();
        clientController = new ClientController();
    }

    public void control() {
        init();

        loginForm.getButtonLogin().addActionListener(e -> onClickButtonLogin());
        loginForm.getFrame().getRootPane().setDefaultButton(loginForm.getButtonLogin());
    }

    private void init() {
        loginForm.getFrame().setVisible(true);
    }

    private void onClickButtonLogin() {
        if (loginService.authenticate(loginForm.getTextFieldLogin().getText(),
                String.valueOf(loginForm.getPasswordField().getPassword()))) {
            loginForm.getFrame().setVisible(false);
            clientController.control();
        } else
            Utils.displayPopup("Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE, loginForm.getFrame());
    }
}
