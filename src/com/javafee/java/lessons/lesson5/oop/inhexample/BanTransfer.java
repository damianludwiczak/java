package com.javafee.java.lessons.lesson5.oop.inhexample;

public class BanTransfer extends PaymentMethod {
    public void pay(Double amount) {
        System.out.println("Paid " + amount + " with Bank Transfer");
    }
}
