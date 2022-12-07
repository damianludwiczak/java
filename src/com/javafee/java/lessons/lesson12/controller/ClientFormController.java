package com.javafee.java.lessons.lesson12.controller;

import com.javafee.java.lessons.lesson12.model.domain.Client;
import com.javafee.java.lessons.lesson12.model.domain.Company;
import com.javafee.java.lessons.lesson12.model.repository.DAO;
import com.javafee.java.lessons.lesson12.service.CompanyService;
import com.javafee.java.lessons.lesson12.service.Utils;
import com.javafee.java.lessons.lesson12.view.AddUserForm;


import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class ClientFormController {
    private CompanyService companyService;
    private AddUserForm addUserForm;
    private List<Client> clientList = new ArrayList<>();
    private Client client;
    private Consumer reload;
    private DAO<Client[]> dao = new DAO<>();
    private ActionListener addActionListener = e -> onClickButtonAdd();
    private ActionListener modifyActionListener = e -> onClickButtonModify();


    public ClientFormController() {
        companyService = new CompanyService();
        addUserForm = new AddUserForm();
    }

    public void control(Consumer reload, String context, Client client) { // reload / context / client
        init();
        this.reload = reload;
        addUserForm.getButtonAccept().removeActionListener(addActionListener);
        addUserForm.getButtonAccept().removeActionListener(modifyActionListener);
        if (context.equals("add")) {
            reloadEmptyForm();
            addUserForm.getButtonAccept().addActionListener(addActionListener);
        } else {
            this.client = client;
            reloadForm(this.client);
            addUserForm.getButtonAccept().addActionListener(modifyActionListener);
        }
    }

    private void init() {
        addUserForm.getFrame().setVisible(true);
    }

    private void onClickButtonAdd() {
        clientList = new ArrayList<Client>(List.of(dao.findAll(Utils.CLIENT_FILE)));
        String name = addUserForm.getTextFieldName().getText();
        String surname = addUserForm.getTextFieldSurname().getText();
        String nationality = addUserForm.getTextFieldNationality().getText();
        Integer age = Integer.valueOf(addUserForm.getTextFieldAge().getText());
        Double wage = Double.valueOf(addUserForm.getTextFieldWage().getText());
        Company company = companyService.findByName(addUserForm.getTextFieldCompany().getText());
        Client client = new Client(name, surname, nationality, age, wage, company);

        clientList.add(client);
        System.out.println("after add");
        clientList.forEach(System.out::println);
        System.out.println("----------");
        dao.saveAll(Utils.CLIENT_FILE, clientList.toArray(new Client[clientList.size()]));
        reload.accept(null);
    }

    private void onClickButtonModify() {
        clientList = new ArrayList<Client>(List.of(dao.findAll(Utils.CLIENT_FILE)));
        int numberToReplace = clientList.indexOf(client);
        clientList.remove(client);

        String name = addUserForm.getTextFieldName().getText();
        String surname = addUserForm.getTextFieldSurname().getText();
        String nationality = addUserForm.getTextFieldNationality().getText();
        Integer age = Integer.valueOf(addUserForm.getTextFieldAge().getText());
        Double wage = Double.valueOf(addUserForm.getTextFieldWage().getText());
        Company company = companyService.findByName(addUserForm.getTextFieldCompany().getText());
        Client modifyClient = new Client(name, surname, client.getId(), nationality, age, wage, company);

        clientList.add(numberToReplace, modifyClient);

        dao.saveAll(Utils.CLIENT_FILE, clientList.toArray(new Client[clientList.size()]));
        reload.accept(null);
    }

    public void delete(Consumer reload, Client client) {
        this.reload = reload;
        clientList = new ArrayList<Client>(List.of(dao.findAll(Utils.CLIENT_FILE)));
        System.out.println(client);
        clientList.remove(client);
        System.out.println("after delete");
        clientList.forEach(System.out::println);
        System.out.println("----------");
        dao.saveAll(Utils.CLIENT_FILE, clientList.toArray(new Client[clientList.size()]));
        reload.accept(null);
    }

    private void reloadForm(Client client) {
        addUserForm.getTextFieldName().setText(client.getName());
        addUserForm.getTextFieldSurname().setText(client.getSurname());
        addUserForm.getTextFieldNationality().setText(client.getNationality());
        addUserForm.getTextFieldAge().setText(String.valueOf(client.getAge()));
        addUserForm.getTextFieldWage().setText(String.valueOf(client.getWage()));
        String companyName = client.getCompany() == null ? "" : client.getCompany().getName();
        addUserForm.getTextFieldCompany().setText(companyName);
    }

    private void reloadEmptyForm() {
        addUserForm.getTextFieldName().setText(null);
        addUserForm.getTextFieldSurname().setText(null);
        addUserForm.getTextFieldNationality().setText(null);
        addUserForm.getTextFieldAge().setText(null);
        addUserForm.getTextFieldWage().setText(null);
        addUserForm.getTextFieldCompany().setText(null);
    }
}
