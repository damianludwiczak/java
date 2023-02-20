package com.javafee.java.lessons.lesson15.controller;

import com.javafee.java.lessons.lesson15.service.LoginService;
import com.javafee.java.lessons.lesson15.view.LoginForm;
import com.javafee.java.lessons.lesson15.view.Utils;

import javax.swing.*;
import java.util.Objects;

/**
 * Store all the actions and manage them.
 * Broker between front-end and back-end.
 */
public class LoginController {
    private LoginForm loginForm;
    private LoginService loginService;
    private ClientController clientController;

    private static LoginController instance = null;

    private LoginController() {
        loginForm = new LoginForm();
        loginService = new LoginService();
        clientController = ClientController.getInstance();
    }

    public static LoginController getInstance() {
        if (Objects.isNull(instance))
            instance = new LoginController();
        return instance;
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
