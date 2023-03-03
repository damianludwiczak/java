package com.javafee.java.lessons.lesson15.controller;

import com.javafee.java.lessons.lesson15.model.domain.Company;
import com.javafee.java.lessons.lesson15.view.CompanyForm;
import com.javafee.java.lessons.lesson15.view.FilterCompanyForm;
import com.javafee.java.lessons.lesson15.view.Utils;
import com.javafee.java.lessons.lesson15.view.model.CompanyTableModel;

import javax.swing.*;
import java.util.Objects;
import java.util.function.Consumer;

public class CompanyController {
    private CompanyForm companyForm;
    private static Consumer reloadAction;
    private static CompanyController instance = null;
    private FilterCompanyForm filterCompanyForm;

    private CompanyController() {
        companyForm = new CompanyForm();
        filterCompanyForm = new FilterCompanyForm();
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
        companyForm.getButtonFilter().addActionListener(e -> onClickButtonFilter());
        companyForm.getButtonDelete().addActionListener(e -> onClickButtonDelete());
        companyForm.getButtonRemoveFilters().addActionListener(e -> updateData());
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

    private void onClickButtonFilter() {
        initFilterForm();
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

    private void initFilterForm() {
        reloadEmptyFilterForm();
        filterCompanyForm.getFrame().setVisible(true);
        filterCompanyForm.getButtonAccept().addActionListener(e -> updateFilterData());
    }

    private void closeFilterForm() {
        filterCompanyForm.getFrame().setVisible(false);
    }

    private void reloadEmptyFilterForm() {
        filterCompanyForm.getTextFieldName().setText(null);
        filterCompanyForm.getTextFieldYearlyIncomesFrom().setText(null);
        filterCompanyForm.getTextFieldYearlyIncomesTo().setText(null);
    }

    private void updateFilterData() {
        Company company = new Company();
        company.setName(filterCompanyForm.getTextFieldName().getText());
        company.setYearlyIncomesFrom(filterCompanyForm.getTextFieldYearlyIncomesFrom().getText());
        company.setYearlyIncomesTo(filterCompanyForm.getTextFieldYearlyIncomesTo().getText());

        ((CompanyTableModel) companyForm.getTableCompany().getModel()).reloadFilterData(company);
        closeFilterForm();
    }

    private void updateData() {
        ((CompanyTableModel) companyForm.getTableCompany().getModel()).reload();
    }
}
