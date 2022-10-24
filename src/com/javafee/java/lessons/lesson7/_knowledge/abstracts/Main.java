package com.javafee.java.lessons.lesson7._knowledge.abstracts;

public class Main {
    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();
        System.out.println(calculator.calculate(CalculationType.addition(), 2.5, 2.5));
        System.out.println(calculator.calculate(CalculationType.subtraction(), 2.5, 2.5));
        System.out.println(calculator.calculate(CalculationType.multiplication(), 2.5, 2.5));
        System.out.println(calculator.calculate(CalculationType.division(), 2.5, 2.5));
    }
}
