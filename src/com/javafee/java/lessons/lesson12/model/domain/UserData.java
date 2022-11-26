package com.javafee.java.lessons.lesson12.model.domain;

import java.io.Serializable;

/**
 * Store PI related data.
 */
public class UserData implements Serializable {
    private String name;
    private String surname;
    private String nationality;
    private Integer age;
    private Double wage;

    public UserData() {
    }

    public UserData(String name, String surname, String nationality, Integer age, Double wage) {
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.age = age;
        this.wage = wage;
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
}
