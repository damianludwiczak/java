package com.javafee.java.lessons.lesson15.model.repository.jdbcdb;

import com.javafee.java.lessons.lesson15.model.domain.Client;
import com.javafee.java.lessons.lesson15.model.domain.Account;
import com.javafee.java.lessons.lesson15.model.domain.Company;
import com.javafee.java.lessons.lesson15.model.domain.UserData;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.function.Function;

public class Orm {
    private static Function<Map<String, String>, Client> clientMapFunction;

    public static Function<Map<String, String>, Client> getClientMapFunction() {
        return (map) -> new Client(map.get("name"), map.get("surname"), Integer.parseInt(map.get("id")), map.get("nationality"),
                Integer.parseInt(map.get("age")), Double.parseDouble(map.get("wage")), null);
    }

    public static Function<Map<String, String>, Account> getAccountMapFunction() {
        return (map) -> new Account(map.get("login"), map.get("password"), LocalDateTime.parse(map.get("created")),
                LocalDateTime.parse(map.get("lastLogin")));
    }

    public static Function<Map<String, String>, Company> getCompanyMapFunction() {
        return (map) -> new Company(map.get("name"), Integer.parseInt(map.get("id")),
                Double.parseDouble(map.get("yearlyincomes")));
    }

    public static Function<Map<String, String>, UserData> getUserDataMapFunction() {
        return (map) -> new UserData(map.get("name"), map.get("surname"), Integer.parseInt(map.get("id")),
                map.get("nationality"), Integer.parseInt(map.get("age")), Double.parseDouble(map.get("wage")));
    }
}
