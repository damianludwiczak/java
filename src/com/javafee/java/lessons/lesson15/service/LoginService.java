package com.javafee.java.lessons.lesson15.service;

import com.javafee.java.lessons.lesson15.model.domain.Account;
import com.javafee.java.lessons.lesson15.model.repository.DAO;

import java.util.List;

public class LoginService {
    public DAO<Account[]> accountDao;

    public LoginService() {
        accountDao = new DAO<>();
    }

    public boolean authenticate(String login, String password) {
        for (Account account : List.of(accountDao.findAll(Utils.ACCOUNT_FILE)))
            if (account.getLogin().equals(login)
                    && account.getPassword().equals(Utils.createMd5(password)))
                return true;
        return false;
    }
}
