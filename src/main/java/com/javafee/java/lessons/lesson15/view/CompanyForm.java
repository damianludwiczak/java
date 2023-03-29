package com.javafee.java.lessons.lesson15.view;

import com.javafee.java.lessons.lesson15.view.model.ClientTableModel;
import com.javafee.java.lessons.lesson15.view.model.CompanyTableModel;

import javax.swing.*;
import java.awt.*;

public class CompanyForm {
    private JFrame frame;
    private JPanel panel;
    private JTable tableCompany;
    private JButton buttonAdd;
    private JButton buttonModify;
    private JButton buttonDelete;
    private JButton buttonFilter;
    private JButton buttonRemoveFilters;
    private JTable tableClient;

    public CompanyForm() {
        frame = new JFrame("Companies (c) myCMS");
        frame.setIconImage(new ImageIcon(AddClientForm.class.getResource("/btnLogOut-ico.png")).getImage());
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();

        buttonAdd.setIcon(new ImageIcon(new ImageIcon(AddClientForm.class.getResource("/btnAdd-ico.png"))
                .getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH)));
        buttonModify.setIcon(new ImageIcon(new ImageIcon(AddClientForm.class.getResource("/btnModify-ico.png"))
                .getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH)));
        buttonFilter.setIcon(new ImageIcon(new ImageIcon(AddClientForm.class.getResource("/btnModify-ico.png"))
                .getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH)));
        buttonDelete.setIcon(new ImageIcon(new ImageIcon(AddClientForm.class.getResource("/btnRemoveFromList-ico.png"))
                .getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH)));
        buttonRemoveFilters.setIcon(new ImageIcon(new ImageIcon(AddClientForm.class.getResource("/btnRemoveFromList-ico.png"))
                .getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH)));
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

    public JButton getButtonRemoveFilters() {
        return buttonRemoveFilters;
    }

    public JButton getButtonFilter() {
        return buttonFilter;
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
