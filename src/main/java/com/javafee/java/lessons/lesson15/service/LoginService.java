package com.javafee.java.lessons.lesson15.service;

import com.javafee.java.lessons.lesson15.model.Account;


public class LoginService {
    public AccountFetcher accountFetcher;

    public LoginService() {
        accountFetcher = new AccountFetcher();
    }
    public boolean authenticate(String login, String password) {
        for (Account account : accountFetcher.findAll())
            if (account.getLogin().equals(login) 
                    && Utils.createMd5(account.getPassword()).equals(Utils.createMd5(password)))
                return true;
        return false;
    }
}
