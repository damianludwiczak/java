package com.javafee.java.lessons.CrudApp.controller;

import com.javafee.java.lessons.CrudApp.model.domain.Client;
import com.javafee.java.lessons.CrudApp.model.domain.Company;
import com.javafee.java.lessons.CrudApp.model.repository.Dao;
import com.javafee.java.lessons.CrudApp.model.repository.jdbcdb.impl.CompanyJdbcDb;
import com.javafee.java.lessons.CrudApp.model.repository.jdbcdb.impl.ClientJdbcDb;
import com.javafee.java.lessons.CrudApp.view.AddClientForm;
import com.javafee.java.lessons.CrudApp.view.ClientForm;
import com.javafee.java.lessons.CrudApp.view.model.CompanyTableModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;


public class ClientFormController {
    private AddClientForm addClientForm;
    private ClientForm clientForm;
    private List<Client> clientList = new ArrayList<>();
    private Client client;
    private Consumer reload;
    private Dao<Client> jdbcDbClient = new ClientJdbcDb(); // new ClientFileDb(Utils.CLIENT_FILE); //
    private Dao<Company> jdbcDbCompany = new CompanyJdbcDb(); // new CompanyFileDb(Utils.COMPANY_FILE); //
    private ActionListener addActionListener = e -> onClickButtonAdd();
    private ActionListener modifyActionListener = e -> onClickButtonModify();
    private static ClientFormController instance = null;


    private ClientFormController() {
        addClientForm = new AddClientForm();
        clientForm = new ClientForm();
    }

    public static ClientFormController getInstance() {
        if (Objects.isNull(instance))
            instance = new ClientFormController();
        return instance;
    }

    public void control(Consumer reload, String context, Client clientFromTable) { // reload / context / client
        init();
        this.reload = reload;
        addClientForm.getButtonAccept().removeActionListener(addActionListener);
        addClientForm.getButtonAccept().removeActionListener(modifyActionListener);
        updateData();
        if (context.equals("add")) {
            reloadEmptyForm();
            addClientForm.getButtonAccept().addActionListener(addActionListener);
        } else {
            this.client = clientFromTable;
            reloadForm(clientFromTable);
            addClientForm.getButtonAccept().addActionListener(modifyActionListener);
        }
    }

    private void init() {
        addClientForm.getFrame().setVisible(true);
    }

    private void close() {
        addClientForm.getFrame().setVisible(false);
    }

    private void onClickButtonAdd() {
        clientList = jdbcDbClient.findAll();

        String name = addClientForm.getTextFieldName().getText();
        String surname = addClientForm.getTextFieldSurname().getText();
        String nationality = addClientForm.getTextFieldNationality().getText();
        Integer age;
        Double wage;
        try {
            age = Integer.valueOf(addClientForm.getTextFieldAge().getText());
            wage = Double.valueOf(addClientForm.getTextFieldWage().getText());

        } catch (NumberFormatException e) {
            age = 0;
            wage = 0.0;
        }

        Client newClient = new Client(name, surname, nationality, age, wage, null);
        clientList.add(newClient);
        jdbcDbClient.saveAll(clientList);

        newClient.setCompanyList(addCompanies(newClient));

        jdbcDbClient.saveAll(clientList);
        close();
        reload.accept(null);
    }

    private void onClickButtonModify() {
        clientList = jdbcDbClient.findAll();
        int indexOfList = clientList.indexOf(client);

        clientList.get(indexOfList).setName(addClientForm.getTextFieldName().getText());
        clientList.get(indexOfList).setSurname(addClientForm.getTextFieldSurname().getText());
        clientList.get(indexOfList).setNationality(addClientForm.getTextFieldNationality().getText());

        try {
            clientList.get(indexOfList).setAge(Integer.valueOf(addClientForm.getTextFieldAge().getText()));
            clientList.get(indexOfList).setWage(Double.valueOf(addClientForm.getTextFieldWage().getText()));
        } catch (NumberFormatException e) {
            clientList.get(indexOfList).setAge(0);
            clientList.get(indexOfList).setWage(0.0);
        }
        removeFromCompanyList(clientList.get(indexOfList));
        List<Company> companyList = addCompanies(clientList.get(indexOfList));
        clientList.get(indexOfList).setCompanyList(companyList);

        jdbcDbClient.saveAll(clientList);
        close();
        reload.accept(null);
    }

