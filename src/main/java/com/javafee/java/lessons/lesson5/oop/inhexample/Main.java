package com.javafee.java.lessons.lesson5.oop.inhexample;

public class Main {
    public static void main(String[] args) {
        ShoppingBucket shoppingBucket = new ShoppingBucket();
        shoppingBucket.setPaymentMethod(new PayU());
        shoppingBucket.pay(1000.0);

        shoppingBucket.setPaymentMethod(new PayPal());
        shoppingBucket.pay(1000.0);

        shoppingBucket.setPaymentMethod(new BanTransfer());
        shoppingBucket.pay(1000.0);

        shoppingBucket.setPaymentMethod(new Blik());
        shoppingBucket.pay(1000.0);
    }
}
