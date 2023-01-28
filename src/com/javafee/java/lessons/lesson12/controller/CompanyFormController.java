package com.javafee.java.lessons.lesson12.controller;

import com.javafee.java.lessons.lesson12.model.domain.Client;
import com.javafee.java.lessons.lesson12.model.domain.Company;
import com.javafee.java.lessons.lesson12.model.repository.DAO;
import com.javafee.java.lessons.lesson12.service.Utils;
import com.javafee.java.lessons.lesson12.view.AddCompanyForm;

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

    DAO<Company[]> daoCompany = new DAO<>();
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
        companyList = new ArrayList<Company>(List.of(daoCompany.findAll(Utils.COMPANY_FILE)));
        String name = addCompanyForm.getTextFieldName().getText();
        Double YearlyIncomes;
        try {
            YearlyIncomes = Double.valueOf(addCompanyForm.getTextFieldYearlyIncomes().getText());
        } catch (NumberFormatException e) {
            YearlyIncomes = 0.0;
        }
        this.company = new Company(name, YearlyIncomes);
        companyList.add(company);
        daoCompany.saveAll(Utils.COMPANY_FILE, companyList.toArray(new Company[companyList.size()]));
        reloadActionCompany.accept(null);
        reloadClient.accept(null);
    }

    private void onClickButtonModify(Consumer reloadClient) {
        companyList = new ArrayList<Company>(List.of(daoCompany.findAll(Utils.COMPANY_FILE)));
        int indexOfCompanyInList = companyList.indexOf(company);

        companyList.get(indexOfCompanyInList).setName(addCompanyForm.getTextFieldName().getText());
        try {
            companyList.get(indexOfCompanyInList).setYearlyIncomes(Double.valueOf(addCompanyForm.getTextFieldYearlyIncomes().getText()));
        } catch (Exception e) {
            companyList.get(indexOfCompanyInList).setYearlyIncomes(0.0);
        }
        modifyCompanyInClientList(companyList.get(indexOfCompanyInList));
        daoCompany.saveAll(Utils.COMPANY_FILE, companyList.toArray(new Company[companyList.size()]));
        reloadActionCompany.accept(null);
        reloadClient.accept(null);
    }

    public void delete() {
        companyList = new ArrayList<Company>(List.of(daoCompany.findAll(Utils.COMPANY_FILE)));
        companyList.remove(company);
        deleteCompanyInClientList(company);
        daoCompany.saveAll(Utils.COMPANY_FILE, companyList.toArray(new Company[companyList.size()]));
        reloadActionCompany.accept(null);
        reloadActionClient.accept(null);
    }

    private void modifyCompanyInClientList(Company company) {
        int indexCompanyInList = 0;
        DAO<Client[]> daoClient = new DAO<>();
        List<Client> clientList = new ArrayList<Client>(List.of(daoClient.findAll(Utils.CLIENT_FILE)));
        if (!(clientList == null || clientList.isEmpty())) {
            for (Client client : clientList) {
                if (client.getCompanyList().contains(company)) {
                    indexCompanyInList = client.getCompanyList().indexOf(company);
                    client.getCompanyList().remove(indexCompanyInList);
                    client.getCompanyList().add(indexCompanyInList, company);
                }
            }
            daoClient.saveAll(Utils.CLIENT_FILE, clientList.toArray(new Client[clientList.size()]));
        }
    }

    private void deleteCompanyInClientList(Company company) {
        int indexCompanyInList = 0;
        DAO<Client[]> daoClient = new DAO<>();
        List<Client> clientList = new ArrayList<Client>(List.of(daoClient.findAll(Utils.CLIENT_FILE)));
        if (!(clientList == null || clientList.isEmpty())) {
            for (Client client : clientList) {
                if (!(client.getCompanyList() == null || client.getCompanyList().isEmpty())) {
                    if (client.getCompanyList().contains(company)) {
                        indexCompanyInList = client.getCompanyList().indexOf(company);
                        client.getCompanyList().remove(indexCompanyInList);
                    }
                }
            }
            daoClient.saveAll(Utils.CLIENT_FILE, clientList.toArray(new Client[clientList.size()]));
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
