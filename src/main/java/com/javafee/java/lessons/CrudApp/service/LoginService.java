package com.javafee.java.lessons.CrudApp.service;

import com.javafee.java.lessons.CrudApp.model.domain.Account;
import com.javafee.java.lessons.CrudApp.model.repository.Dao;
import com.javafee.java.lessons.CrudApp.model.repository.filedb.imp.AccountFileDb;
import com.javafee.java.lessons.CrudApp.model.repository.jdbcdb.impl.AccountJdbcDb;

public class LoginService {
    public Dao<Account> accountFileDb;

    public LoginService() {
        accountFileDb = new AccountFileDb(Utils.ACCOUNT_FILE); // new AccountJdbcDb(); //
    }
    public boolean authenticate(String login, String password) {
        for (Account account : accountFileDb.findAll())
            if (account.getLogin().equals(login) 
                    && Utils.createMd5(account.getPassword()).equals(Utils.createMd5(password)))
                return true;
        return false;
    }
}