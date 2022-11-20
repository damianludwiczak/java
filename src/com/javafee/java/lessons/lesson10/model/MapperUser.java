package com.javafee.java.lessons.lesson10.model;

import java.util.List;
import java.util.stream.Collectors;

public class MapperUser {
    public List<User> from(List<String> strings) {
        return strings.stream().map(e -> from(e)).collect(Collectors.toList());
    }

    public User from(String str) {
        String[] parts = str.split(",");
        return new User(Integer.parseInt(parts[0]), parts[1]);
    }

    public List<String> to(List<User> listUsers) {
        return listUsers.stream().map(e -> to(e)).collect(Collectors.toList());
    }

    public String to (User user){
        return user.toString();
    }
}
