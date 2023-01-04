package com.javafee.java.lessons.lesson12.controller;


import com.javafee.java.lessons.lesson12.view.CompanyForm;
import com.javafee.java.lessons.lesson12.view.Utils;
import com.javafee.java.lessons.lesson12.view.model.CompanyTableModel;

import javax.swing.*;
import java.util.function.Consumer;

public class CompanyController {
    private CompanyForm companyForm;
    private CompanyFormController companyFormController;
    private Consumer reloadAction;


    public CompanyController() {
        companyForm = new CompanyForm();
        companyFormController = new CompanyFormController();
    }

    public void control(Consumer reloadClientForm) {
        updateData();
        init();

        this.reloadAction = reloadClientForm;

        companyForm.getButtonAdd().addActionListener(e -> onClickButtonAdd(reloadAction));
        companyForm.getButtonModify().addActionListener(e -> onClickButtonModify(reloadAction));
        companyForm.getButtonDelete().addActionListener(e -> onClickButtonDelete(reloadAction));
    }

    private void onClickButtonAdd(Consumer reloadAction) {
        companyFormController.control(e -> updateData(), reloadAction, "add", null);
    }
    private void onClickButtonModify(Consumer reloadAction) {
        int selectedIndex = companyForm.getTableCompany().getSelectedRow();
        if (selectedIndex != -1) {
            int index = companyForm.getTableCompany().convertRowIndexToModel(selectedIndex);
            companyFormController.control(e -> updateData(), reloadAction, "modify",
                    ((CompanyTableModel)companyForm.getTableCompany().getModel()).getCompany(index));
        } else {
            Utils.displayPopup("Not selected row", "Error", JOptionPane.ERROR_MESSAGE, companyForm.getFrame());
        }
    }
    private void onClickButtonDelete(Consumer reloadAction) {
        int selectedIndex = companyForm.getTableCompany().getSelectedRow();
        if (selectedIndex != -1) {
            int index = companyForm.getTableCompany().convertRowIndexToModel(selectedIndex);
            companyFormController.delete(e -> updateData(), reloadAction, ((CompanyTableModel)companyForm.getTableCompany().getModel()).getCompany(index));
        } else {
            Utils.displayPopup("Not selected row", "Error", JOptionPane.ERROR_MESSAGE, companyForm.getFrame());
        }
        reloadAction.accept(null);
    }
    private void updateData(){
        ((CompanyTableModel) companyForm.getTableCompany().getModel()).reload();
    }
    private void init() {
        companyForm.getFrame().setVisible(true);
    }
}
