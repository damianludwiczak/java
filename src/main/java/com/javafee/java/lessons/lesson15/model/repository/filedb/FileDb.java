package com.javafee.java.lessons.lesson15.model.repository.filedb;

import com.javafee.java.lessons.lesson15.model.repository.Dao;

import java.io.*;
import java.util.List;

public class FileDb<T> implements Dao<T> {
    private String path;

    public FileDb(String path) {
        this.path = path;
    }

    public List<T> findAll() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
            Object obj = inputStream.readObject();
            return (List<T>) obj;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void saveAll(List<T> data) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outputStream.writeObject(data);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
