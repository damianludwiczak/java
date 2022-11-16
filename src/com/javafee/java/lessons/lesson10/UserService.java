package com.javafee.java.lessons.lesson10;


import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<User> listUsers = new ArrayList<>();
    FileUserService fileUserService = new FileUserService();
    MapperUser mapperUser = new MapperUser();

    public UserService() {
        this.listUsers = initFile();
    }

    public void addUser(User user) {
        listUsers.add(user);
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
