package com.javafee.java.lessons.lesson15.view;

import javax.swing.*;
import java.awt.*;

public class FilterClientForm {

    private JFrame frame;
    private JPanel panel;
    private JTextField textFieldName;
    private JTextField textFieldSurname;
    private JTextField textFieldNationality;
    private JTextField textFieldAgeFrom;
    private JTextField textFieldWageFrom;
    private JTextField textFieldCompanyName;
    private JButton buttonFilter;
    private JTextField textFieldCompanyIncomesFrom;
    private JTextField textFieldCompanyIncomesTo;
    private JTextField textFieldAgeTo;
    private JTextField textFieldWageTo;

    public FilterClientForm() {
        frame = new JFrame("Filter Client");
        frame.setIconImage(new ImageIcon(com.javafee.java.lessons.lesson15.view.FilterClientForm.class.
                getResource("/btnLogOut-ico.png")).getImage());
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        buttonFilter.setIcon(new ImageIcon(new ImageIcon(com.javafee.java.lessons.lesson15.view.FilterClientForm.class.getResource("/btnAccept-ico.png"))
                .getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH)));
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

    public JTextField getTextFieldSurname() {
        return textFieldSurname;
    }

    public JTextField getTextFieldNationality() {
        return textFieldNationality;
    }

    public JTextField getTextFieldAgeFrom() {
        return textFieldAgeFrom;
    }

    public JTextField getTextFieldAgeTo() {
        return textFieldAgeTo;
    }
    public JTextField getTextFieldWageFrom() {
        return textFieldWageFrom;
    }

    public JTextField getTextFieldWageTo() {
        return textFieldWageTo;
    }

    public JTextField getTextFieldCompanyName() {
        return textFieldCompanyName;
    }

    public JTextField getTextFieldCompanyIncomesFrom() {
        return textFieldCompanyIncomesFrom;
    }

    public JTextField getTextFieldCompanyIncomesTo() {
        return textFieldCompanyIncomesTo;
    }

    public JButton getButtonFilter() {
        return buttonFilter;
    }
}
