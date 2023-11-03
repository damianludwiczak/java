package com.javafee.java.lessons.lesson15.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Store company's data.
 */
public class Company {
    private Integer id;
    private String name;
    private Double yearlyIncomes;
    private String yearlyIncomesFrom;
    private String yearlyIncomesTo;

    private List<Client> clientList =  new ArrayList<>();

    public Company() {
    }

    public Company(Integer id, String name, Double yearlyIncomes, String yearlyIncomesFrom, String yearlyIncomesTo, List<Client> clientList) {
        this.id = id;
        this.name = name;
        this.yearlyIncomes = yearlyIncomes;
        this.yearlyIncomesFrom = yearlyIncomesFrom;
        this.yearlyIncomesTo = yearlyIncomesTo;
        this.clientList = clientList;
    }

    public Company(String name, Double yearlyIncomes) {
        this.name = name;
        this.yearlyIncomes = yearlyIncomes;
    }

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

    public String getYearlyIncomesFrom() {
        return yearlyIncomesFrom;
    }

    public void setYearlyIncomesFrom(String yearlyIncomesFrom) {
        this.yearlyIncomesFrom = yearlyIncomesFrom;
    }

    public String getYearlyIncomesTo() {
        return yearlyIncomesTo;
    }

    public void setYearlyIncomesTo(String yearlyIncomesTo) {
        this.yearlyIncomesTo = yearlyIncomesTo;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return this.getId().equals(company.getId());
    }
}
