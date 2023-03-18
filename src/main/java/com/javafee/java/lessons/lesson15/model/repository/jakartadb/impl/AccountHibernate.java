package com.javafee.java.lessons.lesson15.model.repository.jakartadb.impl;

import com.javafee.java.lessons.lesson15.model.entity.Account;
import com.javafee.java.lessons.lesson15.model.repository.jakartadb.HibernateConfig;

import java.util.List;

public class AccountHibernate extends HibernateConfig<Account> {

    @Override
    public List<Account> findByFilter(Account account) {
        return null;
    }
}
