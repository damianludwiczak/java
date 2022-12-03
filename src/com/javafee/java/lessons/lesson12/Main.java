package com.javafee.java.lessons.lesson12;

import com.javafee.java.lessons.lesson12.controller.LoginController;
import com.javafee.java.lessons.lesson12.model.domain.Account;
import com.javafee.java.lessons.lesson12.model.domain.Client;
import com.javafee.java.lessons.lesson12.model.domain.Company;
import com.javafee.java.lessons.lesson12.model.repository.DAO;
import com.javafee.java.lessons.lesson12.service.Utils;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        feedAccount();
        feedClient();
        feedCompany();
        new LoginController().control();
    }

    public static void feedAccount() {
        DAO<Account[]> dao = new DAO<>();
        Account[] accountList = dao.findAll(Utils.ACCOUNT_FILE);

        if (Objects.isNull(accountList) || accountList.length == 0) {
            Account[] arr = {new Account("test", Utils.createMd5("admin123"), LocalDateTime.now(), null),
                    new Account("jkowalski", Utils.createMd5("admin123"), LocalDateTime.now(), null),
                    new Account("anowak", Utils.createMd5("admin123"), LocalDateTime.now(), null),
                    new Account("admin", Utils.createMd5("admin123"), LocalDateTime.now(), null)};
            dao.saveAll(Utils.ACCOUNT_FILE, arr);

            accountList = dao.findAll(Utils.ACCOUNT_FILE);
            System.out.println(accountList.length + " accounts fed successfully");
        }
    }

    public static void feedClient() {
        DAO<Client[]> dao = new DAO<>();
        Client[] clientList = dao.findAll(Utils.CLIENT_FILE);

        if (Objects.isNull(clientList) || clientList.length == 0) {
            Client[] arr = {new Client("Andrzej", "Kosiński", 10, "Polish", 30, 6500.0, null),
                    new Client("Marta", "Skupień", 11, "Polish", 25, 24000.0, null),
                    new Client("Andrew", "Roberts", 12, "US", 32, 4500.0, null),
                    new Client("Amhad", "Yossi", 13, "India", 31, 40000.0, null)};
            dao.saveAll(Utils.CLIENT_FILE, arr);

            clientList = dao.findAll(Utils.CLIENT_FILE);
            System.out.println(clientList.length + " clients fed successfully");
        }
    }

    public static void feedCompany() {
        DAO<Company[]> dao = new DAO<>();
        Company[] companiesList = dao.findAll(Utils.COMPANY_FILE);

        if (Objects.isNull(companiesList) || companiesList.length == 0) {
            Company[] arr = { new Company(1, "aaa", 250000.0),
                    new Company(2, "bbb", 350000.0),
                    new Company(3, "ccc", 450000.0),
                    new Company(4, "ddd", 550000.0)};
            dao.saveAll(Utils.COMPANY_FILE, arr);

            companiesList = dao.findAll(Utils.COMPANY_FILE);
            System.out.println(companiesList.length + " clients fed successfully");
        }
    }
}
