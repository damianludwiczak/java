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

    private List<Company> companyList = new ArrayList<>();


    public ClientFormController() {
        companyService = new CompanyService();
        addClientForm = new AddClientForm();
    }

    public void control(Consumer reload, String context, Client client) { // reload / context / client
        init();
        this.reload = reload;
        addClientForm.getButtonAccept().removeActionListener(addActionListener);
        addClientForm.getButtonAccept().removeActionListener(modifyActionListener);
        if (context.equals("add")) {
            reloadEmptyForm();
            addClientForm.getButtonAccept().addActionListener(addActionListener);
        } else {
            this.client = client;
            reloadForm(this.client);
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
        Integer age = Integer.valueOf(addClientForm.getTextFieldAge().getText());
        Double wage = Double.valueOf(addClientForm.getTextFieldWage().getText());
        companyList = addCompanies();

        Client client = new Client(name, surname, nationality, age, wage, companyList);

        clientList.add(client);
        dao.saveAll(Utils.CLIENT_FILE, clientList.toArray(new Client[clientList.size()]));
        reload.accept(null);
    }

    private void onClickButtonModify() {
        clientList = new ArrayList<Client>(List.of(dao.findAll(Utils.CLIENT_FILE)));
        int numberToReplace = clientList.indexOf(client);
        clientList.remove(client);

        String name = addClientForm.getTextFieldName().getText();
        String surname = addClientForm.getTextFieldSurname().getText();
        String nationality = addClientForm.getTextFieldNationality().getText();
        Integer age = Integer.valueOf(addClientForm.getTextFieldAge().getText());
        Double wage = Double.valueOf(addClientForm.getTextFieldWage().getText());
        List<Company> companyList = addCompanies();
        Client modifyClient = new Client(name, surname, client.getId(), nationality, age, wage, companyList);

        clientList.add(numberToReplace, modifyClient);

        dao.saveAll(Utils.CLIENT_FILE, clientList.toArray(new Client[clientList.size()]));
        reload.accept(null);
    }

    public void delete(Consumer reload, Client client) {
        this.reload = reload;
        clientList = new ArrayList<Client>(List.of(dao.findAll(Utils.CLIENT_FILE)));
        clientList.remove(client);
        dao.saveAll(Utils.CLIENT_FILE, clientList.toArray(new Client[clientList.size()]));
        reload.accept(null);
    }

    private void reloadForm(Client client) {
        addClientForm.getTextFieldName().setText(client.getName());
        addClientForm.getTextFieldSurname().setText(client.getSurname());
        addClientForm.getTextFieldNationality().setText(client.getNationality());
        addClientForm.getTextFieldAge().setText(String.valueOf(client.getAge()));
        addClientForm.getTextFieldWage().setText(String.valueOf(client.getWage()));
        String companyName = !(client.getCompanyList() == null || client.getCompanyList().isEmpty()) ? client.getCompanyList().toString() : "";
        addClientForm.getTextFieldCompany().setText(companyName);
        selectCompanyIndex();
    }

    private void selectCompanyIndex() {
        List<Company> clientCompanyList = client.getCompanyList();
        List<Integer> selectedIndex = new ArrayList<>();
        for (Company company : clientCompanyList)
            selectedIndex.add(((CompanyTableModel)addClientForm.getTableCompany().getModel()).getCompanies().indexOf(company));

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

    private List<Company> addCompanies() {
        List<Company> listCompaniesToAdd = new ArrayList<>();
        int[] selectedIndex = addClientForm.getTableCompany().getSelectedRows();
        if (selectedIndex != null) {
            for (int i = 0; i < selectedIndex.length; i++) {
                int index = addClientForm.getTableCompany().convertRowIndexToModel(selectedIndex[i]);
                Company company = ((CompanyTableModel) addClientForm.getTableCompany().getModel()).getCompany(index);
                List<Client> listClients = company.getClientList();
                listClients.add(client);
                company.setClientList(listClients);
                listCompaniesToAdd.add(company);
            }
        }
        return listCompaniesToAdd;
    }
}
