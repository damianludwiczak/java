package com.javafee.java.lessons.lesson15.model.domain;

import com.javafee.java.lessons.lesson15.model.repository.DAO;
import com.javafee.java.lessons.lesson15.service.Utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Store company's data.
 */
public class Company implements Serializable {
    private Integer id;
    private String name;
    private Double yearlyIncomes;

    private List<Client> clientList =  new ArrayList<>();

    private List<Company> companyList = new ArrayList<>();


    public Company(String name, Double yearlyIncomes) {
        this.id = findMaxId() + 1;
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

    private Integer findMaxId() {
        DAO<Company[]> companyDao = new DAO<>();
        List<Company> companyList = new ArrayList<Company>(List.of(companyDao.findAll(Utils.COMPANY_FILE)));
        return (companyList == null || companyList.isEmpty()) ? 0 : (companyList.stream().max(Comparator.comparing(Company::getId))
                .orElseThrow(NoSuchElementException::new)).getId();
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
