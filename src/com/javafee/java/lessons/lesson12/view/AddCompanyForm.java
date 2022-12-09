package com.javafee.java.lessons.lesson12.view;

import javax.swing.*;

public class AddCompanyForm {
    private JFrame frame;
    private JPanel panel;
    private JTextField textFieldName;
    private JTextField textFieldYearlyIncomes;
    private JButton buttonConfirm;

    public AddCompanyForm() {
        frame = new JFrame("Add Company");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public void setTextFieldName(JTextField textFieldName) {
        this.textFieldName = textFieldName;
    }

    public JTextField getTextFieldYearlyIncomes() {
        return textFieldYearlyIncomes;
    }

    public void setTextFieldYearlyIncomes(JTextField textFieldYearlyIncomes) {
        this.textFieldYearlyIncomes = textFieldYearlyIncomes;
    }

    public JButton getButtonConfirm() {
        return buttonConfirm;
    }
}
