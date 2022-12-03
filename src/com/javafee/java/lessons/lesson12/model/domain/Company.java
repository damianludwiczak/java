package com.javafee.java.lessons.lesson12.model.domain;

import java.io.Serializable;

/**
 * Store company's data.
 */
public class Company implements Serializable {
    private Integer id;
    private String name;
    private Double yearlyIncomes;

    public Company(Integer id, String name, Double yearlyIncomes) {
        this.id = id;
        this.name = name;
        this.yearlyIncomes = yearlyIncomes;
    }

    public Integer getId() {
        return id;
    }

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
