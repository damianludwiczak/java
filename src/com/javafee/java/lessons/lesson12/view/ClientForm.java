package com.javafee.java.lessons.lesson12.view;

import com.javafee.java.lessons.lesson12.view.model.ClientTableModel;

import javax.swing.*;

public class ClientForm {
    private JFrame frame;
    private JPanel panel;
    private JTable tableClient;
    private JButton buttonAdd;
    private JButton buttonModify;
    private JButton buttonDelete;
    private JButton buttonManagmentCompany;

    public ClientForm() {
        frame = new JFrame("Clients (c) myCMS");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTable getTableClient() {
        return tableClient;
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

    public JButton getButtonManagmentCompany() {
        return buttonManagmentCompany;
    }

    private void createUIComponents() {
        tableClient = new JTable();
        tableClient.setModel(new ClientTableModel());
        tableClient.setAutoCreateRowSorter(true);
    }
}
