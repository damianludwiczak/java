package com.javafee.java.lessons.lesson15.model.repository.jdbcdb.impl;

import com.javafee.java.lessons.lesson15.model.domain.Client;
import com.javafee.java.lessons.lesson15.model.domain.Company;
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
            for (Client client: clients)
                client.setCompanyList(CompanyJdbcDb.findById(client.getId()));
            return clients;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAll(List<Client> data) {
        String queryClient = "Insert into client (id, name, surname, nationality, age, wage) values (";
        String queryCompanyClient = "Insert into company_client (id, id_company, id_client) values (nextval('seq_company_client'),";
        try {
            statement.execute("delete from company_client");
            statement.execute("delete from client"); // temporary solution
            for (Client client : data) {
                statement.execute(queryClient + client.getId() + ", '" + client.getName() + "', '"
                        + client.getSurname() + "', '" + client.getNationality() + "', " + client.getAge() + ", " +
                        client.getWage() + ")");
                for (Company company : client.getCompanyList()) {
                    statement.execute(queryCompanyClient + company.getId() + "," + client.getId() + ")");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Client> findById(int idCompany) {
        List<Client> clients = new ArrayList<>();
        String query = "select c.name, c.id, c.surname, c.nationality, c.age, c.wage from client c, (\n" +
                "                select * from company_client cc where id_company = " + idCompany + "\n" +
                "                ) as ccc where ccc.id_client = c.id";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
                clients.add(Orm.getClientMapFunction().apply(Map.of
                        ("name", resultSet.getString("name"),
                                "surname", resultSet.getString("surname"),
                                "id", String.valueOf(resultSet.getInt("id")),
                                "nationality", resultSet.getString("nationality"),
                                "age", String.valueOf(resultSet.getInt("age")),
                                "wage", String.valueOf(resultSet.getFloat("wage"))
                        )));
            return clients;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
