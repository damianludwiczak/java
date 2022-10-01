package com.javafee.java.tasks.task2.customer.account;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        Customer customer = new Customer(account);
        String userAmount;
        double amount = 0;

        showMenu();

        String condition = scanner.nextLine();
        while (!condition.toUpperCase().equals("EXIT")) {
            switch (condition) {
                case "1":
                    System.out.println("Podaj kwote");
                    userAmount = scanner.nextLine();
                    if(isDouble(userAmount)) {
                        customer.withdrawMoney(Double.parseDouble(userAmount));
                    } else {
                        System.out.println("Podałeś błędną kwotę");
                    }
                    break;
                case "2":
                    System.out.println("Podaj kwote");
                    userAmount = scanner.nextLine();
                    if(isDouble(userAmount)) {
                        customer.depositMoney(Double.parseDouble(userAmount));
                    } else {
                        System.out.println("Podałeś błędną kwotę");
                    }
                    break;
                case "3":
                    System.out.println("Stan konta: " + customer.showCurrentAccountBalance());
                    break;
                case "4":
                    customer.showTransactions();
                    break;
                default:
                    System.out.println("Błędny wybór");
            }

            System.out.println("-------------------");
            showMenu();
            condition = scanner.nextLine();
        }
    }

    static boolean isDouble(String userAmount) {
        double number = 0;
        try {
            number = Double.parseDouble(userAmount);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void showMenu() {
        System.out.println("KONTO BANKOWE");
        System.out.println("1 - wypłata z konta");
        System.out.println("2 - wpłata na konto");
        System.out.println("3 - stan konta");
        System.out.println("4 - ostatnie transakcje");
        System.out.println("exit - wyjście z programu");
    }
}
