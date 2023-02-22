package com.javafee.java.lessons.lesson15.model.repository.jdbcdb;

import com.javafee.java.lessons.lesson15.model.repository.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class JdbcDb<T> implements Dao<T> {
    private static Connection connection;
    protected static Statement statement;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-crm?user=postgres&password=admin123");
            statement = connection.createStatement();
            System.out.println("connected to: " + connection.getMetaData().getDatabaseProductName() + " v"
                    + connection.getMetaData().getDatabaseProductVersion());
        } catch (SQLException e) {
            System.err.println("connection failed: " + e.getMessage());
        }
    }

    @Override
    public abstract List<T> findAll();

    @Override
    public abstract void saveAll(List<T> data);

    @Override
    public abstract List<T> findByFilter(T t);
}
