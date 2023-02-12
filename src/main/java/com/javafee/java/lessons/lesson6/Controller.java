package com.javafee.java.lessons.lesson6;

import java.util.List;

public class Controller {
    private View view = new View();
    public void run() {
        String accountType = view.getInputString("Jakie konto chciałbyś założyć? PREMIUM/STANDARD");
        Account account;
        if (accountType.toUpperCase().equals("PREMIUM")) {
            account = new AccountPremium(0);
        } else {
            account = new Account(0);
        }

        view.printMessage("Menu:\n1 - wypłata\n2 - wpłata\n3 - transakcje\nexit - wyjście");
        String choice = view.getInputString("Provide choice:");
        while (!choice.equals("exit")) {
            switch (choice) {
                case "1":
                    if (account.withdrawMoney(view.getInputDouble("Podaj kwote wypłaty"))) {
                        view.printMessage("Wypłacono środki");
                    } else {
                        view.printMessage("Nie wystarczające środki");
                    }

                    view.printMessage("Aktualne saldo: " + account.getBalance());
                    break;
                case "2":
                    account.transferMoney(view.getInputDouble("Podaj kwote wpłaty"));
                    view.printMessage("Aktualne saldo: " + account.getBalance());
                    break;
                case "4":
                    System.out.println("Lista transakcji");
                    List<Transaction> transactionList = account.getTransactionList();
                    for (Transaction trans: transactionList) {
                        System.out.println(trans);
                    }
                    break;
                case "exit":
                    view.printMessage("Wyjście z programu");
                    break;
                default:
                    view.printMessage("Błędny wybór");
            }
            view.printMessage("Menu:\n1 - wypłata\n2 - wpłata\n3 - transakcje\nexit - wyjście");
            choice = view.getInputString("Provide choice:");
        }
    }
}
