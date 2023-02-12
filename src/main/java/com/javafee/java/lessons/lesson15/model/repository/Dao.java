package com.javafee.java.lessons.lesson15.model.repository;

public interface Dao<T> {
    T findAll();

    void saveAll(T data);
}
