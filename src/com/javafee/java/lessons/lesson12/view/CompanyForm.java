package com.javafee.java.lessons.lesson12.view;

import com.javafee.java.lessons.lesson12.view.model.ClientTableModel;
import com.javafee.java.lessons.lesson12.view.model.CompanyTableModel;

import javax.swing.*;

public class CompanyForm {
    private JFrame frame;
    private JPanel panel;
    private JTable tableCompany;
    private JButton buttonAdd;
    private JButton buttonModify;
    private JButton buttonDelete;
    private JTable tableClient;

    public CompanyForm() {
        frame = new JFrame("Companies (c) myCMS");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanel(){
        return panel;
    }
    public JTable getTableCompany(){
        return tableCompany;
    }

    public JButton getButtonAdd() {
        return buttonAdd;
    }

    public JButton getButtonModify() {
        return buttonModify;
    }

    public JButton getButtonDelete() {
        return buttonDelete;
    }

    private void createUIComponents() {
        tableCompany = new JTable();
        tableCompany.setModel(new CompanyTableModel());
        tableCompany.setAutoCreateRowSorter(true);

        tableClient = new JTable();
        tableClient.setModel(new ClientTableModel());
        tableCompany.setAutoCreateRowSorter(true);
    }
}
