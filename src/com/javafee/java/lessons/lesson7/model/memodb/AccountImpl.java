package com.javafee.java.lessons.lesson7.model.memodb;

import com.javafee.java.lessons.lesson7.model.Account;
import com.javafee.java.lessons.lesson7.model.filedb.Deposit;

import java.util.ArrayList;
import java.util.List;

public class AccountImpl implements Account {
    private User user;
    private double balance;
    private List<Transaction> transactionList = new ArrayList<>();
    private List<Deposit> deposits = new ArrayList<>();

    public AccountImpl(double balance, User user) {
        this.balance = balance;
        this.user = user;
    }

    public boolean deposit(double amount, int userID) {
        double percentage = 0.01;
        if (getBalance() >= amount) {
            Deposit deposit = new Deposit(userID, amount, percentage);
            setBalance(getBalance() - amount);
            return true;
        } else
            return false;
    }

    public List<Deposit> printDeposits(int userID) {
        return deposits.stream().filter(e -> userID == e.getUserID()).toList();
    }

    public boolean finishDeposit(int depositIndex) {
        if (depositIndex > 0 && depositIndex <= deposits.size() - 1) {
            double amount = deposits.get(depositIndex).getBalance();
            setBalance(getBalance() + amount);
            deposits.remove(depositIndex);
            return true;
        } else
            return false;
    }

    public void transferMoney(double amount) {
        setBalance(getBalance() + amount);
        transactionList.add(new Transaction(amount, getBalance() - amount, getBalance(), user.getId()));
    }

    public boolean withdrawMoney(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            transactionList.add(new Transaction(getBalance() - (getBalance() + amount), getBalance() + amount, getBalance(), user.getId()));
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
