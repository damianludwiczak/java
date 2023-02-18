package com.javafee.java.lessons.lesson15.model.repository;

import java.util.List;

public interface Dao<T> {
    List<T> findAll();

    void saveAll(List<T> data);
}
