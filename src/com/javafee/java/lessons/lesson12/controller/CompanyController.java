package com.javafee.java.lessons.lesson12.controller;


import com.javafee.java.lessons.lesson12.view.CompanyForm;
import com.javafee.java.lessons.lesson12.view.Utils;
import com.javafee.java.lessons.lesson12.view.model.ClientTableModel;
import com.javafee.java.lessons.lesson12.view.model.CompanyTableModel;

import javax.swing.*;

public class CompanyController {
    private CompanyForm companyForm;
    private CompanyFormController companyFormController;


    public CompanyController() {
        companyForm = new CompanyForm();
        companyFormController = new CompanyFormController();

    }

    public void control() {
        init();

        companyForm.getButtonAdd().addActionListener(e -> onClickButtonAdd());
        companyForm.getButtonModify().addActionListener(e -> onClickButtonModify());
        companyForm.getButtonDelete().addActionListener(e -> onClickButtonDelete());
    }

    private void onClickButtonAdd() {
        companyFormController.control(e -> updateData(), "add", null);
    }
    private void onClickButtonModify() {
        int selectedIndex = companyForm.getTableCompany().getSelectedRow();
        if (selectedIndex != -1) {
            int index = companyForm.getTableCompany().convertRowIndexToModel(selectedIndex);
            companyFormController.control(e -> updateData(), "modify",
                    ((CompanyTableModel)companyForm.getTableCompany().getModel()).getCompany(index));
        } else {
            Utils.displayPopup("Not selected row", "Error", JOptionPane.ERROR_MESSAGE, companyForm.getFrame());
        }
    }
    private void onClickButtonDelete() {
        int selectedIndex = companyForm.getTableCompany().getSelectedRow();
        if (selectedIndex != -1) {
            int index = companyForm.getTableCompany().convertRowIndexToModel(selectedIndex);
            companyFormController.delete(e -> updateData(), ((CompanyTableModel)companyForm.getTableCompany().getModel()).getCompany(index));
        } else {
            Utils.displayPopup("Not selected row", "Error", JOptionPane.ERROR_MESSAGE, companyForm.getFrame());
        }
    }

    private void updateData(){
        ((CompanyTableModel) companyForm.getTableCompany().getModel()).reload();
    }


    private void init() {
        companyForm.getFrame().setVisible(true);
    }
}
