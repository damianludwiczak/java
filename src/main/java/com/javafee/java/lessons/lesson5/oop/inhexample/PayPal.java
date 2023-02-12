package com.javafee.java.lessons.lesson5.oop.inhexample;

public class PayPal extends PaymentMethod {
    public void pay(Double amount) {
        System.out.println("Paid " + amount + " with PayPal");
    }
}
