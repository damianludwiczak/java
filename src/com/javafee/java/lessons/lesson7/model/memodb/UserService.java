package com.javafee.java.lessons.lesson7.model.memodb;

import java.io.IOException;
import java.util.*;

public class UserService {
    List<User> listUsers = new ArrayList<>();

    public boolean register(User user) throws IOException, NoSuchFieldException {
        if (isExists(user)) {
            return false;
        } else {
            if (listUsers.isEmpty()) {
                user.setId(10000);
            } else {
               User newID = listUsers.stream().max(Comparator.comparing(User::getId)).orElseThrow(NoSuchElementException::new);
               user.setId(newID.getId() + 1);
            }
            //TODO: change to static generator
            listUsers.add(user);
            return true;
        }
    }

    public boolean signIn(User dataFromUser) {
        if (isExists(dataFromUser)) {
            User user = get(dataFromUser);
            return dataFromUser.getPassword().equals(user.getPassword());
        } else {
            return false;
        }
    }

    public User get(User dataFromUser) {
        User outputUser = null;
        for (User user : listUsers) {
            if (user.getLogin().equals(dataFromUser.getLogin())) {
                outputUser = user;
            }
        }
        return outputUser;
    }

    public boolean isExists (User dataFromUser) {
        for (User user1 : listUsers) {
            if (user1.getLogin().equals(dataFromUser.getLogin())) {
                return true;
            }
        }
        return false;
    }
}

