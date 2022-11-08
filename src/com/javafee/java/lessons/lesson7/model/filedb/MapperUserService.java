package com.javafee.java.lessons.lesson7.model.filedb;

import java.util.List;
import java.util.stream.Collectors;

public class MapperUserService {
    public List<User> from(List<String> strings) {
        return strings.stream().map(this::from).collect(Collectors.toList());
    }

    public User from(String str) {
        String[] parts = str.split(",");
        return new User(Integer.parseInt(parts[0]), parts[1],parts[2], parts[3]);
    }

    public List<String> to(List<User> users) {
       return users.stream().map(this::to).collect(Collectors.toList());
    }

    public String to(User user) {
        return user.toString();
    }
}
