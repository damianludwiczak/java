package com.javafee.java.lessons.lesson12.controller;

import com.javafee.java.lessons.lesson12.service.ClientService;
import com.javafee.java.lessons.lesson12.view.ClientForm;

public class ClientController {
    private ClientForm clientForm;
    private ClientService clientService;

    public ClientController() {
        clientForm = new ClientForm();
        clientService = new ClientService();
    }

    public void control() {
        init();

    }

    private void init() {
        clientForm.getFrame().setVisible(true);
    }
}
