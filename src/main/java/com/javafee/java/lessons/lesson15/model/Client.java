package com.javafee.java.lessons.lesson15.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Store client's data managed by CMS.
 */
public class Client  {
    private Integer id;
    private String name;
    private String surname;

    private String nationality;
    private Integer age;
    private Double wage;
    private List<Company> companyList = new ArrayList<>();

    private String ageFrom;
    private String ageTo;
    private String wageFrom;
    private String  wageTo;

    public Client() {
    }

    public Client(Integer id, String name, String surname, String nationality, Integer age, Double wage, List<Company> companyList, String ageFrom, String ageTo, String wageFrom, String wageTo) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.age = age;
        this.wage = wage;
        this.companyList = companyList;
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.wageFrom = wageFrom;
        this.wageTo = wageTo;
    }

    public Client(String name, String surname, String nationality, Integer age, Double wage, List<Company> companyList) {
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.age = age;
        this.wage = wage;
        this.companyList = companyList;
    }

    public Client(Integer id, String name, String surname, String nationality, Integer age, Double wage, List<Company> companyList) {
        this.id = id;
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

    public void setId(Integer id) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
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
