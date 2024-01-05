package com.javafee.java.lessons.CrudApp.model.domain;

import com.javafee.java.lessons.CrudApp.model.repository.Dao;
import com.javafee.java.lessons.CrudApp.model.repository.filedb.imp.ClientFileDb;
import com.javafee.java.lessons.CrudApp.service.Utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Store client's data managed by CMS.
 */
public class Client extends UserData implements Serializable {
    private List<Company> companyList = new ArrayList<>();

    private String ageFrom;
    private String ageTo;
    private String wageFrom;
    private String wageTo;

    public Client() {
    }

    public Client(String name, String surname, Integer id, String nationality, Integer age, Double wage, List<Company> companyList) {
        super(name, surname, id, nationality, age, wage);
        this.companyList = companyList;
    }

    public Client(String name, String surname, String nationality, Integer age, Double wage, List<Company> companyList) {
        super(name, surname, nationality, age, wage);
        setId(findMaxId() + 1);
        this.companyList = companyList;
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
        Dao<Client> clientFileDb = new ClientFileDb(Utils.CLIENT_FILE); // new ClientJdbcDb(); //
        List<Client> clientList = clientFileDb.findAll();
        return (clientList == null || clientList.isEmpty()) ? 0 : (clientList.stream().max(Comparator.comparing(Client::getId))
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
