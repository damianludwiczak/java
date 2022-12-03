package com.javafee.java.lessons.lesson12.view;

import javax.swing.*;

public class ModifyClientForm {
    private JFrame frame;
    private JPanel panel;
    private JTextField textFieldName;
    private JTextField textFieldSurname;
    private JTextField textFieldNationality;
    private JTextField textFieldAge;
    private JTextField textFieldWage;
    private JButton buttonAcccept;

    public ModifyClientForm() {
        frame = new JFrame("Modify Client Form");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public void setTextFieldName(JTextField textFieldName) {
        this.textFieldName = textFieldName;
    }

    public JTextField getTextFieldSurname() {
        return textFieldSurname;
    }

    public void setTextFieldSurname(JTextField textFieldSurname) {
        this.textFieldSurname = textFieldSurname;
    }

    public JTextField getTextFieldNationality() {
        return textFieldNationality;
    }

    public void setTextFieldNationality(JTextField textFieldNationality) {
        this.textFieldNationality = textFieldNationality;
    }

    public JTextField getTextFieldAge() {
        return textFieldAge;
    }

    public void setTextFieldAge(JTextField textFieldAge) {
        this.textFieldAge = textFieldAge;
    }

    public JTextField getTextFieldWage() {
        return textFieldWage;
    }

    public void setTextFieldWage(JTextField textFieldWage) {
        this.textFieldWage = textFieldWage;
    }

    public JButton getButtonAcccept() {
        return buttonAcccept;
    }

    public void setButtonAcccept(JButton buttonAcccept) {
        this.buttonAcccept = buttonAcccept;
    }
}
