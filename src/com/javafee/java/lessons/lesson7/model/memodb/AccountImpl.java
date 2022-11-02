package com.javafee.java.lessons.lesson7.model.memodb;

import com.javafee.java.lessons.lesson7.model.Account;
import com.javafee.java.lessons.lesson7.model.filedb.User;

import java.util.ArrayList;
import java.util.List;

public class AccountImpl implements Account {
    private User user;
    private double balance;
    private List<Transaction> transactionList = new ArrayList<>();

    public AccountImpl(double balance, User user) {
        this.balance = balance;
        this.user = user;
    }

    public void transferMoney(double amount) {
        setBalance(getBalance() + amount);
        transactionList.add(new Transaction(amount, getBalance() + amount, getBalance(), user.getId()));
    }

    public boolean withdrawMoney(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            transactionList.add(new Transaction(amount, getBalance() - amount, getBalance(), user.getId()));
            return true;
        } else {
            return false;
        }
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
