package com.javafee.java.lessons.lesson15.view;

import com.javafee.java.lessons.lesson15.view.model.ClientTableModel;

import javax.swing.*;

import java.awt.*;
import java.util.Vector;

public class ClientForm {
    private JFrame frame;
    private JPanel panel;
    private JTable tableClient;
    private JButton buttonAdd;
    private JButton buttonModify;
    private JButton buttonDelete;
    private JButton buttonManagementCompany;

    private static FocusTraversalPolicy newPolicy;
    public ClientForm() {
        frame = new JFrame("Clients (c) myCMS");
        frame.setIconImage(new ImageIcon(AddClientForm.class.getResource("btnLogOut-ico.png")).getImage());
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        buttonAdd.setIcon(new ImageIcon(new ImageIcon(AddClientForm.class.getResource("btnAdd-ico.png"))
                .getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH)));
        buttonModify.setIcon(new ImageIcon(new ImageIcon(AddClientForm.class.getResource("btnModify-ico.png"))
                .getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH)));
        buttonDelete.setIcon(new ImageIcon(new ImageIcon(AddClientForm.class.getResource("btnRemoveFromList-ico.png"))
                .getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH)));
        buttonManagementCompany.setIcon(new ImageIcon(new ImageIcon(AddClientForm.class.getResource("btnRegisterNow-ico.png"))
                .getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH)));

        Vector<Component> order = new Vector<Component>(7);
        order.add(buttonAdd);
        order.add(buttonModify);
        order.add(buttonDelete);
        order.add(buttonManagementCompany);
        newPolicy = new com.javafee.java.lessons.lesson12.view.ClientForm.MyOwnFocusTraversalPolicy(order);

        frame.setFocusTraversalPolicy(newPolicy);
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

    public JButton getButtonManagementCompany() {
        return buttonManagementCompany;
    }

    private void createUIComponents() {
        tableClient = new JTable();
        tableClient.setModel(new ClientTableModel());
        tableClient.setAutoCreateRowSorter(true);
    }

    public static class MyOwnFocusTraversalPolicy extends FocusTraversalPolicy {
        Vector<Component> order;

        public MyOwnFocusTraversalPolicy(Vector<Component> order) {
            this.order = new Vector<Component>(order.size());
            this.order.addAll(order);
        }

        public Component getComponentAfter(Container focusCycleRoot,
                                           Component aComponent) {
            int idx = (order.indexOf(aComponent) + 1) % order.size();
            return order.get(idx);
        }

        public Component getComponentBefore(Container focusCycleRoot,
                                            Component aComponent) {
            int idx = order.indexOf(aComponent) - 1;
            if (idx < 0) {
                idx = order.size() - 1;
            }
            return order.get(idx);
        }

        public Component getDefaultComponent(Container focusCycleRoot) {
            return order.get(0);
        }

        public Component getLastComponent(Container focusCycleRoot) {
            return order.lastElement();
        }

        public Component getFirstComponent(Container focusCycleRoot) {
            return order.get(0);
        }
    }
}

