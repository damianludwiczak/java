package com.javafee.java.tasks.roczne_przychody;

import java.util.Scanner;

public class Przychody {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Program wyliczający sume, średnia, Twoich zarobków");
        System.out.println("Podaj liczbę miesięcy, z których program ma wyliczyć sumę i średnią");
        String monthsString = scanner.nextLine();
        int months = 1;
        if (StringToInteger(monthsString)) {
            months = Integer.parseInt(monthsString);
        } else {
            System.out.println("Nie podano liczby");
        }

        double sumOfSalaries = 0;
        double minSalary = 100000;
        double maxSalary = 0;
        String salaryString;
        double salary = 0;


        System.out.println("Program będzie prosił o podanie kolejnych kwot Twoich wypłat");

        for (int i = 0; i < months;) {
            System.out.println("Podaj kwotę");
            salaryString = scanner.nextLine();
            if (StringToInteger(salaryString)) {
                salary = Double.parseDouble(salaryString);
                sumOfSalaries += salary;

                if (salary > maxSalary) {
                    maxSalary = salary;
                }

                if (salary < minSalary) {
                    minSalary = salary;
                }


                i++;
            } else {
                System.out.println("Podano błędne dane, kwota nie zostanie dodana");
            }

        }

        System.out.println("Suma zarobków wynosi " + sumOfSalaries);
        System.out.println("Srednia zarobków wynosi " + sumOfSalaries / months);
        System.out.println("Minimalna: " + minSalary);
        System.out.println("Maxymalna: " + maxSalary);

    }

    public static boolean StringToInteger(String s) {
        double number;
        try {
            number = Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
