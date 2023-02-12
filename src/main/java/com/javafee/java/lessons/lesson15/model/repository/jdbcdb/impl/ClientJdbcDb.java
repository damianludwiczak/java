package com.javafee.java.lessons.lesson15.model.repository.jdbcdb.impl;

import com.javafee.java.lessons.lesson15.model.domain.Client;
import com.javafee.java.lessons.lesson15.model.repository.jdbcdb.JdbcDb;
import com.javafee.java.lessons.lesson15.model.repository.jdbcdb.Orm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientJdbcDb extends JdbcDb<List<Client>> {
    @Override
    public List<Client> findAll() {
        // Client client = Orm.getClientMapFunction().apply(null);
        List<Client> clients = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("select * from client");
            Map<String, String> map = new HashMap<>();
            while (resultSet.next()) {
                map.put("name", resultSet.getString("name"));
                map.put("surname", resultSet.getString("surname"));
                map.put("nationality", resultSet.getString("nationality"));
                map.put("age", resultSet.getString("age"));
                map.put("wage", resultSet.getString("wage"));
                clients.add(Orm.getClientMapFunction().apply(map));
            }
        } catch (SQLException e) {
            System.err.println("Query failed: " + e.getMessage());
        }
        return clients;
    }

    @Override
    public void saveAll(List<Client> data) {

    }
}
