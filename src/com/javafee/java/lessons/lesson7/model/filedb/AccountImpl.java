package com.javafee.java.lessons.lesson7.model.filedb;

import com.javafee.java.lessons.lesson7.model.Account;
import com.javafee.java.lessons.lesson7.model.memodb.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountImpl implements Account {
    private FileService fileService = new FileService();
    private MapperService mapperService = new MapperService();
    private double balance;
    private List<Transaction> transactionList = new ArrayList<>();

    public AccountImpl(double balance) {
        this.transactionList = initFile();
        if (!transactionList.isEmpty())
            for (Transaction t : transactionList)
                this.balance += t.getAmount();
        else
            this.balance = balance;
    }

    public void transferMoney(double amount) {
        setBalance(getBalance() + amount);
        transactionList.add(new Transaction(amount, getBalance() - amount, getBalance()));
        reloadFile();
    }

    public boolean withdrawMoney(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            transactionList.add(new Transaction(amount, getBalance() - amount, getBalance()));
            reloadFile();
            return true;
        } else {
            return false;
        }
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
