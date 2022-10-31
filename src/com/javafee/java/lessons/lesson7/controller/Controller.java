package com.javafee.java.lessons.lesson7.controller;

import com.javafee.java.lessons.lesson7.model.Account;
import com.javafee.java.lessons.lesson7.model.filedb.User;
import com.javafee.java.lessons.lesson7.model.filedb.AccountImpl;
import com.javafee.java.lessons.lesson7.model.filedb.AccountPremium;
import com.javafee.java.lessons.lesson7.model.memodb.Transaction;
import com.javafee.java.lessons.lesson7.view.View;
import com.javafee.java.lessons.lesson7.view.impl.ViewImpl;

import java.util.List;


public class Controller {
    private View view = new ViewImpl();
    private Account account;

    public void run() {
        String accountType = view.getInputString("Jakie konto chciałbyś założyć? PREMIUM/STANDARD");
        User user = new User(1, "damian123", "damian1234");
        account = accountType.equalsIgnoreCase("PREMIUM") ? new AccountPremium(0, user) : new AccountImpl(0, user);
        view.print("Menu:\n1 - wypłata\n2 - wpłata\n3 - transakcje\nexit - wyjście");
        String choice = view.getInputString("Provide choice:");
        while (!choice.equals("exit")) {
            switch (choice) {
                case "1":
                    view.print(account.withdrawMoney(view.getInputDouble("Podaj kwote wypłaty")) ?
                            "Wypłacono środki" : "Nie wystarczające środki");
                    view.print("Aktualne saldo: " + account.getBalance());
                    break;
                case "2":
                    account.transferMoney(view.getInputDouble("Podaj kwote wpłaty"));
                    view.print("Aktualne saldo: " + account.getBalance());
                    break;
                case "3":
                    System.out.println("Lista transakcji");
                    List<Transaction> transactionList = account.getTransactionList();
                    for (Transaction trans : transactionList)
                        System.out.println(trans);
                    break;
                case "exit":
                    view.print("Wyjście z programu");
                    break;
                default:
                    view.print("Błędny wybór");
                    System.out.println();
                    System.out.println();
            }
            view.print("Menu:\n1 - wypłata\n2 - wpłata\n3 - transakcje\nexit - wyjście");
            choice = view.getInputString("Provide choice:");
        }
    }
}
