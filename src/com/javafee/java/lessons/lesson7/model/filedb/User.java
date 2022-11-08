package com.javafee.java.lessons.lesson7.model.filedb;

public class User {
    private int id;
    private String login;
    private String password;
    private String accountType;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String accountType) {
        this.login = login;
        this.password = password;
        this.accountType = accountType;
    }

    public User(int id, String login, String password, String accountType) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return id + "," + login + "," + password + "," + accountType;
    }
    public String getAccountType() { return accountType; }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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
}
