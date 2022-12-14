package com.javafee.java.lessons.lesson12.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Store company's data.
 */
public class Company implements Serializable {
    private Integer id;
    private String name;
    private Double yearlyIncomes;

    private List<Client> clientList =  new ArrayList<>();

    private static AtomicInteger uniqueId = new AtomicInteger();

    public Company(String name, Double yearlyIncomes) {
        this.id = uniqueId.getAndIncrement();
        this.name = name;
        this.yearlyIncomes = yearlyIncomes;
    }
    public Company(String name, Integer id, Double yearlyIncomes) {
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

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return this.getId().equals(company.getId());
    }
}
