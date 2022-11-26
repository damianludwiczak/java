package com.javafee.java.lessons.lesson12.model.domain;

import java.io.Serializable;

/**
 * Store client's data managed by CMS.
 */
public class Client extends UserData implements Serializable {
    private Company company;

    public Client() {
    }

    public Client(String name, String surname, String nationality, Integer age, Double wage, Company company) {
        super(name, surname, nationality, age, wage);
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
