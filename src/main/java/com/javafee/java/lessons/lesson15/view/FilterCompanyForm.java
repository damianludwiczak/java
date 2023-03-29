package com.javafee.java.lessons.lesson15.view;

import com.javafee.java.lessons.lesson12.view.AddClientForm;

import javax.swing.*;
import java.awt.*;

public class FilterCompanyForm {
    private JFrame frame;
    private JPanel panel;
    private JTextField textFieldName;
    private JTextField textFieldYearlyIncomesFrom;
    private JTextField textFieldYearlyIncomesTo;
    private JButton buttonAccept;

    public FilterCompanyForm() {
        frame = new JFrame("Filter Company");
        frame.setIconImage(new ImageIcon(com.javafee.java.lessons.lesson15.view.FilterCompanyForm.class.getResource("/btnLogOut-ico.png")).getImage());
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();

        buttonAccept.setIcon(new ImageIcon(new ImageIcon(FilterClientForm.class.getResource("/btnAccept-ico.png"))
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

    public JTextField getTextFieldYearlyIncomesFrom() {
        return textFieldYearlyIncomesFrom;
    }

    public JTextField getTextFieldYearlyIncomesTo() {
        return textFieldYearlyIncomesTo;
    }

    public JButton getButtonAccept() {
        return buttonAccept;
    }
}
