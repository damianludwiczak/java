package com.javafee.java.tasks.lesson12.controller;

import com.javafee.java.tasks.lesson12.model.Equation;
import com.javafee.java.tasks.lesson12.view.GraphicalUI;
import com.javafee.java.tasks.lesson12.view.View;

public class Controller {
    private View view;
    private Equation equation;

    public Controller() {
        this.view = new GraphicalUI();
        this.equation = new Equation();
    }

    public void run() {
        init();
        this.view.getButtonCalculate().addActionListener(e -> onClickButtonCalculate());
    }

    private void onClickButtonCalculate() {
        String data = view.getFirstVar() + "," + view.getSecondVar() + "," + view.getThirdVar();
        view.setMessage(equation.calucalateDelta(data));
    }

    private void init() {
        this.view.getFrame().setVisible(true);
    }
}
