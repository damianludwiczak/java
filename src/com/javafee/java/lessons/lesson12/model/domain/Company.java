package com.javafee.java.lessons.lesson12.model.domain;

/**
 * Store company's data.
 */
public class Company {
    private String name;
    private Double yearlyIncomes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getYearlyIncomes() {
        return yearlyIncomes;
    }

    public void setYearlyIncomes(Double yearlyIncomes) {
        this.yearlyIncomes = yearlyIncomes;
    }
}
