package com.javafee.java.lessons.lesson15.model.repository.jdbcdb.impl;

import com.javafee.java.lessons.lesson15.model.entity.Client;
import com.javafee.java.lessons.lesson15.model.entity.Company;
import com.javafee.java.lessons.lesson15.model.repository.jdbcdb.JdbcDb;
import com.javafee.java.lessons.lesson15.model.repository.jdbcdb.Orm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
                if (!(Objects.isNull(company.getClientList()) || company.getClientList().isEmpty()))
                    for (Client client : company.getClientList()) {
                        System.out.println(queryCompanyClient + company.getId() + "," + client.getId() + ")");
                        statement.execute(queryCompanyClient + company.getId() + "," + client.getId() + ")");
                    }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Company> findByFilter(Company fiterCompany) {
        List<Company> companies = new ArrayList<>();
        String query = buildQuery(fiterCompany);
        System.out.println(query);
        try {
            ResultSet resultSet = statement.executeQuery(query);
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
    private String buildQuery(Company company) {
        String query = "";
        String helpQuery = "select c.name, c.id, c.yearlyincomes from company c where ";
        String printAll = "select * from company";

        query = company.getName().isEmpty() ? helpQuery : helpQuery + "name like '" + company.getName() + "' and";
        if (!(company.getYearlyIncomesFrom().isEmpty()) || (!company.getYearlyIncomesTo().isEmpty())) {
            company.setYearlyIncomesFrom(company.getYearlyIncomesFrom().isEmpty() || (!isNumber(company.getYearlyIncomesFrom())) ?
                    "0" : company.getYearlyIncomesFrom());
            company.setYearlyIncomesTo(company.getYearlyIncomesTo().isEmpty() || (!isNumber(company.getYearlyIncomesTo())) ?
                    String.valueOf(Double.MAX_VALUE) : company.getYearlyIncomesTo());
            query += " (yearlyincomes between " + company.getYearlyIncomesFrom() + " and " + company.getYearlyIncomesTo() + ") and";
        }
        int length = query.length();
        query = query.endsWith("and") ? query.substring(0,length - 3) : query;
        query = query.endsWith("where ") ? query.substring(0,length - 6) : query;
        query = query.equals(helpQuery) ? printAll : query;
        return query;
    }

    private boolean isNumber(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
