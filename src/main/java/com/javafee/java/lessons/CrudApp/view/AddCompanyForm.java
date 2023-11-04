package com.javafee.java.lessons.CrudApp.view;


import com.javafee.java.lessons.CrudApp.view.AddClientForm;

import javax.swing.*;
import java.awt.*;

public class AddCompanyForm {
    private JFrame frame;
    private JPanel panel;
    private JTextField textFieldName;
    private JTextField textFieldYearlyIncomes;
    private JButton buttonConfirm;

    public AddCompanyForm() {
        frame = new JFrame("Add Company");
        frame.setIconImage(new ImageIcon(com.javafee.java.lessons.CrudApp.view.AddClientForm.class.getResource("/btnLogOut-ico.png")).getImage());
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();

        buttonConfirm.setIcon(new ImageIcon(new ImageIcon(AddClientForm.class.getResource("/btnAccept-ico.png"))
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

    public void setTextFieldName(JTextField textFieldName) {
        this.textFieldName = textFieldName;
    }

    public JTextField getTextFieldYearlyIncomes() {
        return textFieldYearlyIncomes;
    }

    public void setTextFieldYearlyIncomes(JTextField textFieldYearlyIncomes) {
        this.textFieldYearlyIncomes = textFieldYearlyIncomes;
    }

    public JButton getButtonConfirm() {
        return buttonConfirm;
    }
}

