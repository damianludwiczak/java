package com.javafee.java.lessons.CrudApp.model.repository.jdbcdb.impl;

import com.javafee.java.lessons.CrudApp.model.domain.Account;
import com.javafee.java.lessons.CrudApp.model.repository.jdbcdb.JdbcDb;
import com.javafee.java.lessons.CrudApp.model.repository.jdbcdb.Orm;

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
                        "password", resultSet.getString("password")
                )));
            return accountList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAll(List<Account> data) {
        String query = "Insert into account (id, login, password) values (";
        try {
            statement.execute("delete from account"); // temporary solution
            for (Account account : data) {
                System.out.println(query + account.getId() + ", '" + account.getLogin() + "', '"
                        + account.getPassword() + ")");
                statement.execute(query + account.getId() + ", '" + account.getLogin() + "', '"
                        + account.getPassword() + "')");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Account> findByFilter(Account account) {
        return null;
    }
}
