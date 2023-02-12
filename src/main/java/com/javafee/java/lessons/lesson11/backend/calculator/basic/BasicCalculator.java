package com.javafee.java.lessons.lesson11.backend.calculator.basic;

import com.javafee.java.lessons.lesson11.backend.calculator.Calculation;
import com.javafee.java.lessons.lesson11.backend.calculator.Calculator;

public class BasicCalculator implements Calculator {
    @Override
    public double calculate(Calculation calculation, double var1, double var2) {
        return calculation.calculate(var1, var2);
    }
}
