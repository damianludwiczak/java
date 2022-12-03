package com.javafee.java.lessons.lesson12.controller;

import com.javafee.java.lessons.lesson12.model.domain.Client;
import com.javafee.java.lessons.lesson12.model.domain.Company;
import com.javafee.java.lessons.lesson12.model.repository.DAO;
import com.javafee.java.lessons.lesson12.service.ClientService;
import com.javafee.java.lessons.lesson12.service.CompanyService;
import com.javafee.java.lessons.lesson12.service.Utils;
import com.javafee.java.lessons.lesson12.view.AddUserForm;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class ClientFormController {
    private CompanyService companyService;
    private ClientService clientService;
    private AddUserForm addUserForm;
    private List<Client> clientList = new ArrayList<>();
    private Consumer reload;

    public ClientFormController() {
        companyService = new CompanyService();
        clientService = new ClientService();
        addUserForm = new AddUserForm();
    }

    public void control(Consumer reload, String context, Client client) { // reload / context / client
        init();
        this.reload = reload;
        if (context.equals("add")) addUserForm.getButtonAccept().addActionListener(e -> onClickButtonAdd());
        else {
            reloadForm(client);
            addUserForm.getButtonAccept().addActionListener(e -> onClickButtonModify());
        }
    }

    private void init() {
        addUserForm.getFrame().setVisible(true);
    }

    private void onClickButtonModify() {
        String name = addUserForm.getTextFieldName().getText();
        String surname = addUserForm.getTextFieldSurname().getText();
        String nationality = addUserForm.getTextFieldNationality().getText();
        Integer age = Integer.valueOf(addUserForm.getTextFieldAge().getText());
        Double wage = Double.valueOf(addUserForm.getTextFieldWage().getText());
        Company company = companyService.findByName(addUserForm.getTextFieldCompany().getText());
        Client modifyClient = new Client(name, surname, id, nationality, age, wage, company);

        DAO<Client[]> dao = new DAO<>();
        clientList = new ArrayList<Client>(List.of(dao.findAll(Utils.CLIENT_FILE)));

        clientList.remove(client);
        clientList.add(modifyClient);

        dao.saveAll(Utils.CLIENT_FILE, clientList.toArray(new Client[0]));
        reload.accept(null);
    }

    private void reloadForm(Client client) {
        addUserForm.getTextFieldName().setText(client.getName());
        addUserForm.getTextFieldSurname().setText(client.getSurname());
        addUserForm.getTextFieldNationality().setText(client.getNationality());
        addUserForm.getTextFieldAge().setText(String.valueOf(client.getAge()));
        addUserForm.getTextFieldWage().setText(String.valueOf(client.getWage()));
        addUserForm.getTextFieldWage().setText(client.getCompany().getName());
    }

    private void onClickButtonAdd() {
        DAO<Client[]> dao = new DAO<>();
        clientList = new ArrayList<Client>(List.of(dao.findAll(Utils.CLIENT_FILE)));
//        DAO<Client[]> dao = new DAO<>();
//        clientList = List.of(dao.findAll(Utils.CLIENT_FILE));
        Integer id = clientService.findMaxId();
        String name = addUserForm.getTextFieldName().getText();
        String surname = addUserForm.getTextFieldSurname().getText();
        String nationality = addUserForm.getTextFieldNationality().getText();
        Integer age = Integer.valueOf(addUserForm.getTextFieldAge().getText());
        Double wage = Double.valueOf(addUserForm.getTextFieldWage().getText());
        Company company = companyService.findByName(addUserForm.getTextFieldCompany().getText());
        Client client = new Client(name, surname, id, nationality, age, wage, company);
        clientList.add(client);
//        dao.saveAll(Utils.CLIENT_FILE, (Client[]) clientList.toArray());
        dao.saveAll(Utils.CLIENT_FILE, clientList.toArray(new Client[0]));
        reload.accept(null);
    }
}
