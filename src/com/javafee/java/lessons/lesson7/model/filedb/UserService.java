package com.javafee.java.lessons.lesson7.model.filedb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<User> listUsers = new ArrayList<>();
    FileUserService fileService = new FileUserService();
    MapperUserService mapperUserService = new MapperUserService();
    public void addUser(User user) throws IOException {
        if (isUserExists(user)) {

        } else {
            listUsers.add(user);
        }
    }

    public boolean isUserExists(User user) throws IOException {
        List<User> listUsers = mapperUserService.from(fileService.read());
        for(User user1: listUsers) {
            if(user1.getId() == user.getId()) {
                return true;
            }
        }
        return false;
    }
}
