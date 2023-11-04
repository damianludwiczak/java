package com.javafee.java.lessons.CrudApp.model.domain;

import java.io.Serializable;

/**
 * Store generic use's account data.
 */
public class Account extends UserData implements Serializable {
    private String login;
    private String password;

    public Account() {
    }

    public Account(Integer id, String login, String password) {
        setId(id);
        this.login = login;
        this.password = password;
    }

    public Account(String name, String surname, Integer id, String nationality, Integer age, Double wage, String login, String password) {
        super(name, surname, id, nationality, age, wage);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
