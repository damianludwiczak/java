package com.javafee.java.lessons.lesson11.frontend.gui;

import com.javafee.java.lessons.lesson11.frontend.View;

import javax.swing.*;

public class GraphicalUI implements View {
    private JFrame frame;
    private JPanel panel;
    private JTextField textFieldVar1;
    private JTextField textFieldVar2;
    private JTextField textFieldCalculationType;
    private JButton buttonCalculate;
    private JLabel labelResult;

    public GraphicalUI() {
        frame = new JFrame(" (c) by Damian");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

    @Override
    public JFrame getFrame() {
        return frame;
    }

    @Override
    public JButton getButtonCalculate() {
        return buttonCalculate;
    }

    @Override
    public String getFirstVar() {
        return textFieldVar1.getText();
    }

    @Override
    public String getSecondVar() {
        return textFieldVar2.getText();
    }

    @Override
    public String getCalculationType() {
        return textFieldCalculationType.getText();
    }

    @Override
    public void setMessage(String result) {
        labelResult.setText(result);
    }
}
