package com.javafee.java.lessons.lesson7.model.memodb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserService {
    List<User> listUsers = new ArrayList<>();

    public boolean register(User user) {
        Random random = new Random();
        if (isExists(user)) {
            return false;
        } else {
            user.setId(String.valueOf(random.nextInt(0,10000)));
            listUsers.add(user);
            return true;
        }
    }

    public boolean signIn(User dataFromUser) {
        if (isExists(dataFromUser)) {
            User user = get(dataFromUser);
            return (dataFromUser.getPassword().equals(user.getPassword())) ? true: false;
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

