package com.javafee.java.lessons.lesson12.controller;

import com.javafee.java.lessons.lesson12.model.domain.Client;
import com.javafee.java.lessons.lesson12.model.domain.Company;
import com.javafee.java.lessons.lesson12.model.repository.DAO;
import com.javafee.java.lessons.lesson12.service.Utils;
import com.javafee.java.lessons.lesson12.view.AddCompanyForm;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CompanyFormController {
    private AddCompanyForm addCompanyForm;
    private Consumer reload;
    private Consumer reload2;
    private ActionListener addActionListener = e -> onClickButtonAdd(reload2);
    private ActionListener modifyActionListener = e -> onClickButtonModify(reload2);
    private List<Company> companyList = new ArrayList<>();

    DAO<Company[]> daoCompany = new DAO<>();
    private Company company;

    public CompanyFormController() {
       addCompanyForm = new AddCompanyForm();
    }

    public void control(Consumer reload, Consumer reload2, String context, Company company) {
        init();
        this.reload = reload;
        this.reload2 = reload2;
        addCompanyForm.getButtonConfirm().removeActionListener(addActionListener);
        addCompanyForm.getButtonConfirm().removeActionListener(modifyActionListener);
        if (context.equals("add")) {
            reloadEmptyForm();
            addCompanyForm.getButtonConfirm().addActionListener(addActionListener);
        } else {
            this.company = company;
            reloadForm(company);
            addCompanyForm.getButtonConfirm().addActionListener(modifyActionListener);
        }
    }

    private void onClickButtonAdd(Consumer reload2) {
        companyList = new ArrayList<Company>(List.of(daoCompany.findAll(Utils.COMPANY_FILE)));
        try {
            String name = addCompanyForm.getTextFieldName().getText();
            Double YearlyIncomes = Double.valueOf(addCompanyForm.getTextFieldYearlyIncomes().getText());
            this.company = new Company(name, YearlyIncomes);
            companyList.add(company);
            daoCompany.saveAll(Utils.COMPANY_FILE, companyList.toArray(new Company[companyList.size()]));
            reload.accept(null);
            reload2.accept(null);
        } catch (NumberFormatException e) {
            com.javafee.java.lessons.lesson12.view.Utils.displayPopup("Wrong input in field age or wage", "Error",
                    JOptionPane.ERROR_MESSAGE, addCompanyForm.getFrame());
        }
    }

    private void onClickButtonModify(Consumer reload2) {
        companyList = new ArrayList<Company>(List.of(daoCompany.findAll(Utils.COMPANY_FILE)));
        int indexOfCompanyInList = companyList.indexOf(company);
        try {
            companyList.get(indexOfCompanyInList).setName(addCompanyForm.getTextFieldName().getText());
            companyList.get(indexOfCompanyInList).setYearlyIncomes(Double.valueOf(addCompanyForm.getTextFieldYearlyIncomes().getText()));

            modifyCompanyInClientList(companyList.get(indexOfCompanyInList));
            daoCompany.saveAll(Utils.COMPANY_FILE, companyList.toArray(new Company[companyList.size()]));
            reload.accept(null);
            reload2.accept(null);
        } catch (Exception e) {
            com.javafee.java.lessons.lesson12.view.Utils.displayPopup("Wrong input in field age or wage", "Error",
                    JOptionPane.ERROR_MESSAGE, addCompanyForm.getFrame());
        }
    }

    public void delete(Consumer reload, Consumer reload2, Company company){
        this.reload = reload;
        companyList = new ArrayList<Company>(List.of(daoCompany.findAll(Utils.COMPANY_FILE)));
        companyList.remove(company);
        deleteCompanyInClientList(company);
        daoCompany.saveAll(Utils.COMPANY_FILE, companyList.toArray(new Company[companyList.size()]));
        reload.accept(null);
        reload2.accept(null);
    }

    private void modifyCompanyInClientList(Company company) {
        int indexCompanyInList = 0;
        DAO<Client[]> daoClient =  new DAO<>();
        List<Client> clientList = new ArrayList<Client>(List.of(daoClient.findAll(Utils.CLIENT_FILE)));
        if (!(clientList == null || clientList.isEmpty())) {
            for (Client client: clientList) {
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
        DAO<Client[]> daoClient =  new DAO<>();
        List<Client> clientList = new ArrayList<Client>(List.of(daoClient.findAll(Utils.CLIENT_FILE)));
        if (!(clientList == null || clientList.isEmpty())) {
            for (Client client: clientList) {
                if (!(client.getCompanyList() == null || client.getCompanyList().isEmpty())){
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

    private void init(){
        addCompanyForm.getFrame().setVisible(true);
    }
}
