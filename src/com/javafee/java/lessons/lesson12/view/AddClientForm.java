package com.javafee.java.lessons.lesson12.view;

import com.javafee.java.lessons.lesson12.view.model.CompanyTableModel;

import javax.swing.*;
import java.awt.*;

public class AddClientForm {
    private JFrame frame;
    private JPanel panel;
    private JTextField textFieldName;
    private JTextField textFieldNationality;
    private JTextField textFieldAge;
    private JTextField textFieldWage;
    private JTextField textFieldCompany;
    private JButton buttonAccept;
    private JTextField textFieldSurname;
    private JTable tableCompany;
    private JButton buttonUpdate;


    public AddClientForm() {
        frame = new JFrame("Add User");
        frame.setIconImage(new ImageIcon(AddClientForm.class.getResource("btnLogOut-ico.png")).getImage());
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();

        buttonAccept.setIcon(new ImageIcon(new ImageIcon(AddClientForm.class.getResource("btnAccept-ico.png"))
                .getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH)));
    }

    public JTable getTableCompany() {
        return tableCompany;
    }

    public void setTableCompany(JTable tableCompany) {
        this.tableCompany = tableCompany;
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

    public JTextField getTextFieldCompany() {
        return textFieldCompany;
    }

    public void setTextFieldCompany(JTextField textFieldCompany) {
        this.textFieldCompany = textFieldCompany;
    }

    public JButton getButtonAccept() {
        return buttonAccept;
    }

    public JTextField getTextFieldSurname() {
        return textFieldSurname;
    }

    private void createUIComponents() {
        tableCompany = new JTable();
        tableCompany.setModel(new CompanyTableModel());
        tableCompany.setAutoCreateRowSorter(true);
    }
}
