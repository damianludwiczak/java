package com.javafee.java.lessons.lesson12.controller;

import com.javafee.java.lessons.lesson12.view.ClientForm;
import com.javafee.java.lessons.lesson12.view.Utils;
import com.javafee.java.lessons.lesson12.view.model.ClientTableModel;

import javax.swing.*;

public class ClientController {
    private ClientForm clientForm;
    private ClientFormController clientFormController;
    private CompanyController companyController;

    public ClientController() {
        clientForm = new ClientForm();
        clientFormController = new ClientFormController();
        companyController = new CompanyController();
    }

    public void control() {
        init();

        clientForm.getFrame().getRootPane().setDefaultButton(clientForm.getButtonAdd());

        clientForm.getButtonAdd().addActionListener(e -> onClickBtnAdd());
        clientForm.getButtonModify().addActionListener(e -> onClickBtnModify());
        clientForm.getButtonDelete().addActionListener(e -> onClickBtnDelete());
        clientForm.getButtonManagementCompany().addActionListener(e -> onClickBtnManagementCompany());
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
                    ((ClientTableModel)clientForm.getTableClient().getModel()).getClient(index));
        } else {
            Utils.displayPopup("Not selected row", "Error", JOptionPane.ERROR_MESSAGE, clientForm.getFrame());
        }
    }

    private void onClickBtnDelete( ) {
        int selectedIndex = clientForm.getTableClient().getSelectedRow();
        if (selectedIndex != -1) {
            int index = clientForm.getTableClient().convertRowIndexToModel(selectedIndex);
            clientFormController.delete(e -> updateData(),
                    ((ClientTableModel)clientForm.getTableClient().getModel()).getClient(index));
        } else
            Utils.displayPopup("Not selected row", "Error", JOptionPane.ERROR_MESSAGE, clientForm.getFrame());
    }

    private void onClickBtnManagementCompany(){
        companyController.control(e -> updateData());
    }

    private void updateData() {
        ((ClientTableModel) clientForm.getTableClient().getModel()).reload();
    }
}
