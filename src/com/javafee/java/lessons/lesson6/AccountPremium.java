package com.javafee.java.lessons.lesson6;

public class AccountPremium extends Account {
    public AccountPremium(double balance) {
        super(balance);
    }

    @Override
    public boolean withdrawMoney(double amount) {
        return super.withdrawMoney(amount * 1.005);
    }

    @Override
    public void transferMoney(double amount) {
        super.transferMoney(amount * 1.02);
    }
}
