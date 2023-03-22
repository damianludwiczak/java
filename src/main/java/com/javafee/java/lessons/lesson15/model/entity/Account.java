package com.javafee.java.lessons.lesson15.model.entity;

import javax.persistence.*;
import java.util.Calendar;


@Entity
@Table(name = "account")
@SequenceGenerator(name = "seq_account", sequenceName = "seq_account", allocationSize = 1)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_account")
    @Column(name = "id")
    private Integer id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Calendar created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastlogin")
    private Calendar lastLogin;

    public Account() {
    }

    public Account(Integer id, String login, String password, Calendar created, Calendar lastLogin) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.created = created;
        this.lastLogin = lastLogin;
    }

    public Account(Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public Calendar getCreated() {
        return created;
    }

    public Calendar getLastLogin() {
        return lastLogin;
    }
}
