package com.javafee.java.lessons.lesson15;

import com.javafee.java.lessons.lesson15.model.entity.Client;
import com.javafee.java.lessons.lesson15.model.entity.Company;
import com.javafee.java.lessons.lesson15.model.repository.jakartadb.HibernateConfig;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        HibernateConfig hibernateConfig = new HibernateConfig();
        Company company = new Company("Hendi", 100.0);
        Client client = new Client("Damian", "Ludwiczak", "polish", 31, 15000.0,
                new ArrayList<>());
        company.getClientList().add(client);
        client.getCompanyList().add(company);

        HibernateConfig.beginTransaction();
        HibernateConfig.getSession().save(client);
        HibernateConfig.commitTransaction();

//        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        feedAccount();
//        feedClient();
//        feedCompany();
//        LoginController.getInstance().control();
    }

//    public static void feedAccount() {
//        Dao<Account> fileDb = new AccountJdbcDb(); // new AccountFileDb(Utils.ACCOUNT_FILE); //
//        List<Account> accountList = fileDb.findAll();
//
//        if (Objects.isNull(accountList) || accountList.size() == 0) {
//            Account[] arr = {new Account(1, "test", Utils.createMd5("admin123"), LocalDateTime.now(), null),
//                    new Account(2, "jkowalski", Utils.createMd5("admin123"), LocalDateTime.now(), null),
//                    new Account(3, "anowak", Utils.createMd5("admin123"), LocalDateTime.now(), null),
//                    new Account(4, "admin", Utils.createMd5("admin123"), LocalDateTime.now(), null)};
//            fileDb.saveAll(List.of(arr));
//
//            accountList = fileDb.findAll();
//            System.out.println(accountList.size() + " accounts fed successfully");
//        }
//    }

//    public static void feedClient() {
//        Dao<Client> fileDb = new ClientJdbcDb(); //new ClientFileDb(Utils.CLIENT_FILE); //
//        List<Client> clientList = fileDb.findAll();
//
//        if (Objects.isNull(clientList) || clientList.size() == 0) {
//            Client[] arr = {new Client("Andrzej", "Kosiński", 1, "Polish", 30, 6500.0, null),
//                    new Client("Marta", "Skupień", 2, "Polish", 25, 24000.0, null),
//                    new Client("Andrew", "Roberts", 3, "US", 32, 4500.0, null),
//                    new Client("Amhad", "Yossi", 4, "India", 31, 40000.0, null)};
//            fileDb.saveAll(List.of(arr));
//
//            clientList = fileDb.findAll();
//            System.out.println(clientList.size() + " clients fed successfully");
//        }
//    }

//    public static void feedCompany() {
//        Dao<Company> fileDb = new CompanyFileDb(Utils.COMPANY_FILE); // new CompanyJdbcDb(); //
//        List<Company> companiesList = fileDb.findAll();
//
//        if (Objects.isNull(companiesList) || companiesList.size() == 0) {
//            Company[] arr = {new Company("aaa", 1, 250000.0),
//                    new Company("bbb", 2, 350000.0),
//                    new Company("ccc", 3, 450000.0),
//                    new Company("ddd", 4, 550000.0)};
//            fileDb.saveAll(List.of(arr));
//
//            companiesList = fileDb.findAll();
//            System.out.println(companiesList.size() + " company  fed successfully");
//        }
//    }
}