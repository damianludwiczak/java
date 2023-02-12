package com.javafee.java.lessons.lesson5.oop;

public class Main {
    public static void main(String[] args) {
        C c = new A(); // co nam to daje?
        C c1 = new B();
        B b = new A();
        Object o = new C();

        ((A) c).a();
        if (o instanceof B)
            ((B) o).b(); // dlaczego wyrzuca błąd?? roznice miedzy polimormizmem a dziedziczeniem
        else
            System.err.println("o is not of B type");
    }
}
