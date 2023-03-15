package com.javafee.java.lessons.lesson15.model.entity;

import com.javafee.java.lessons.lesson15.model.repository.Dao;
import com.javafee.java.lessons.lesson15.model.repository.jdbcdb.impl.ClientJdbcDb;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Entity
@SequenceGenerator(name = "seq_client", sequenceName = "seq_client", allocationSize = 1)
public class Client {
    @Id
    @Column(name = "id_client")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_client")
    private Integer id;
    private String name;
    private String surname;
    private String nationality;
    private int age;
    private double wage;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "clientList")
    private List<Company> companyList = new ArrayList<>();
    private String ageFrom;
    private String ageTo;
    private String wageFrom;
    private String wageTo;

    public Client() {
    }

    public Client(int id, String name, String surname, String nationality, int age, double wage, List<Company> companyList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.age = age;
        this.wage = wage;
        this.companyList = companyList;
    }

    public Client(String name, String surname, String nationality, int age, double wage, List<Company> companyList) {
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.age = age;
        this.wage = wage;
        this.companyList = companyList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public String getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(String ageFrom) {
        this.ageFrom = ageFrom;
    }

    public String getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(String ageTo) {
        this.ageTo = ageTo;
    }

    public String getWageFrom() {
        return wageFrom;
    }

    public void setWageFrom(String wageFrom) {
        this.wageFrom = wageFrom;
    }

    public String getWageTo() {
        return wageTo;
    }

    public void setWageTo(String wageTo) {
        this.wageTo = wageTo;
    }

    private Integer findMaxId() {
        Dao<com.javafee.java.lessons.lesson15.model.domain.Client> fileDb = new ClientJdbcDb(); // new FileDb<>(Utils.CLIENT_FILE);
        List<com.javafee.java.lessons.lesson15.model.domain.Client> clientList = fileDb.findAll();
        return (clientList == null || clientList.isEmpty()) ? 0 : (clientList.stream().max(Comparator.comparing(com.javafee.java.lessons.lesson15.model.domain.Client::getId))
                .orElseThrow(NoSuchElementException::new)).getId();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return this.getId().equals(client.getId());
    }

    @Override
    public String toString() {
        return getName();
    }
}
