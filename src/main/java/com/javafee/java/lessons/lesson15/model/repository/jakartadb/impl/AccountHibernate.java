package com.javafee.java.lessons.lesson15.model.repository.jakartadb.impl;

import com.javafee.java.lessons.lesson15.model.entity.Account;
import com.javafee.java.lessons.lesson15.model.repository.jakartadb.HibernateConfig;

import java.util.List;
import java.util.stream.Collectors;

public class AccountHibernate extends HibernateConfig<Account> {
    @Override
    public void saveAll(List<Account> data) {
        getSession().getTransaction().begin();
        for (Account account : data)
            getSession().save(account);
        getSession().getTransaction().commit();
    }

    @Override
    public List<Account> findByFilter(Account account) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return (List<Account>) getSession().createQuery("from Account").stream().collect(Collectors.toList());
    }
}
