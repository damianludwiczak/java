package com.javafee.java.lessons.lesson5.oop;

public class A extends B {
    public void b() {
        System.out.println("a");
        super.b();
    }

    public void a() {
        System.out.println("a");
    }

    public void a(String a) {
        System.out.println(a);
    }

    public Double a(String a, int b) {
        System.out.println(a + b);
        return 0.0;
    }
}
