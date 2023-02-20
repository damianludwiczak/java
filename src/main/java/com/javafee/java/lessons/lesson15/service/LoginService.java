package com.javafee.java.lessons.lesson15.service;

import com.javafee.java.lessons.lesson15.model.domain.Account;
import com.javafee.java.lessons.lesson15.model.repository.Dao;
import com.javafee.java.lessons.lesson15.model.repository.jdbcdb.impl.AccountJdbcDb;

public class LoginService {
    public Dao<Account> accountFileDb;

    public LoginService() {
        accountFileDb = new AccountJdbcDb(); // new FileDb<>(Utils.ACCOUNT_FILE);
    }

    public boolean authenticate(String login, String password) {
        for (Account account : accountFileDb.findAll())
            if (account.getLogin().equals(login) 
                    && Utils.createMd5(account.getPassword()).equals(Utils.createMd5(password)))
                return true;
        return false;
    }
}
// TODO: 16.02.2023