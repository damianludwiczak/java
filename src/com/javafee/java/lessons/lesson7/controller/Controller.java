package com.javafee.java.lessons.lesson7.controller;

import com.javafee.java.lessons.lesson7.model.Account;
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
            view.print("zalogowano");
            user = userService.get(user);
            Account account = new AccountImpl(0, user);
            mainMenu(user, account);
            System.out.println(account.getBalance() + " aaaa");
        } else
            view.print("Błędne dane");
    }

    private static void register() throws IOException {
        String login = view.getInputString("login");
        String password = view.getInputString("password");;
        User user = new User(login, password);
        if (userService.register(user)) {
            view.print("Zarejestrowano");
            entranceMenu();
        } else {
            view.print("Użytkownik o takim loginie istnieje");
        }
    }

    private static void entranceMenu() throws IOException {
        String inputString = view.getInputString("KONTO BANKOWE\n1 - logowanie\n2 - rejestraacja");
        switch (inputString){
            case "1" -> login();
            case "2" -> register();
            default -> view.print("Niewłaściwy wybór");
        }
    }

    private static String printMenu() {
        return  view.getInputString("Menu:\n1 - wypłata\n2 - wpłata\n3 - transakcje\n4 - saldo\nexit - wyjście\nProvide choice:");
    }

    private static void printListTransaction(List<Transaction> transactionList, String userId) {
        System.out.println("Lista transakcji");
        for (Transaction trans : transactionList)
            if (trans.getUserID().equals(userId))
                System.out.println(trans);
    }

    private static void mainMenu(User user, Account account) throws IOException {
        System.out.println("aaa");
        System.out.println(user.toString());
        String choice = printMenu();
        while (!choice.equals("exit")) {
            switch (choice) {
                case "1" -> view.print(account.withdrawMoney(view.getInputDouble("Podaj kwote wypłaty")) ?
                                                                            "Wypłacono środki" : "Nie wystarczające środki");
                case "2" -> account.transferMoney(view.getInputDouble("Podaj kwote wpłaty"));
                case "3" -> printListTransaction(account.getTransactionList(), user.getId());
                case "4" -> view.print("Aktualne saldo " + String.valueOf(account.getBalance()));
                default -> view.print("Błędny wybór");
            }
            choice = printMenu();
        }
    }
}
