package com.javafee.java.lessons.lesson7.model.memodb;

public class Transaction {
    private Double amount;
    private Double balanceBefore;
    private Double balanceAfter;
    private String userID;

    public Transaction(Double amount, Double balanceBefore, Double balanceAfter, String userID) {
        this.amount = amount;
        this.balanceBefore = balanceBefore;
        this.balanceAfter = balanceAfter;
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getBalanceBefore() {
        return balanceBefore;
    }

    public void setBalanceBefore(Double balanceBefore) {
        this.balanceBefore = balanceBefore;
    }

    public Double getBalanceAfter() {
        return balanceAfter;
    }

    public void setBalanceAfter(Double balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    @Override
    public String toString() {
        return amount + "," + balanceBefore + "," + balanceAfter + "," + userID;
    }

    public String printable() {
        return amount + "," + balanceBefore + "," + balanceAfter;
    }
}
