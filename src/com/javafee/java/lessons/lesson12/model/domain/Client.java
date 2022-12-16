package com.javafee.java.lessons.lesson12.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Store client's data managed by CMS.
 */
public class Client extends UserData implements Serializable {
    private static AtomicInteger uniqueId = new AtomicInteger();

    private List<Company> companyList = new ArrayList<>();

    public Client() {
    }

    public Client(String name, String surname, Integer id, String nationality, Integer age, Double wage, List<Company> companyList) {
        super(name, surname, id, nationality, age, wage);
        this.companyList = companyList;
    }

    public Client(String name, String surname, String nationality, Integer age, Double wage, List<Company> companyList) {
        super(name, surname, nationality, age, wage);
        setId(uniqueId.getAndIncrement());
        this.companyList = companyList;
    }
    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
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
                " company=" + companyList.toString() +
                '}';
    }
}
