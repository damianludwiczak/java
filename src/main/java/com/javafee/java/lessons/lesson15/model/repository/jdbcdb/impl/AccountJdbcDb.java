package com.javafee.java.lessons.lesson15.model.repository.jdbcdb.impl;

import com.javafee.java.lessons.lesson15.model.domain.Account;
import com.javafee.java.lessons.lesson15.model.domain.Company;
import com.javafee.java.lessons.lesson15.model.repository.jdbcdb.JdbcDb;
import com.javafee.java.lessons.lesson15.model.repository.jdbcdb.Orm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountJdbcDb extends JdbcDb<Account> {

    @Override
    public List<Account> findAll() {
        List<Account> accountList = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("select * from account");
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
        String query = "Insert into account (id, login, password, created, lastlogin) values (";
        try {
            statement.execute("delete from account"); // temporary solution
            for (Account account : data)
                System.out.println(query + account.getId() + ", '" + account.getLogin() + "', '"
                        + account.getPassword() + "', " + account.getCreated() + ", " + account.getLastLogin() +")");
//                statement.execute(query + account.getId() + ", '" + account.getLogin() + "', '"
//                        + account.getPassword() + "', " + account.getCreated() + ", " + account.getLastLogin() +")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
