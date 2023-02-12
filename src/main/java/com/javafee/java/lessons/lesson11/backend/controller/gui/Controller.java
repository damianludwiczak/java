package com.javafee.java.lessons.lesson11.backend.controller.gui;

import com.javafee.java.lessons.lesson11.backend.calculator.Calculator;
import com.javafee.java.lessons.lesson11.backend.calculator.basic.BasicCalculator;
import com.javafee.java.lessons.lesson11.frontend.View;
import com.javafee.java.lessons.lesson11.frontend.gui.GraphicalUI;

public class Controller {
    private View view;
    private Calculator calculator;

    public Controller() {
        this.view = new GraphicalUI();
        this.calculator = new BasicCalculator();
    }

    public void run() {
        init();

        this.view.getButtonCalculate().addActionListener(e -> onClickButtonCalculate());
    }

    private void onClickButtonCalculate() {
        view.setMessage(String.valueOf(switch (view.getCalculationType()) {
            case "+" -> calculator.calculate((double a, double b) -> a + b, Double.parseDouble(view.getFirstVar()),
                    Double.parseDouble(view.getSecondVar()));
            case "-" -> calculator.calculate((double a, double b) -> a - b, Double.parseDouble(view.getFirstVar()),
                    Double.parseDouble(view.getSecondVar()));
            case "*" -> calculator.calculate((double a, double b) -> a * b, Double.parseDouble(view.getFirstVar()),
                    Double.parseDouble(view.getSecondVar()));
            case "/" -> calculator.calculate((double a, double b) -> a / b, Double.parseDouble(view.getFirstVar()),
                    Double.parseDouble(view.getSecondVar()));
            default -> throw new UnsupportedOperationException("Wrong calculation type");
        }));
    }

    private void init() {
        this.view.getFrame().setVisible(true);
    }
}
