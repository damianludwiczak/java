package com.javafee.java.lessons.lesson6;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transactionList = new ArrayList<>();

    public void transferMoney(double amount) {
        setBalance(getBalance() + amount);
        transactionList.add(new Transaction(amount, getBalance() - amount, getBalance()));
    }

    public boolean withdrawMoney (double amount) {
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

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
