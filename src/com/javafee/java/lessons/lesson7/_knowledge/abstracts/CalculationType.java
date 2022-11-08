package com.javafee.java.lessons.lesson7._knowledge.abstracts;

public class CalculationType {
    public static Calculation addition() {
        return new Calculation() {
            @Override
            public double calculate(double var1, double var2) {
                return var1 + var2;
            }
        };
    }

    public static Calculation subtraction() {
        return new Calculation() {
            @Override
            public double calculate(double var1, double var2) {
                return var1 - var2;
            }
        };
    }

    public static Calculation multiplication() {
        return new Calculation() {
            @Override
            public double calculate(double var1, double var2) {
                return var1 * var2;
            }
        };
    }

    public static Calculation division() {
        return new Calculation() {
            @Override
            public double calculate(double var1, double var2) {
                return var1 / var2;
            }
        };
    }
}
