package com.javafee.java.lessons.lesson7.model.filedb;

import java.io.IOException;
import java.util.*;

public class UserService {
    List<User> listUsers = new ArrayList<>();
    FileUserService fileService = new FileUserService();
    MapperUserService mapperUserService = new MapperUserService();

    public boolean register(User user) throws IOException, NoSuchFieldException {
        Random random = new Random();
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
            fileService.save(mapperUserService.to(listUsers));
            return true;
        }
    }

    public UserService() {
        this.listUsers = initFile();
    }

    private List<User> initFile() {
        try {
            return mapperUserService.from(fileService.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean signIn(User dataFromUser) throws IOException {
        if (isExists(dataFromUser)) {
            User user = get(dataFromUser);
            return dataFromUser.getPassword().equals(user.getPassword());
        } else {
            return false;
        }
    }

    public User get(User dataFromUser) throws IOException {
        User outputUser = null;
        List<User> listUsers = initFile();
        for (User user : listUsers) {
            if (user.getLogin().equals(dataFromUser.getLogin())) {
                outputUser = user;
            }
        }
        return outputUser;
    }

    public boolean isExists (User dataFromUser) throws IOException {
        List<User> listUsers = initFile();
        for (User user1 : listUsers) {
            if (user1.getLogin().equals(dataFromUser.getLogin())) {
                return true;
            }
        }
        return false;
    }
}

