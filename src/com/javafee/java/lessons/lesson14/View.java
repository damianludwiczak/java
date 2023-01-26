package com.javafee.java.lessons.lesson14;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame;
    private JTextField textFieldArrayLength;
    private JTextField textFieldIndexesAmount;
    private JTextField textFieldIterationAmount;
    private JPanel panel;
    private JButton buttonAccept;
    private JTextField textFieldArrayRangeMin;
    private JTextField textFieldArrayRangeMax;
    private JTextField textFieldIndexesRangeMin;
    private JTextField textFieldIndexesRangeMax;
    private JTextField textFieldArrayRangeFrom;
    private JTextField textFieldArrayRangeTo;
    private JTextField textFieldStep;
    private JTextField textFieldIterationAmountByStep;
    private JButton buttonConfirm;
    private JTextField textFieldAmountIndexesToRemove;

    public View() {
        frame = new JFrame("View");
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
    public JTextField getTextFieldArrayRangeMin() {
        return textFieldArrayRangeMin;
    }
    public JTextField getTextFieldArrayRangeMax() {
        return textFieldArrayRangeMax;
    }
    public JTextField getTextFieldArrayLength() {
        return textFieldArrayLength;
    }
    public JTextField getTextFieldIndexesAmount() {
        return textFieldIndexesAmount;
    }
    public JTextField getTextFieldIndexesRangeMin() {
        return textFieldIndexesRangeMin;
    }
    public JTextField getTextFieldIndexesRangeMax() {
        return textFieldIndexesRangeMax;
    }
    public JTextField getTextFieldIterationAmount() {
        return textFieldIterationAmount;
    }
    public JButton getButtonAccept() {
        return buttonAccept;
    }

    public JTextField getTextFieldArrayRangeFrom() {
        return textFieldArrayRangeFrom;
    }

    public JTextField getTextFieldArrayRangeTo() {
        return textFieldArrayRangeTo;
    }

    public JTextField getTextFieldStep() {
        return textFieldStep;
    }

    public JTextField gettextFieldIterationAmountByStep() {
        return textFieldIterationAmountByStep;
    }

    public JButton getButtonConfirm() {
        return buttonConfirm;
    }

    public JTextField getTextFieldAmountIndexesToRemove() {
        return textFieldAmountIndexesToRemove;
    }

    public static void displayPopup(String message, String title, int type, Component component) {
        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage("<html>" + message + "</html>");
        optionPane.setMessageType(type);
        JDialog dialog = optionPane.createDialog(component, title);
        dialog.setVisible(true);
    }
}
