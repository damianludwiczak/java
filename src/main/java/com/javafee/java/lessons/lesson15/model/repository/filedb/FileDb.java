package com.javafee.java.lessons.lesson15.model.repository.filedb;

import com.javafee.java.lessons.lesson15.model.repository.Dao;

import java.io.*;

public class FileDb<T> implements Dao<T> {
    private String path;

    public FileDb(String path) {
        this.path = path;
    }

    public T findAll() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
            Object obj = inputStream.readObject();
            return (T) obj;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void saveAll(T data) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outputStream.writeObject(data);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
