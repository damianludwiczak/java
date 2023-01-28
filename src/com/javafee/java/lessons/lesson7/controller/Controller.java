package com.javafee.java.lessons.lesson7.controller;

import com.javafee.java.lessons.lesson7.model.Account;
import com.javafee.java.lessons.lesson7.model.filedb.AccountImpl;
import com.javafee.java.lessons.lesson7.model.filedb.AccountPremium;
import com.javafee.java.lessons.lesson7.model.filedb.User;
import com.javafee.java.lessons.lesson7.model.filedb.UserService;
import com.javafee.java.lessons.lesson7.model.memodb.Transaction;
import com.javafee.java.lessons.lesson7.view.View;
import com.javafee.java.lessons.lesson7.view.impl.ViewImpl;

import java.io.IOException;
import java.util.List;

public class Controller {
    private static View view = new ViewImpl();
    private static UserService userService = new UserService();

    public void run() {
        try {
            entranceMenu();
        } catch (Exception e) {
            view.print("Something went wrong");
        }
    }

    private void login() throws IOException, NoSuchFieldException {
        String login = view.getInputString("login");
        String password = view.getInputString("password");
        User user = new User(login, password);
        if (userService.signIn(user)) {
            view.print("Logged");
            user = userService.get(user);
            Account account = user.getAccountType().equalsIgnoreCase("PREMIUM") ? new AccountPremium(0, user) :
                    new AccountImpl(0, user);
            mainMenu(user, account);
        } else {
            view.print("Wrong password or user does not exist");
            entranceMenu();
        }
    }

    private void register() throws IOException, NoSuchFieldException {
        String login = view.getInputString("login");
        String password = view.getInputString("password");
        String accountType = view.getInputString("Account Type: Standard / Premium");
        User user = new User(login, password, accountType);
        if (userService.register(user)) {
            view.print("User has been registered");
            entranceMenu();
        } else {
            view.print("User is exists");
            entranceMenu();
        }
    }

    private void entranceMenu() throws IOException, NoSuchFieldException {
        String inputString = view.getInputString("BANK ACCOUNT\n1 - Login\n2 - Register");
        switch (inputString) {
            case "1" -> login();
            case "2" -> register();
            default -> view.print("Wrong choice");
        }
    }

    private static String printMenu() {
        return view.getInputString("Menu:\n1 - Withdraw\n2 - Transfer\n3 - Transactions\n4 - Balance\n5 - Open Deposit\n" +
                "6 - Close deposit\n7 - Print deposits\nExit" + "\nProvide choice:");
    }

    private static void printListTransaction(List<Transaction> transactionList, int userId) {
        System.out.println("Transactions list");
        for (Transaction trans : transactionList)
            if (trans.getUserID() == (userId))
                System.out.println(trans.printable());
    }

    private void mainMenu(User user, Account account) throws IOException, NoSuchFieldException {
        String choice = printMenu();
        while (!choice.equals("exit")) {
            try {
                switch (choice) {
                    case "1" -> view.print(account.withdrawMoney(view.getInputDouble("Withdraw\nAmount: ")) ?
                            "Withdraw successful" : "Not enough founds");
                    case "2" -> account.transferMoney(Double.parseDouble(view.getInputString("Transfer\nAmount")));
                    case "3" -> printListTransaction(account.getTransactionList(), user.getId());
                    case "4" -> view.print("Balance" + String.valueOf(account.getBalance()));
                    case "5" -> {
                        boolean result = account.deposit(view.getInputDouble("Amount"), user.getId());
                        view.print(result ? "New deposit has been created" : "Something wrong");
                    }
                    case "6" -> {
                        boolean result = account.finishDeposit(view.getInputInteger("Which deposit do You want to close?") - 1);
                        view.print(result ? "Deposit has been closed" : "Something wrong");
                    }
                    case "7" -> account.printDeposits(user.getId()).forEach(System.out::println);
                    default -> view.print("Wrong choice");
                }
                choice = printMenu();
            } catch (Exception e) {
                view.print("Something went wrong: " + e.getMessage());
            }
        }
        entranceMenu();
    }
}
