package com.javafee.java.lessons.CrudApp.model.repository;

import java.util.List;

public interface Dao<T> {
    List<T> findAll();

    void saveAll(List<T> data);

    List<T> findByFilter(T t);
}
