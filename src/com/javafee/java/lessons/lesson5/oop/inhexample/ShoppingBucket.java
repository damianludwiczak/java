package com.javafee.java.lessons.lesson5.oop.inhexample;

public class ShoppingBucket {
    private PaymentMethod paymentMethod;

    public void pay(Double amount) {
        paymentMethod.pay(amount);
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        System.out.println("Payment method set to " + paymentMethod.getClass().getSimpleName());
        this.paymentMethod = paymentMethod;
    }
}
