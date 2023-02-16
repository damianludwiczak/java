package com.javafee.java.lessons.lesson15.model.repository.jdbcdb;

import com.javafee.java.lessons.lesson15.model.domain.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountJdbcDb extends JdbcDb<Account> {

    @Override
    public List<Account> findAll() {
        try {
            ResultSet resultSet = statement.executeQuery("select * from account");
            List<Account> accountList = new ArrayList<>();
            while (resultSet.next())
                accountList.add(Orm.getAccountMapFunction().apply(Map.of(
                        "id", String.valueOf(resultSet.getString("id")),
                        "login", resultSet.getString("login"),
                        "password", resultSet.getString("password"),
                        "created", String.valueOf(resultSet.getTimestamp("created").toLocalDateTime()),
                        "lastlogin", String.valueOf(resultSet.getTimestamp("lastlogin").toLocalDateTime())
                )));
            return accountList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAll(List<Account> data) {

    }
}
