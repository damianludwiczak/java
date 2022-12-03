package com.javafee.java.lessons.lesson12.model.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Store generic use's account data.
 */
public class Account extends UserData implements Serializable {
    private String login;
    private String password;
    private LocalDateTime created;
    private LocalDateTime lastLogin;

    public Account() {
    }

    public Account(String login, String password, LocalDateTime created, LocalDateTime lastLogin) {
        this.login = login;
        this.password = password;
        this.created = created;
        this.lastLogin = lastLogin;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }
}
