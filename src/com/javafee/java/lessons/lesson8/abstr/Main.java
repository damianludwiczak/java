package com.javafee.java.lessons.lesson8.abstr;

public class Main {
    public static void main(String[] args) { // TODO: 10.11.2022 czy korzyści to tylko i wyłącznie nie tworzenie nowych
                                                    // plików z klasami czy jest coś jeszcze?
        Payment payment = new Payment();
        //DO NOT CHANGE!
         payment.pay(PaymentType.blik(), 2000.0); // paid with blik 2000.0
         payment.pay(PaymentType.payPal(), 2000.0); // paid with PayPal 2000.0
         payment.pay(PaymentType.payU(), 2000.0); // paid with PayU 2000.0
         payment.pay(PaymentType.regularTransfer(), 2000.0); // paid with regular transfer 2000.0
    }
}
