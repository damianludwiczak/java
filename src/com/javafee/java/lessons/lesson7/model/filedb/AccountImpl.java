package com.javafee.java.lessons.lesson7.model.filedb;

import com.javafee.java.lessons.lesson7.model.Account;
import com.javafee.java.lessons.lesson7.model.memodb.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountImpl implements Account {
    private User user;
    private FileService fileService = new FileService();
    private MapperService mapperService = new MapperService();
    private double balance;
    private List<Transaction> transactionList = new ArrayList<>();
    private List<Deposit> deposits = new ArrayList<>();

    public AccountImpl(double balance, User user) {
        this.user = user;
        this.transactionList = initFile();
        if (!transactionList.isEmpty()) {
            for (Transaction t : transactionList) {
                if (t.getUserID() == user.getId()) {
                    this.balance += t.getAmount();
                }
            }
        } else
            this.balance = balance;
    }

    public void transferMoney(double amount) {
        setBalance(getBalance() + amount);
        transactionList.add(new Transaction(amount, getBalance() - amount, getBalance(), user.getId()));
        reloadFile();
    }

    public boolean withdrawMoney(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            transactionList.add(new Transaction(getBalance() - (getBalance() + amount), getBalance() + amount, getBalance(), user.getId()));
            reloadFile();
            return true;
        } else
            return false;
    }

    public boolean deposit(double amount, int userID) {
        double percentage = 0.01;
        if (getBalance() >= amount) {
            Deposit deposit = new Deposit(userID, amount, percentage);
            deposits.add(deposit);
            setBalance(getBalance() - amount);
            return true;
        } else
            return false;
    }
    public List<Deposit> printDeposits(int userID) {
        return deposits.stream().filter(e -> userID == e.getUserID()).toList();
    }

    public boolean finishDeposit(int depositIndex) {
        if (depositIndex >= 0 && depositIndex <= deposits.size() - 1) {
            double amount = deposits.get(depositIndex).getBalance();
            setBalance(getBalance() + amount);
            deposits.remove(depositIndex);
            return true;
        } else
            return false;
    }

    private void reloadFile() {
        try {
            fileService.save(mapperService.to(transactionList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Transaction> initFile() {
        try {
            return mapperService.from(fileService.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
