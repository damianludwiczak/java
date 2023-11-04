package com.javafee.java.lessons.CrudApp;

import com.javafee.java.lessons.CrudApp.controller.LoginController;
import com.javafee.java.lessons.CrudApp.model.domain.Account;
import com.javafee.java.lessons.CrudApp.model.domain.Client;
import com.javafee.java.lessons.CrudApp.model.domain.Company;
import com.javafee.java.lessons.CrudApp.model.repository.Dao;
import com.javafee.java.lessons.CrudApp.model.repository.filedb.imp.AccountFileDb;
import com.javafee.java.lessons.CrudApp.model.repository.filedb.imp.ClientFileDb;
import com.javafee.java.lessons.CrudApp.model.repository.filedb.imp.CompanyFileDb;
import com.javafee.java.lessons.CrudApp.model.repository.jdbcdb.impl.AccountJdbcDb;
import com.javafee.java.lessons.CrudApp.model.repository.jdbcdb.impl.ClientJdbcDb;
import com.javafee.java.lessons.CrudApp.model.repository.jdbcdb.impl.CompanyJdbcDb;
import com.javafee.java.lessons.CrudApp.service.Utils;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        feedAccount();
        feedClient();
        feedCompany();
        LoginController.getInstance().control();
    }

    public static void feedAccount() {
        Dao<Account> fileDb = new AccountJdbcDb(); //  new AccountFileDb(Utils.ACCOUNT_FILE); //
        List<Account> accountList = fileDb.findAll();

        if (Objects.isNull(accountList) || accountList.size() == 0) {
            Account[] arr = {new Account(1, "test", "admin123"),
                    new Account(2, "jkowalski","admin123"),
                    new Account(3,"anowak","admin123"),
                    new Account(4,"admin", "admin123")};
            fileDb.saveAll(List.of(arr));

            accountList = fileDb.findAll();
            System.out.println(accountList.size() + " accounts fed successfully");
        }
    }

    public static void feedClient() {
        Dao<Client> fileDb = new ClientJdbcDb(); // new ClientFileDb(Utils.CLIENT_FILE); //
        List<Client> clientList = fileDb.findAll();

        if (Objects.isNull(clientList) || clientList.size() == 0) {
            Client[] arr = {new Client("Andrzej", "Kosiński", 1,"Polish", 30, 6500.0, null),
                    new Client("Marta", "Skupień", 2,"Polish", 25, 24000.0, null),
                    new Client("Andrew", "Roberts",3,  "US", 32, 4500.0, null),
                    new Client("Amhad", "Yossi", 4, "India", 31, 40000.0, null)};
            fileDb.saveAll(List.of(arr));

            clientList = fileDb.findAll();
            System.out.println(clientList.size() + " clients fed successfully");
        }
    }

    public static void feedCompany() {
        Dao<Company> fileDb = new CompanyJdbcDb(); // new CompanyFileDb(Utils.COMPANY_FILE); //
        List<Company> companiesList = fileDb.findAll();

        if (Objects.isNull(companiesList) || companiesList.size() == 0) {
            Company[] arr = { new Company("aaa", 1, 250000.0),
                    new Company("bbb", 2, 350000.0),
                    new Company("ccc", 3,450000.0),
                    new Company( "ddd", 4,550000.0)};
            fileDb.saveAll(List.of(arr));

            companiesList = fileDb.findAll();
            System.out.println(companiesList.size() + " company  fed successfully");
        }
    }
}
