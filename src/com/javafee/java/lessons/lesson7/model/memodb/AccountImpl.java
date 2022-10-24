package com.javafee.java.lessons.lesson7.model.memodb;

import com.javafee.java.lessons.lesson7.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountImpl implements Account {
    private double balance;
    private List<Transaction> transactionList = new ArrayList<>();

    public AccountImpl(double balance) {
        this.balance = balance;
    }

    public void transferMoney(double amount) {
        setBalance(getBalance() + amount);
        transactionList.add(new Transaction(amount, getBalance() - amount, getBalance()));
    }

    public boolean withdrawMoney(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            transactionList.add(new Transaction(amount, getBalance() - amount, getBalance()));
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
