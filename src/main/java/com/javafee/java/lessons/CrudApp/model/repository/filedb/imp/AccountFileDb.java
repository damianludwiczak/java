package com.javafee.java.lessons.CrudApp.model.repository.filedb.imp;

import com.javafee.java.lessons.CrudApp.model.domain.Account;
import com.javafee.java.lessons.CrudApp.model.repository.filedb.FileDb;

import java.util.List;

public class AccountFileDb extends FileDb<Account> {
    public AccountFileDb(String path) {
        super(path);
    }

    @Override
    public List<Account> findByFilter(Account account) {
        return null;
    }
}
