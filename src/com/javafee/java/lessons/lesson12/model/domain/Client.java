package com.javafee.java.lessons.lesson12.model.domain;

import com.javafee.java.lessons.lesson12.model.repository.DAO;
import com.javafee.java.lessons.lesson12.service.Utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Store client's data managed by CMS.
 */
public class Client extends UserData implements Serializable {
    private List<Company> companyList = new ArrayList<>();

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

    private Integer findMaxId() {
        DAO<Client[]> dao = new DAO<>();
        List<Client> clientList = new ArrayList<Client>(List.of(dao.findAll(Utils.CLIENT_FILE)));
        return (clientList == null || clientList.isEmpty()) ? 1 : (clientList.stream().max(Comparator.comparing(Client::getId))
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
        return getName() + " " + getId();
    }
}
