package com.javafee.java.lessons.lesson11.backend.controller.console;

import com.javafee.java.lessons.lesson11.backend.calculator.Calculator;
import com.javafee.java.lessons.lesson11.backend.calculator.basic.BasicCalculator;
import com.javafee.java.lessons.lesson11.frontend.View;
import com.javafee.java.lessons.lesson11.frontend.console.ConsoleUI;

public class Controller {
    private View view;
    private Calculator calculator;

    public Controller() {
        this.view = new ConsoleUI();
        this.calculator = new BasicCalculator();
    }

    public void run() {
        String choice = view.getCalculationType();
        while(!choice.equalsIgnoreCase("exit")) {
            view.setMessage("Give first and second variables: ");
            view.setMessage(String.valueOf(switch (choice) {
                case "+" -> calculator.calculate((double a, double b) -> a + b, Double.parseDouble(view.getFirstVar()),
                        Double.parseDouble(view.getSecondVar()));
                case "-" -> calculator.calculate((double a, double b) -> a - b, Double.parseDouble(view.getFirstVar()),
                        Double.parseDouble(view.getSecondVar()));
                case "*" -> calculator.calculate((double a, double b) -> a * b, Double.parseDouble(view.getFirstVar()),
                        Double.parseDouble(view.getSecondVar()));
                case "/" -> calculator.calculate((double a, double b) -> a / b, Double.parseDouble(view.getFirstVar()),
                        Double.parseDouble(view.getSecondVar()));
                default -> {throw new UnsupportedOperationException("Wrong calculation type");}
            }));
            choice = view.getCalculationType();
        }
    }
}
