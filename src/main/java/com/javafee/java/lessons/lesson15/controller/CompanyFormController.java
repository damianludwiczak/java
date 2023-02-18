package com.javafee.java.lessons.lesson15.controller;

import com.javafee.java.lessons.lesson15.model.domain.Client;
import com.javafee.java.lessons.lesson15.model.domain.Company;
import com.javafee.java.lessons.lesson15.model.repository.Dao;
import com.javafee.java.lessons.lesson15.model.repository.filedb.FileDb;
import com.javafee.java.lessons.lesson15.model.repository.jdbcdb.CompanyJdbcDb;
import com.javafee.java.lessons.lesson15.service.Utils;
import com.javafee.java.lessons.lesson15.view.AddCompanyForm;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class CompanyFormController {
    private AddCompanyForm addCompanyForm;
    private ActionListener addActionListener = e -> onClickButtonAdd(reloadActionClient);
    private ActionListener modifyActionListener = e -> onClickButtonModify(reloadActionClient);
    private List<Company> companyList = new ArrayList<>();
    private Dao<Company> fileDbCompany = new CompanyJdbcDb(); // new FileDb<>(Utils.COMPANY_FILE);
    private static Company company;
    private static String context;

    private static Consumer reloadActionClient;
    private static Consumer reloadActionCompany;

    private static CompanyFormController instance = null;

    private CompanyFormController() {
        addCompanyForm = new AddCompanyForm();
    }

    public static CompanyFormController getInstance(Consumer reloadActionClientForm, Consumer reloadActionCompanyForm,
                                                    String context, Company company) {
        reloadActionClient = reloadActionClientForm;
        reloadActionCompany = reloadActionCompanyForm;
        if (Objects.isNull(instance))
            instance = new CompanyFormController();

        CompanyFormController.context = context;
        CompanyFormController.company = company;

        return instance;
    }

    public void open() {
        addCompanyForm.getFrame().setVisible(true);

        addCompanyForm.getButtonConfirm().removeActionListener(addActionListener);
        addCompanyForm.getButtonConfirm().removeActionListener(modifyActionListener);
        if (context.equals("add")) {
            reloadEmptyForm();
            addCompanyForm.getButtonConfirm().addActionListener(addActionListener);
        } else if (context.equals("modify")) {
            this.company = company;
            reloadForm(company);
            addCompanyForm.getButtonConfirm().addActionListener(modifyActionListener);
        } else {
            delete();
        }
    }

    private void onClickButtonAdd(Consumer reloadClient) {
        companyList = fileDbCompany.findAll();
        String name = addCompanyForm.getTextFieldName().getText();
        Double YearlyIncomes;
        try {
            YearlyIncomes = Double.valueOf(addCompanyForm.getTextFieldYearlyIncomes().getText());
        } catch (NumberFormatException e) {
            YearlyIncomes = 0.0;
        }
        this.company = new Company(name, YearlyIncomes);
        companyList.add(company);
        fileDbCompany.saveAll(companyList);
        reloadActionCompany.accept(null);
        reloadClient.accept(null);
    }

    private void onClickButtonModify(Consumer reloadClient) {
        companyList = fileDbCompany.findAll();
        int indexOfCompanyInList = companyList.indexOf(company);

        companyList.get(indexOfCompanyInList).setName(addCompanyForm.getTextFieldName().getText());
        try {
            companyList.get(indexOfCompanyInList).setYearlyIncomes(Double.valueOf(addCompanyForm.getTextFieldYearlyIncomes().getText()));
        } catch (Exception e) {
            companyList.get(indexOfCompanyInList).setYearlyIncomes(0.0);
        }
        modifyCompanyInClientList(companyList.get(indexOfCompanyInList));
        fileDbCompany.saveAll(companyList);
        reloadActionCompany.accept(null);
        reloadClient.accept(null);
    }

    public void delete() {
        companyList = fileDbCompany.findAll();
        companyList.remove(company);
        deleteCompanyInClientList(company);
        fileDbCompany.saveAll(companyList);
        reloadActionCompany.accept(null);
        reloadActionClient.accept(null);
    }

    private void modifyCompanyInClientList(Company company) {
        int indexCompanyInList = 0;
        FileDb<Client> fileDbClient = new FileDb<>(Utils.CLIENT_FILE);
        List<Client> clientList = fileDbClient.findAll();
        if (!(clientList == null || clientList.isEmpty())) {
            for (Client client : clientList) {
                if (client.getCompanyList().contains(company)) {
                    indexCompanyInList = client.getCompanyList().indexOf(company);
                    client.getCompanyList().remove(indexCompanyInList);
                    client.getCompanyList().add(indexCompanyInList, company);
                }
            }
            fileDbClient.saveAll(clientList);
        }
    }

    private void deleteCompanyInClientList(Company company) {
        int indexCompanyInList = 0;
        FileDb<Client> fileDbClient = new FileDb<>(Utils.CLIENT_FILE);
        List<Client> clientList = fileDbClient.findAll();
        if (!(clientList == null || clientList.isEmpty())) {
            for (Client client : clientList) {
                if (!(client.getCompanyList() == null || client.getCompanyList().isEmpty())) {
                    if (client.getCompanyList().contains(company)) {
                        indexCompanyInList = client.getCompanyList().indexOf(company);
                        client.getCompanyList().remove(indexCompanyInList);
                    }
                }
            }
            fileDbClient.saveAll(clientList);
        }
    }

    private void reloadForm(Company company) {
        addCompanyForm.getTextFieldName().setText(company.getName());
        addCompanyForm.getTextFieldYearlyIncomes().setText(String.valueOf(company.getYearlyIncomes()));
    }

    private void reloadEmptyForm() {
        addCompanyForm.getTextFieldName().setText("");
        addCompanyForm.getTextFieldYearlyIncomes().setText("");
    }
}
