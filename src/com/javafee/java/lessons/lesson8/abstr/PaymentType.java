package com.javafee.java.lessons.lesson8.abstr;

public class PaymentType {
    public static PaymentMethod payU(){
        return new PaymentMethod() { // czy to klasa anonimowa?
            @Override
            public void pay(double amount) {
                System.out.println("paid with PayU " + amount);
            }
        };
    }

    public static PaymentMethod payPal(){
        return new PaymentMethod() {
            @Override
            public void pay(double amount) {
                System.out.println("paid with PayPal " + amount);
            }
        };
    }

    public static PaymentMethod blik(){
        return new PaymentMethod() {
            @Override
            public void pay(double amount) {
                System.out.println("paid with blik " + amount);
            }
        };
    }

    public static PaymentMethod regularTransfer(){
        return new PaymentMethod() {
            @Override
            public void pay(double amount) {
                System.out.println("paid with regular transfer " + amount);
            }
        };
    }
}
