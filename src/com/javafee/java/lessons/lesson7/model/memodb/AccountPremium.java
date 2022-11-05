package com.javafee.java.lessons.lesson7.model.memodb;

import com.javafee.java.lessons.lesson7.model.memodb.User;

public class AccountPremium extends AccountImpl {
    public AccountPremium(double balance, User user) {
        super(balance, user);
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
