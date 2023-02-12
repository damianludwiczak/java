package com.javafee.java.lessons.lesson15.service;

import com.javafee.java.lessons.lesson15.model.domain.Account;
import com.javafee.java.lessons.lesson15.model.repository.filedb.FileDb;

import java.util.List;

public class LoginService {
    public FileDb<Account[]> accountFileDb;

    public LoginService() {
        accountFileDb = new FileDb<>(Utils.ACCOUNT_FILE);
    }

    public boolean authenticate(String login, String password) {
        for (Account account : List.of(accountFileDb.findAll()))
            if (account.getLogin().equals(login)
                    && account.getPassword().equals(Utils.createMd5(password)))
                return true;
        return false;
    }
}
