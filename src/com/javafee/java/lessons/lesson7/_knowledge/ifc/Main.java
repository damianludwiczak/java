package com.javafee.java.lessons.lesson7._knowledge.ifc;

public class Main {
    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();
        System.out.println(calculator.calculate((var1, var2) -> var1 + var2, 2.5, 2.5));
        System.out.println(calculator.calculate((var1, var2) -> var1 - var2, 2.5, 2.5));
        System.out.println(calculator.calculate((var1, var2) -> var1 * var2, 2.5, 2.5));
        System.out.println(calculator.calculate((var1, var2) -> var1 / var2, 2.5, 2.5));
    }
    // https://bulldogjob.pl/readme/interfejsy-w-javie-wyrazenia-lambda
    // https://codecouple.pl/2016/10/08/interfejsy-funkcyjne/
}
