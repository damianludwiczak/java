package com.javafee.java.tasks.lesson12.view;

import javax.swing.*;

public class GraphicalUI implements View {
    private JFrame frame;
    private JPanel panel;
    private JTextField textFieldVarA;
    private JTextField textFieldVarB;
    private JTextField textFieldVarC;
    private JButton buttonCalculate;
    private JLabel labelResult;

    public GraphicalUI() {
        frame = new JFrame("Calc (c) by Damian");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

    @Override
    public JButton getButtonCalculate() {
        return buttonCalculate;
    }

    @Override
    public JFrame getFrame() {
        return frame;
    }

    @Override
    public String getFirstVar() {
        return textFieldVarA.getText();
    }

    @Override
    public String getSecondVar() {
        return textFieldVarB.getText();
    }

    @Override
    public String getThirdVar() {
        return textFieldVarC.getText();
    }

    @Override
    public void setMessage(String result) {
        labelResult.setText(result);
    }
}
