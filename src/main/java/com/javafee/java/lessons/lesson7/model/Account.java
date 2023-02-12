package com.javafee.java.lessons.lesson7.model;

import com.javafee.java.lessons.lesson7.model.filedb.Deposit;
import com.javafee.java.lessons.lesson7.model.memodb.Transaction;

import java.util.List;

public interface Account {

    boolean deposit(double amount, int userID);

    List<Deposit> printDeposits(int userID);

    boolean finishDeposit(int depositIndex);

    void transferMoney(double amount);

    boolean withdrawMoney(double amount);

    List<Transaction> getTransactionList();

    double getBalance();

    void setBalance(double balance);
}
