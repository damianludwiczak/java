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

public class CompanyJdbcDb extends JdbcDb<Company> {
    @Override
    public List<Company> findAll() {
        List<Company> companies = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("select * from company");
            while (resultSet.next())
                companies.add(Orm.getCompanyMapFunction().apply(Map.of(
                        "name", resultSet.getString("name"),
                        "id", String.valueOf(resultSet.getInt("id")),
                        "yearlyincomes", String.valueOf(resultSet.getFloat("yearlyincomes"))
                )));
            for (Company company: companies)
                company.setClientList(ClientJdbcDb.findById(company.getId()));
            return companies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Company> findById(int idClient) {
        List<Company> companies = new ArrayList<>();
        String query = "select c.name, c.id, c.yearlyincomes from company c, (\n" +
                "                select * from company_client cc where id_client = " + idClient + "\n" +
                "                ) as ccc where ccc.id_company = c.id";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
                companies.add(Orm.getCompanyMapFunction().apply(Map.of(
                        "name", resultSet.getString("name"),
                        "id", String.valueOf(resultSet.getInt("id")),
                        "yearlyincomes", String.valueOf(resultSet.getFloat("yearlyincomes"))
                )));
            return companies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAll(List<Company> data) {
        String query = "Insert into company (id, name, yearlyincomes) values (";
        String queryCompanyClient = "Insert into company_client (id, id_company, id_client) values (nextval('seq_company_client'),";
        try {
            statement.execute("delete from company_client");
            statement.execute("delete from company"); // temporary solution
            for (Company company : data) {
                statement.execute(query + company.getId() + ", '" + company.getName() + "', "
                        + company.getYearlyIncomes() + ")");
                for (Client client : company.getClientList()) {
                    statement.execute(queryCompanyClient + company.getId() + "," + client.getId() + ")");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Company> findByFilter(Company company) {
        return null;
    }
}