    public void delete(Consumer reload, Client client) {
        this.reload = reload;
        clientList = jdbcDbClient.findAll();
        clientList.remove(client);
        removeFromCompanyList(client);
        jdbcDbClient.saveAll(clientList);
        reload.accept(null);
    }

    private void reloadForm(Client clientFromTable) {
        addClientForm.getTextFieldName().setText(clientFromTable.getName());
        addClientForm.getTextFieldSurname().setText(clientFromTable.getSurname());
        addClientForm.getTextFieldNationality().setText(clientFromTable.getNationality());
        addClientForm.getTextFieldAge().setText(String.valueOf(clientFromTable.getAge()));
        addClientForm.getTextFieldWage().setText(String.valueOf(clientFromTable.getWage()));
        String companyName = !(clientFromTable.getCompanyList() == null || clientFromTable.getCompanyList().isEmpty()) ? clientFromTable.getCompanyList().toString() : "";
        addClientForm.getTextFieldCompany().setText(companyName);
        if (!(clientFromTable.getCompanyList() == null || clientFromTable.getCompanyList().isEmpty()))
            selectCompanyIndex(clientFromTable.getCompanyList());
    }

    private void selectCompanyIndex(List<Company> clientCompanyList) {
        List<Integer> selectedIndex = new ArrayList<>();
        for (Company company : clientCompanyList)
            selectedIndex.add(((CompanyTableModel) addClientForm.getTableCompany().getModel()).getCompanies().indexOf(company));
        addClientForm.getTableCompany().removeRowSelectionInterval(0, ((CompanyTableModel) addClientForm.getTableCompany().getModel()).getCompanies().size() - 1);
        for (int i = 0; i < selectedIndex.size(); i++)
            addClientForm.getTableCompany().addRowSelectionInterval(selectedIndex.get(i), selectedIndex.get(i));
    }

    private void reloadEmptyForm() {
        addClientForm.getTextFieldName().setText(null);
        addClientForm.getTextFieldSurname().setText(null);
        addClientForm.getTextFieldNationality().setText(null);
        addClientForm.getTextFieldAge().setText(null);
        addClientForm.getTextFieldWage().setText(null);
        addClientForm.getTextFieldCompany().setText(null);
    }

    private void removeFromCompanyList(Client newClient) {
        List<Company> companyList = jdbcDbCompany.findAll();
        for (Company company : companyList)
            company.getClientList().remove(newClient);
        jdbcDbCompany.saveAll(companyList);
    }

    private List<Company> addCompanies(Client newClient) {
        List<Company> listCompaniesToAdd = new ArrayList<>();
        int[] selectedIndex = addClientForm.getTableCompany().getSelectedRows();
        if (selectedIndex != null) {
            for (int i = 0; i < selectedIndex.length; i++) {
                int index = addClientForm.getTableCompany().convertRowIndexToModel(selectedIndex[i]);
                List<Client> listClients = ((CompanyTableModel) addClientForm.getTableCompany().getModel()).getCompany(index).getClientList();
                if (listClients.isEmpty()) {
                    listClients.add(newClient);
                } else if (listClients.contains(newClient)) {
                    int indexInList = listClients.indexOf(newClient); // TODO: 18.02.2023  
                    listClients.remove(newClient);
                    listClients.add(indexInList, newClient);
                } else {
                    listClients.add(newClient);
                }
                ((CompanyTableModel) addClientForm.getTableCompany().getModel()).getCompany(index).setClientList(listClients);

                listCompaniesToAdd.add(((CompanyTableModel) addClientForm.getTableCompany().getModel()).getCompany(index));
            }
        }
        List<Company> listCompanyToSave = ((CompanyTableModel) addClientForm.getTableCompany().getModel()).getCompanies();
        jdbcDbCompany.saveAll(listCompanyToSave);

        return listCompaniesToAdd;
    }

    private void updateData() {
        ((CompanyTableModel) addClientForm.getTableCompany().getModel()).reload();
    }
}
