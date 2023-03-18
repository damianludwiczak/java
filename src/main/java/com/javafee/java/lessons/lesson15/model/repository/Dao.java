package com.javafee.java.lessons.lesson15.model.repository;

import java.util.List;
import java.util.stream.Collectors;

public interface Dao<T> {
    List<T> findAll();

    void saveAll(List<T> data);

    List<T> findByFilter(T t);
    List<T> findAll(Class<?> clazz);
}
