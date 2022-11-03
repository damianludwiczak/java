package com.javafee.java.lessons.lesson7.controller;

import com.javafee.java.lessons.lesson7.model.Account;
import com.javafee.java.lessons.lesson7.model.filedb.AccountPremium;
import com.javafee.java.lessons.lesson7.model.filedb.User;
import com.javafee.java.lessons.lesson7.model.filedb.AccountImpl;
import com.javafee.java.lessons.lesson7.model.filedb.UserService;
import com.javafee.java.lessons.lesson7.model.memodb.Transaction;
import com.javafee.java.lessons.lesson7.view.View;
import com.javafee.java.lessons.lesson7.view.impl.ViewImpl;

import java.io.IOException;
import java.util.List;

public class Controller {
    private static View view = new ViewImpl();
    private static UserService userService = new UserService();
    private static User user;
    public static void run() throws IOException {
        entranceMenu();
    }

    private static void login() throws IOException {
        String login = view.getInputString("login");
        String password = view.getInputString("password");;
        User user = new User(login, password);
        if (userService.signIn(user)) {
            view.print("Logged");
            user = userService.get(user);
            Account account = user.getAccountType().equalsIgnoreCase("PREMIUM") ? new AccountPremium(0, user):
                                                                                        new AccountImpl(0, user);
            mainMenu(user, account);
        } else
            view.print("Wrong password or user does not exist");
    }

    private static void register() throws IOException {
        String login = view.getInputString("login");
        String password = view.getInputString("password");
        String accountType = view.getInputString("Acoount Type: Standard / Premium");
        User user = new User(login, password, accountType);
        if (userService.register(user)) {
            view.print("User has been registered");
            entranceMenu();
        } else {
            view.print("User not found");
        }
    }

    private static void entranceMenu() throws IOException {
        String inputString = view.getInputString("BANK ACCOUNT\n1 - Login\n2 - Register");
        switch (inputString){
            case "1" -> login();
            case "2" -> register();
            default -> view.print("Wrong choice");
        }
    }

    private static String printMenu() {
        return  view.getInputString("Menu:\n1 - Withdraw\n2 - Transfer\n3 - Transactions\n4 - Balance\nExit" +
                                                            "\nProvide choice:");
    }

    private static void printListTransaction(List<Transaction> transactionList, String userId) {
        System.out.println("Transactions list");
        for (Transaction trans : transactionList)
            if (trans.getUserID().equals(userId))
                System.out.println(trans);
    }

    private static void mainMenu(User user, Account account) throws IOException {
        String choice = printMenu();
        while (!choice.equals("exit")) {
            switch (choice) {
                case "1" -> view.print(account.withdrawMoney(view.getInputDouble("Withdraw\nAmount: ")) ?
                                                                            "Withdraw successful" : "Not enough founds");
                case "2" -> account.transferMoney(view.getInputDouble("Transfer\nAmount"));
                case "3" -> printListTransaction(account.getTransactionList(), user.getId());
                case "4" -> view.print("Balance" + String.valueOf(account.getBalance()));
                default -> view.print("Wrong choice");
            }
            choice = printMenu();
        }
    }
}
