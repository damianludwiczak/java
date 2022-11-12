package com.javafee.java.lessons.lesson8.finterf;

public class Main {
    public static void main(String[] args) {
        Payment payment = new Payment();
        //DO NOT CHANGE!, provide some content in ???

        payment.pay(amount -> System.out.println("Paid with PayPal " + amount), 2000.0); // paid with PayPal 2000.0
        payment.pay(amount -> System.out.println("Paid with blik " + amount), 2000.0); // paid with blik 2000.0
        payment.pay((amount) -> System.out.println("Paid with PayU " + amount), 2000.0); // paid with PayU 2000.0
        payment.pay((amount) -> System.out.println("Paid with regular transfer " + amount), 2000.0); // paid with regular transfer 2000.0
    }
}
