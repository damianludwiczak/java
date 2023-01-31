package com.javafee.java.lessons.lesson15.model.repository;

import java.io.*;

public class DAO<T> {
    public T findAll(String path) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
            Object obj = inputStream.readObject();
            return (T) obj;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void saveAll(String path, T data) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outputStream.writeObject(data);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
