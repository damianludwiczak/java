package com.javafee.java.lessons.lesson8.finterf;

public class Payment {
    void pay(PaymentMethod paymentMethod, double amount) {
        paymentMethod.pay(amount);
    }
}
