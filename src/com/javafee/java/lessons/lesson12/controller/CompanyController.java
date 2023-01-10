package com.javafee.java.lessons.lesson12.controller;

import com.javafee.java.lessons.lesson12.view.CompanyForm;
import com.javafee.java.lessons.lesson12.view.Utils;
import com.javafee.java.lessons.lesson12.view.model.CompanyTableModel;

import javax.swing.*;
import java.util.Objects;
import java.util.function.Consumer;

public class CompanyController {
    private CompanyForm companyForm;
    private static Consumer reloadAction;
    private static CompanyController instance = null;

    private CompanyController() {
        companyForm = new CompanyForm();

        control();
    }

    public static CompanyController getInstance(Consumer reloadClientForm) {
        reloadAction = reloadClientForm;
        if (Objects.isNull(instance))
            instance = new CompanyController();
        return instance;
    }

    private void control() {
        companyForm.getButtonAdd().addActionListener(e -> onClickButtonAdd());
        companyForm.getButtonModify().addActionListener(e -> onClickButtonModify());
        companyForm.getButtonDelete().addActionListener(e -> onClickButtonDelete());
    }

    public void open() {
        updateData();
        companyForm.getFrame().setVisible(true);
    }

    private void onClickButtonAdd() {
        CompanyFormController.getInstance(reloadAction, e -> updateData(), "add", null).open();
    }

    private void onClickButtonModify() {
        int selectedIndex = companyForm.getTableCompany().getSelectedRow();
        if (selectedIndex != -1) {
            int index = companyForm.getTableCompany().convertRowIndexToModel(selectedIndex);
            CompanyFormController.getInstance(reloadAction, e -> updateData(), "modify",
                    ((CompanyTableModel) companyForm.getTableCompany().getModel()).getCompany(index)).open();
        } else {
            Utils.displayPopup("Not selected row", "Error", JOptionPane.ERROR_MESSAGE, companyForm.getFrame());
        }
    }

    private void onClickButtonDelete() {
        int selectedIndex = companyForm.getTableCompany().getSelectedRow();
        if (selectedIndex != -1) {
            int index = companyForm.getTableCompany().convertRowIndexToModel(selectedIndex);
            CompanyFormController.getInstance(e -> updateData(), reloadAction, "delete",
                    (((CompanyTableModel) companyForm.getTableCompany().getModel()).getCompany(index))).delete();
        } else {
            Utils.displayPopup("Not selected row", "Error", JOptionPane.ERROR_MESSAGE, companyForm.getFrame());
        }
        reloadAction.accept(null);
    }

    private void updateData() {
        ((CompanyTableModel) companyForm.getTableCompany().getModel()).reload();
    }
}
