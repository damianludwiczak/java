package com.javafee.java.lessons.lesson15.model;

import java.time.LocalDateTime;

/**
 * Store generic use's account data.
 */
public class Account {

    private Integer id;

    private String login;
    private String password;
    private LocalDateTime created;
    private LocalDateTime lastLogin;

    public Account(Integer id, String login, String password, LocalDateTime created, LocalDateTime lastLogin) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.created = created;
        this.lastLogin = lastLogin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}
