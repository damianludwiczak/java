package com.javafee.java.lessons.lesson7.model.filedb;

public class Deposit {
    private int userID;
    private double balance;
    private double percentage;

    public int getUserID() {
        return userID;
    }

    public Deposit(int userID, double balance, double percentage) {
        this.userID = userID;
        this.balance = balance + (balance * percentage);
        this.percentage = percentage;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "balance=" + balance +
                '}';
    }
}
