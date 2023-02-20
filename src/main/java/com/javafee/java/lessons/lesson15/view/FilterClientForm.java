package com.javafee.java.lessons.lesson15.view;

import javax.swing.*;
import java.awt.*;

public class FilterClientForm {

    private JFrame frame;
    private JPanel panel;
    private JTextField textFieldName;
    private JTextField textFieldSurname;
    private JTextField textFieldNationality;
    private JTextField textFieldAge;
    private JTextField textFieldWage;
    private JTextField textFieldCompany;
    private JButton buttonFilter;

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

    public JTextField getTextFieldAge() {
        return textFieldAge;
    }

    public JTextField getTextFieldWage() {
        return textFieldWage;
    }

    public JTextField getTextFieldCompany() {
        return textFieldCompany;
    }

    public JButton getButtonFilter() {
        return buttonFilter;
    }
}
