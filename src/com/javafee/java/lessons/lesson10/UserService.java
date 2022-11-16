package com.javafee.java.lessons.lesson10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class UserService {
    List<User> listUsers = new ArrayList<>();
    FileUserService fileUserService = new FileUserService();
    MapperUser mapperUser = new MapperUser();

    public UserService() {
        this.listUsers = initFile();
    }

    public boolean isExists(String name){
        listUsers = initFile();
        for (User user: listUsers) {
            if(user.getName().equals(name))
                return true;
        }
        return false;
    }

    public User getUser(String name){
        listUsers = initFile();
        for (User user: listUsers) {
            if(user.getName().equals(name))
                return user;
        }
        return null;
    }

    public User addUser(User user) throws IOException {
        if (listUsers.isEmpty())
            user.setId(10000);
        else {
            User newID = listUsers.stream().max(Comparator.comparing(User::getId)).orElseThrow(NoSuchElementException::new);
            user.setId(newID.getId() + 1);
        }
        listUsers.add(user);
        fileUserService.save(mapperUser.to(listUsers));
        return user;
    }

    public void save() throws IOException {
        fileUserService.save(mapperUser.to(listUsers));
    }

    private List<User> initFile() {
        try {
            return mapperUser.from(fileUserService.read());
        } catch (IOException e) {
            return null;
        }
    }
}
