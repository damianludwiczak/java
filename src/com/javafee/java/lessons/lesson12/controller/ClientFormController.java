package com.javafee.java.lessons.lesson12.controller;

import com.javafee.java.lessons.lesson12.model.domain.Client;
import com.javafee.java.lessons.lesson12.model.domain.Company;
import com.javafee.java.lessons.lesson12.model.repository.DAO;
import com.javafee.java.lessons.lesson12.service.CompanyService;
import com.javafee.java.lessons.lesson12.service.Utils;
import com.javafee.java.lessons.lesson12.view.AddClientForm;
import com.javafee.java.lessons.lesson12.view.model.CompanyTableModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class ClientFormController {
    private CompanyService companyService;
    private AddClientForm addClientForm;
    private List<Client> clientList = new ArrayList<>();
    private Client client;
    private Consumer reload;
    private DAO<Client[]> dao = new DAO<>();
    private ActionListener addActionListener = e -> onClickButtonAdd();
    private ActionListener modifyActionListener = e -> onClickButtonModify();



    public ClientFormController() {
        companyService = new CompanyService();
        addClientForm = new AddClientForm();
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

    private void onClickButtonAdd() {
        clientList = new ArrayList<Client>(List.of(dao.findAll(Utils.CLIENT_FILE)));

        String name = addClientForm.getTextFieldName().getText();
        String surname = addClientForm.getTextFieldSurname().getText();
        String nationality = addClientForm.getTextFieldNationality().getText();
        Integer age;
        Double wage;
        try {
            age = Integer.valueOf(addClientForm.getTextFieldAge().getText());
            wage = Double.valueOf(addClientForm.getTextFieldWage().getText());

        } catch (NumberFormatException e ){
            age = 0;
            wage = 0.0;
        }

        Client newClient = new Client(name, surname, nationality, age, wage, null);
        newClient.setCompanyList(addCompanies(newClient));

        clientList.add(newClient);
        dao.saveAll(Utils.CLIENT_FILE, clientList.toArray(new Client[clientList.size()]));
        reload.accept(null);
    }

    private void onClickButtonModify() {
        clientList = new ArrayList<Client>(List.of(dao.findAll(Utils.CLIENT_FILE)));
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

        dao.saveAll(Utils.CLIENT_FILE, clientList.toArray(new Client[clientList.size()]));
        reload.accept(null);
    }

    public void delete(Consumer reload, Client client) {
        this.reload = reload;
        clientList = new ArrayList<Client>(List.of(dao.findAll(Utils.CLIENT_FILE)));
        clientList.remove(client);
        removeFromCompanyList(client);
        dao.saveAll(Utils.CLIENT_FILE, clientList.toArray(new Client[clientList.size()]));
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
            selectedIndex.add(((CompanyTableModel)addClientForm.getTableCompany().getModel()).getCompanies().indexOf(company));
        addClientForm.getTableCompany().removeRowSelectionInterval(0,((CompanyTableModel)addClientForm.getTableCompany().getModel()).getCompanies().size() - 1);
        for(int i = 0; i < selectedIndex.size(); i++)
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
        DAO<Company[]> daoCompany = new DAO<>();
        List<Company> companyList = new ArrayList<Company>(List.of(daoCompany.findAll(Utils.COMPANY_FILE)));
        for (Company company: companyList)
            company.getClientList().remove(newClient);
        daoCompany.saveAll(Utils.COMPANY_FILE, companyList.toArray(new Company[companyList.size()]));
    }

    private List<Company> addCompanies(Client newClient) {
        DAO<Company[]> daoCompany = new DAO<>();
        List<Company> listCompaniesToAdd = new ArrayList<>();
        int[] selectedIndex = addClientForm.getTableCompany().getSelectedRows();
        if (selectedIndex != null) {
            for (int i = 0; i < selectedIndex.length; i++) {
                int index = addClientForm.getTableCompany().convertRowIndexToModel(selectedIndex[i]);
                List<Client> listClients = ((CompanyTableModel) addClientForm.getTableCompany().getModel()).getCompany(index).getClientList();
                if (listClients.isEmpty()) {
                    listClients.add(newClient);
                } else if (listClients.contains(newClient)) {
                    int indexInList = listClients.indexOf(newClient);
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
        daoCompany.saveAll(Utils.COMPANY_FILE, listCompanyToSave.toArray(new Company[listCompanyToSave.size()]));

        return listCompaniesToAdd;
    }

    private void updateData() {
        ((CompanyTableModel) addClientForm.getTableCompany().getModel()).reload();
    }
}
