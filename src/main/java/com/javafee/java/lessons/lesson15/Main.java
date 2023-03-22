package com.javafee.java.lessons.lesson15;

import com.javafee.java.lessons.lesson15.controller.LoginController;
import com.javafee.java.lessons.lesson15.model.entity.Account;
import com.javafee.java.lessons.lesson15.model.entity.Client;
import com.javafee.java.lessons.lesson15.model.entity.Company;
import com.javafee.java.lessons.lesson15.model.repository.Dao;

import com.javafee.java.lessons.lesson15.model.repository.jakartadb.HibernateConfig;
import com.javafee.java.lessons.lesson15.model.repository.jakartadb.impl.AccountHibernate;
import com.javafee.java.lessons.lesson15.model.repository.jakartadb.impl.ClientHibernate;
import com.javafee.java.lessons.lesson15.model.repository.jakartadb.impl.CompanyHibernate;
import com.javafee.java.lessons.lesson15.service.Utils;

import javax.persistence.TemporalType;
import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//        Company company = new Company("Hendi", 1, 100.0);
//        Client client = new Client("Damian", "Ludwiczak", 1, "polish", 30 , 15000, null);
//        company.setClientList(List.of(client));
//        HibernateConfig.getSession().save(company);

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        feedAccount();
        feedClient();
        feedCompany();
        LoginController.getInstance().control();
    }

    public static void feedAccount() {
        Dao<Account> fileDb = new AccountHibernate(); // new AccountJdbcDb(); // new AccountFileDb(Utils.ACCOUNT_FILE); //
        List<Account> accountList = fileDb.findAll();

        if (Objects.isNull(accountList) || accountList.size() == 0) {
            Account[] arr = {
                    new Account(1, "test", "admin123", null, null),
                    new Account(2, "jkowalski", "admin123", null, null),
                    new Account(3, "anowak", "admin123", null, null),
                    new Account(4, "admin", "admin123", null, null),
                  };
            fileDb.saveAll(List.of(arr));

            accountList = fileDb.findAll();
            System.out.println(accountList.size() + " accounts fed successfully");
        }
    }

    public static void feedClient() {
        Dao<Client> fileDb = new ClientHibernate(); // new ClientJdbcDb(); //new ClientFileDb(Utils.CLIENT_FILE); //
        List<Client> clientList = fileDb.findAll();

        if (Objects.isNull(clientList) || clientList.size() == 0) {
            Client[] arr = {new Client("Andrzej", "Kosiński", 1, "Polish", 30, 6500.0, null),
                    new Client("Marta", "Skupień", 2, "Polish", 25, 24000.0, null),
                    new Client("Andrew", "Roberts", 3, "US", 32, 4500.0, null),
                    new Client("Amhad", "Yossi", 4, "India", 31, 40000.0, null)};
            fileDb.saveAll(List.of(arr));

            clientList = fileDb.findAll();
            System.out.println(clientList.size() + " clients fed successfully");
        }
    }

    public static void feedCompany() {
        Dao<Company> fileDb = new CompanyHibernate(); // new CompanyFileDb(Utils.COMPANY_FILE); // new CompanyJdbcDb(); //
        List<Company> companiesList = fileDb.findAll();

        if (Objects.isNull(companiesList) || companiesList.size() == 0) {
            Company[] arr = {new Company("aaa", 1, 250000.0),
                    new Company("bbb", 2, 350000.0),
                    new Company("ccc", 3, 450000.0),
                    new Company("ddd", 4, 550000.0)};
            fileDb.saveAll(List.of(arr));

            companiesList = fileDb.findAll();
            System.out.println(companiesList.size() + " company  fed successfully");
        }
    }
}