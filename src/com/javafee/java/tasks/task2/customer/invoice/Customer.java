package com.javafee.java.tasks.task2.customer.invoice;


public class Customer {
    private int id, discount;
    private String name;
    public Customer(int id, String name, int discount) {
        this.id = id;
        this.name = name;
        this.discount = discount;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getDiscount() {
        return discount;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    @Override
    public String toString() {
        return String.format("%s(%d)(%d%c)", name, id, discount, '%');
    }
}
