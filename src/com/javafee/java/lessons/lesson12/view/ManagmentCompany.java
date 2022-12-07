package com.javafee.java.lessons.lesson12.view;

import com.javafee.java.lessons.lesson12.view.model.ClientTableModel;
import com.javafee.java.lessons.lesson12.view.model.CompanyTableModel;

import javax.swing.*;

public class ManagmentCompany {
    private JFrame frame;
    private JPanel panel;
    private JTable tableCompany;
    private JButton buttonAdd;
    private JButton buttonDelete;
    private JButton buttonModify;

    public ManagmentCompany() {
        frame = new JFrame("Companies (c) myCMS");
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

    public JTable getTableCompany() {
        return tableCompany;
    }

    public void setTableCompany(JTable tableCompany) {
        this.tableCompany = tableCompany;
    }

    public JButton getButtonAdd() {
        return buttonAdd;
    }

    public void setButtonAdd(JButton buttonAdd) {
        this.buttonAdd = buttonAdd;
    }

    public JButton getButtonDelete() {
        return buttonDelete;
    }

    public void setButtonDelete(JButton buttonDelete) {
        this.buttonDelete = buttonDelete;
    }

    public JButton getButtonModify() {
        return buttonModify;
    }

    public void setButtonModify(JButton buttonModify) {
        this.buttonModify = buttonModify;
    }

    private void createUIComponents() {
        tableCompany = new JTable();
        tableCompany.setModel(new CompanyTableModel());
        tableCompany.setAutoCreateRowSorter(true);
    }
}
