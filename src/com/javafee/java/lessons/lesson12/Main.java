package com.javafee.java.lessons.lesson12;

import com.javafee.java.lessons.lesson12.controller.LoginController;
import com.javafee.java.lessons.lesson12.model.domain.Account;
import com.javafee.java.lessons.lesson12.model.repository.DAO;
import com.javafee.java.lessons.lesson12.service.Utils;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
//        Account account = new Account("test", Utils.createMd5("admin123"), LocalDateTime.now(), null);
//        Account[] arr = {account};
//        DAO<Account[]> dao = new DAO<>();
//        dao.saveAll(Utils.ACCOUNT_FILE, arr);
        new LoginController().control();
    }
}
