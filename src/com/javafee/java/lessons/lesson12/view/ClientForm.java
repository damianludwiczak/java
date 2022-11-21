package com.javafee.java.lessons.lesson12.view;

import javax.swing.*;

public class ClientForm {
    private JFrame frame;
    private JPanel panel;
    private JTable table1;
    private JButton buttonAdd;
    private JButton buttonModify;
    private JButton buttonDelete;

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

    public JTable getTable1() {
        return table1;
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
}
