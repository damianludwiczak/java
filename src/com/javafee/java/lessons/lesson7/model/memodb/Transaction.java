package com.javafee.java.lessons.lesson7.model.memodb;

public class Transaction {
    private Double amount;
    private Double balanceBefore;
    private Double balanceAfter;

    public Transaction(Double amount, Double balanceBefore, Double balanceAfter) {
        this.amount = amount;
        this.balanceBefore = balanceBefore;
        this.balanceAfter = balanceAfter;
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
        return amount + "," + balanceBefore + "," + balanceAfter;
    }
}
