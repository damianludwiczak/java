package com.javafee.java.tasks.task2.customer.account;

public class Customer {
    Account account;
    public Customer(Account account) {
        this.account = account;
    }
    public void withdrawMoney(double amount) {
        if (amount <= 0) {
            System.out.println("Podano błędną kwotę");
        } else {
            if (amount <= account.getCurrentAccountBalance()) {
                System.out.printf("wypłacam %.2f$", amount);
                account.setCurrentAccountBalance(account.getCurrentAccountBalance() - amount);
                account.transactionList.add(account.getCurrentAccountBalance() + " wypłata " + amount);
                System.out.printf("\nAktualne saldo %.2f\n", account.getCurrentAccountBalance());
            } else {
                System.out.println("Nie wystarczające środki");
            }
        }
    }
    public void depositMoney(double amount) {
        if (amount <= 0) {
            System.out.println("Podano błędną kwotę");
        } else {
            System.out.printf("Wpłacono %.2f$", amount);
            account.setCurrentAccountBalance(account.getCurrentAccountBalance() + amount);
            account.transactionList.add(account.getCurrentAccountBalance() + " wpłata " + amount);
            System.out.printf("\nAktualne saldo %.2f\n", account.getCurrentAccountBalance());
        }
    }
    public void showTransactions() {
        for (String s : account.transactionList) { System.out.println(s);}
    }
    public double showCurrentAccountBalance() {
        return account.getCurrentAccountBalance();
    }
}
