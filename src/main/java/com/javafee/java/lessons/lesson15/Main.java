package com.javafee.java.lessons.lesson15;

import com.javafee.java.lessons.lesson15.controller.LoginController;
import com.javafee.java.lessons.lesson15.model.Account;
import com.javafee.java.lessons.lesson15.model.Client;
import com.javafee.java.lessons.lesson15.model.Company;
import com.javafee.java.lessons.lesson15.service.AccountFetcher;
import com.javafee.java.lessons.lesson15.service.ClientFetcher;
import com.javafee.java.lessons.lesson15.service.CompanyFetcher;
import com.javafee.java.lessons.lesson15.service.Utils;

import javax.swing.*;
import java.time.LocalDateTime;
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
        AccountFetcher accountFetcher = new AccountFetcher();
        List<Account> accountList = accountFetcher.findAll();

        if (Objects.isNull(accountList) || accountList.size() == 0) {
            Account[] arr = {new Account(1, "test", Utils.createMd5("admin123"), LocalDateTime.now(), null),
                    new Account(2, "jkowalski", Utils.createMd5("admin123"), LocalDateTime.now(), null),
                    new Account(3,"anowak", Utils.createMd5("admin123"), LocalDateTime.now(), null),
                    new Account(4,"admin", Utils.createMd5("admin123"), LocalDateTime.now(), null)};
            accountFetcher.saveAll(List.of(arr));

            accountList = accountFetcher.findAll();
            System.out.println(accountList.size() + " accounts fed successfully");
        }
    }

    public static void feedClient() {
        ClientFetcher clientFetcher = new ClientFetcher();
        List<Client> clientList = clientFetcher.findAll();

        if (Objects.isNull(clientList) || clientList.size() == 0) {
            Client[] arr = {new Client(1,"Andrzej", "Kosiński", "Polish", 30, 6500.0, null),
                    new Client(2,"Marta", "Skupień", "Polish", 25, 24000.0, null),
                    new Client(3,"Andrew", "Roberts",  "US", 32, 4500.0, null),
                    new Client(4,"Amhad", "Yossi",  "India", 31, 40000.0, null)};
            clientFetcher.saveAll(List.of(arr));

            clientList = clientFetcher.findAll();
            System.out.println(clientList.size() + " clients fed successfully");
        }
    }

    public static void feedCompany() {
        CompanyFetcher companyFetcher = new CompanyFetcher();
        List<Company> companiesList = companyFetcher.findAll();

        if (Objects.isNull(companiesList) || companiesList.size() == 0) {
            Company[] arr = { new Company(1,"aaa", 250000.0),
                    new Company(2,"bbb", 350000.0),
                    new Company(3,"ccc",450000.0),
                    new Company(4, "ddd", 550000.0)};
            companyFetcher.saveAll(List.of(arr));

            companiesList = companyFetcher.findAll();
            System.out.println(companiesList.size() + " company  fed successfully");
        }
    }
}
