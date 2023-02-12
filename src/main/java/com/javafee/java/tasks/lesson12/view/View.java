package com.javafee.java.tasks.lesson12.view;

import javax.swing.*;

public interface View {
    String getFirstVar();
    String getSecondVar();
    String getThirdVar();
    void setMessage(String result);

    /* Specific for GUI */
    JButton getButtonCalculate();
    JFrame getFrame();
}
