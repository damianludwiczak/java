package com.javafee.java.lessons.lesson15.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;

@Data
@Builder
@Entity
@SequenceGenerator(name = "seq_account", sequenceName = "seq_account", allocationSize = 1)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_account")
    private Integer id;
    private String name;
    private String surname;
    private String nationality;
    private int age;
    private double wage;
    private String login;
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar created;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar lastLogin;
}
