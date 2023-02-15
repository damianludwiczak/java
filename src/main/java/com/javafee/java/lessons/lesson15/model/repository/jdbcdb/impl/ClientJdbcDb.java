package com.javafee.java.lessons.lesson15.model.repository.jdbcdb.impl;

import com.javafee.java.lessons.lesson15.model.domain.Client;
import com.javafee.java.lessons.lesson15.model.repository.jdbcdb.JdbcDb;
import com.javafee.java.lessons.lesson15.model.repository.jdbcdb.Orm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClientJdbcDb extends JdbcDb<Client> {
    @Override
    public List<Client> findAll() {
        // Client client = Orm.getClientMapFunction().apply(null);
        List<Client> clients = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("select * from client");
            while (resultSet.next()) {
                clients.add(Orm.getClientMapFunction().apply(Map.of
                        ("name", resultSet.getString("name"),
                        "surname", resultSet.getString("surname"),
                        "id", String.valueOf(resultSet.getInt("id")),
                                "nationality", resultSet.getString("nationality"),
                                "age", String.valueOf(resultSet.getInt("age")),
                                        "wage", String.valueOf(resultSet.getFloat("wage"))
                                )));
            }
            return clients;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAll(List<Client> data) {

    }
}
