package com.javafee.java.lessons.lesson15.controller;

import com.javafee.java.lessons.lesson15.model.Client;
import com.javafee.java.lessons.lesson15.model.Company;
import com.javafee.java.lessons.lesson15.view.ClientForm;
import com.javafee.java.lessons.lesson15.view.FilterClientForm;
import com.javafee.java.lessons.lesson15.view.Utils;
import com.javafee.java.lessons.lesson15.view.model.ClientTableModel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Objects;

public class ClientController {
    private ClientForm clientForm;
    private ClientFormController clientFormController;
    private FilterClientForm filterClientForm;
    private static ClientController instance = null;
    private static FilterClientForm instanceFilterClientForm = null;

    private ActionListener addActionListener = e -> onClickBtnFilter();

    private ClientController() {
        clientForm = new ClientForm();
        clientFormController = ClientFormController.getInstance();
        filterClientForm = getInstanceFilterClientForm();
    }
    public static ClientController getInstance() {
        if (Objects.isNull(instance))
            instance = new ClientController();
        return instance;
    }

    public static FilterClientForm getInstanceFilterClientForm() {
        if (Objects.isNull(instance))
            instanceFilterClientForm = new FilterClientForm();
        return instanceFilterClientForm;
    }

    public void control() {
        init();

        clientForm.getFrame().getRootPane().setDefaultButton(clientForm.getButtonAdd());

        clientForm.getButtonAdd().addActionListener(e -> onClickBtnAdd());
        clientForm.getButtonModify().addActionListener(e -> onClickBtnModify());
        clientForm.getButtonDelete().addActionListener(e -> onClickBtnDelete());
        clientForm.getButtonManagementCompany().addActionListener(e -> onClickBtnManagementCompany());
        clientForm.getButtonFilter().addActionListener(e -> onClickBtnFilter());
        clientForm.getButtonRemoveFilters().addActionListener(e -> updateData());
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
        reloadEmptyFilterForm();
        initFilterForm();
    }

    private void updateData() {
        ((ClientTableModel) clientForm.getTableClient().getModel()).reload();
    }

    private void updateFilterData() {
        Client client = new Client();
        Company company = new Company();
        client.setName(filterClientForm.getTextFieldName().getText());
        client.setSurname(filterClientForm.getTextFieldSurname().getText());
        client.setNationality(filterClientForm.getTextFieldNationality().getText());
        company.setName(filterClientForm.getTextFieldCompanyName().getText());
        client.setAgeFrom(filterClientForm.getTextFieldAgeFrom().getText());
        client.setAgeTo(filterClientForm.getTextFieldAgeTo().getText());
        client.setWageFrom(filterClientForm.getTextFieldWageFrom().getText());
        client.setWageTo(filterClientForm.getTextFieldWageTo().getText());
        client.setCompanyList(Collections.singletonList(company));

        ((ClientTableModel) clientForm.getTableClient().getModel()).reloadFilterData(client);
        closeFilterForm();
    }
    private void initFilterForm() {
        filterClientForm.getFrame().setVisible(true);
        if (filterClientForm.getButtonFilter().getActionListeners().length == 0)
            filterClientForm.getButtonFilter().addActionListener(e -> updateFilterData());
    }

    private void closeFilterForm() {
        filterClientForm.getFrame().setVisible(false);
    }

    private void reloadEmptyFilterForm() {
        filterClientForm.getTextFieldName().setText(null);
        filterClientForm.getTextFieldSurname().setText(null);
        filterClientForm.getTextFieldNationality().setText(null);
        filterClientForm.getTextFieldAgeFrom().setText(null);
        filterClientForm.getTextFieldAgeTo().setText(null);
        filterClientForm.getTextFieldWageFrom().setText(null);
        filterClientForm.getTextFieldWageTo().setText(null);
        filterClientForm.getTextFieldCompanyName().setText(null);
    }
}
