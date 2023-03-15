package com.javafee.java.lessons.lesson15.model.entity;

import com.javafee.java.lessons.lesson15.model.repository.Dao;
import com.javafee.java.lessons.lesson15.model.repository.jdbcdb.impl.CompanyJdbcDb;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Entity
@SequenceGenerator(name = "seq_company", sequenceName = "seq_company", allocationSize = 1)
public class Company {
    @Id
    @Column(name = "id_company")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_company")
    private Integer id;
    private String name;
    private double yearlyIncomes;
    private String yearlyIncomesFrom;
    private String yearlyIncomesTo;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "company_client",
            joinColumns = @JoinColumn(name = "id_company"),
            inverseJoinColumns = @JoinColumn(name = "id_client"))
    private List<Client> clientList = new ArrayList<>();

    public Company() {
    }

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

    private Integer findMaxId() {
        Dao<com.javafee.java.lessons.lesson15.model.domain.Company> companyFileDb = new CompanyJdbcDb(); // new FileDb<>(Utils.COMPANY_FILE);
        List<com.javafee.java.lessons.lesson15.model.domain.Company> companyList = companyFileDb.findAll();
        return (companyList == null || companyList.isEmpty()) ? 0 : (companyList.stream().max(Comparator.comparing(com.javafee.java.lessons.lesson15.model.domain.Company::getId))
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
