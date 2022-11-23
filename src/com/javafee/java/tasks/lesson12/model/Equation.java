package com.javafee.java.tasks.lesson12.model;

public class Equation {
    public String calucalateDelta(String vars) {
        String[] data = vars.split(",");
        try {
            double a = Double.parseDouble(data[0]);
            double b = Double.parseDouble(data[1]);
            double c = Double.parseDouble(data[2]);
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = ((-b) - Math.sqrt(delta)) / 2 * a;
                double x2 = ((-b) + Math.sqrt(delta)) / 2 * a;
                return "x1: " + x1 + " x2: " + x2;
            } else if (delta == 0) {
                double x = (-b) / 2 * a;
                return "x: " + x;
            } else {
                return "no solutions";
            }
        } catch (NumberFormatException e) {
            return "Wrong input";
        }

    }
}
