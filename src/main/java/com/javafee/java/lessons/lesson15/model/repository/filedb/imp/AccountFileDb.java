package com.javafee.java.lessons.lesson15.model.repository.filedb.imp;

import com.javafee.java.lessons.lesson15.model.entity.Account;
import com.javafee.java.lessons.lesson15.model.repository.filedb.FileDb;

import java.util.List;

public class AccountFileDb extends FileDb<Account> {
    public AccountFileDb(String path) {
        super(path);
    }

    @Override
    public List<Account> findByFilter(Account account) {
        return null;
    }

    @Override
    public List<Account> findAll(Class<?> clazz) {
        return null;
    }
}
