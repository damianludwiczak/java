package com.javafee.java.lessons.lesson15.controller;

import com.javafee.java.lessons.lesson15.view.ClientForm;
import com.javafee.java.lessons.lesson15.view.Utils;
import com.javafee.java.lessons.lesson15.view.model.ClientTableModel;

import javax.swing.*;
import java.util.Objects;

public class ClientController {
    private ClientForm clientForm;
    private ClientFormController clientFormController;
    private static ClientController instance = null;

    private ClientController() {
        clientForm = new ClientForm();
        clientFormController = ClientFormController.getInstance();
    }

    public static ClientController getInstance() {
        if (Objects.isNull(instance))
            instance = new ClientController();
        return instance;
    }


    public void control() {
        init();

        clientForm.getFrame().getRootPane().setDefaultButton(clientForm.getButtonAdd());

        clientForm.getButtonAdd().addActionListener(e -> onClickBtnAdd());
        clientForm.getButtonModify().addActionListener(e -> onClickBtnModify());
        clientForm.getButtonDelete().addActionListener(e -> onClickBtnDelete());
        clientForm.getButtonManagementCompany().addActionListener(e -> onClickBtnManagementCompany());
        clientForm.getButtonFilter().addActionListener(e -> onClickBtnFilter());
        updateData();
    }
    private void init() {
        clientForm.getFrame().setVisible(true);
    }

    private void onClickBtnAdd() {
        clientFormController.control(e -> updateData(), "add", null);
    }

    private void onClickBtnModify() {
        int selectedIndex = clientForm.getTableClient().getSelectedRow();
        if (selectedIndex != -1) {
            int index = clientForm.getTableClient().convertRowIndexToModel(selectedIndex);
            clientFormController.control(e -> updateData(), "modify",
                    ((ClientTableModel) clientForm.getTableClient().getModel()).getClient(index));
        } else {
            Utils.displayPopup("Not selected row", "Error", JOptionPane.ERROR_MESSAGE, clientForm.getFrame());
        }
    }

    private void onClickBtnDelete() {
        int selectedIndex = clientForm.getTableClient().getSelectedRow();
        if (selectedIndex != -1) {
            int index = clientForm.getTableClient().convertRowIndexToModel(selectedIndex);
            clientFormController.delete(e -> updateData(),
                    ((ClientTableModel) clientForm.getTableClient().getModel()).getClient(index));
        } else
            Utils.displayPopup("Not selected row", "Error", JOptionPane.ERROR_MESSAGE, clientForm.getFrame());
    }

    private void onClickBtnManagementCompany() {
        CompanyController.getInstance(e -> updateData()).open();
    }
    private void onClickBtnFilter() {
        clientFormController.filterClient(e -> updateData());
    }

    private void updateData() {
        ((ClientTableModel) clientForm.getTableClient().getModel()).reload();
    }
}
