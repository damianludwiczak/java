package com.javafee.java.lessons.lesson7._knowledge.ifc;

public interface Calculation {
    // could consist of fields/constructors etc.
    double calculate(double var1, double var2);

    default void makeSomeShit() {
        System.out.println("I'm happy!");
    }
}
