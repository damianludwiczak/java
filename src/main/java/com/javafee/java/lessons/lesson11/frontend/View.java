package com.javafee.java.lessons.lesson11.frontend;

import javax.swing.*;

public interface View {
    String getFirstVar();
    String getSecondVar();
    String getCalculationType();
    void setMessage(String result);

    /* Specific for GUI */
    JButton getButtonCalculate();
    JFrame getFrame();
}
