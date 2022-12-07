package com.javafee.java.lessons.lesson12.model.domain;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Store client's data managed by CMS.
 */
public class Client extends UserData implements Serializable {
    private Company company;
    private static AtomicInteger uniqueId = new AtomicInteger();

    public Client() {
    }

    public Client(String name, String surname, Integer id, String nationality, Integer age, Double wage, Company company) {
        super(name, surname, id, nationality, age, wage);
        this.company = company;
    }

    public Client(String name, String surname, String nationality, Integer age, Double wage, Company company) {
        super(name, surname, nationality, age, wage);
        setId(uniqueId.getAndIncrement());
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
        return "Client{" +
                "name=" + super.getName() +
                " surname=" + super.getSurname() +
                " nationality=" + super.getNationality() +
                " age=" + super.getAge() +
                " wage=" + super.getWage() +
                " company=" + company +
                '}';
    }
}
