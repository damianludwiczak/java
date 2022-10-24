package com.javafee.java.lessons.lesson5.oop.test;

import java.util.Objects;

public class A extends B {
    private String sth;

    public A(String name) {
        super(name);
    }

    public String toString() {
        System.out.println(name);
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return Objects.equals(sth, a.sth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sth);
    }
}
