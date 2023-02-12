package com.javafee.java.tasks.task2.customer.account;
import java.util.ArrayList;
public class Account {
    private double currentAccountBalance;
    ArrayList<String> transactionList = new ArrayList<>();
    public double getCurrentAccountBalance() {
        return currentAccountBalance;
    }
    public ArrayList<String> getTransactionList() {
        return transactionList;
    }
    public void setCurrentAccountBalance(double currentAccountBalance) {this.currentAccountBalance = currentAccountBalance;}
}
