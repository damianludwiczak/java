package com.javafee.java.lessons.CrudApp.model.repository.jdbcdb.impl;

import com.javafee.java.lessons.CrudApp.model.domain.Client;
import com.javafee.java.lessons.CrudApp.model.domain.Company;
import com.javafee.java.lessons.CrudApp.model.repository.jdbcdb.JdbcDb;
import com.javafee.java.lessons.CrudApp.model.repository.jdbcdb.Orm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
                if (!(Objects.isNull(client.getCompanyList()) || client.getCompanyList().isEmpty()))
                    for (Company company : client.getCompanyList())
                        statement.execute(queryCompanyClient + company.getId() + "," + client.getId() + ")");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Client> findByFilter(Client clientToFilter) {
        List<Client> clients = new ArrayList<>();
        String query = buildQuery(clientToFilter);
        System.out.println(query);
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
            for (Client client: clients)
                client.setCompanyList(CompanyJdbcDb.findById(client.getId()));
            return clients;
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

    private String buildQuery(Client client) {
        String query = "";
        String helpQuery = "select c.name, c.id, c.surname, c.nationality, c.age, c.wage from client c where ";
        String printAll = "select * from client";
        String baseCompanyName = "(\nselect cl.id, cl.name, cl.surname, cl.nationality, cl.age, cl.wage from client cl, (\n" +
                "\t\tselect cc.id, cc.id_company, cc.id_client  from company_client cc, (\n" +
                "\t\t\tselect co.id from company co\n" +
                "\t\t\twhere co.\"name\" like '" + client.getCompanyList().get(0).getName() + "'\n" +
                "\t\t) as coo \t\n" +
                "\t\twhere coo.id = cc.id_company\n" +
                "\t) as ccl where ccl.id_client = cl.id\n" +
                ") as c";

        query = client.getName().isEmpty() ? helpQuery : helpQuery + "name like '" + client.getName() + "' and";
        query = client.getSurname().isEmpty() ? query : query + " surname like '" + client.getSurname() + "' and";
        query = client.getNationality().isEmpty() ? query : query + " nationality like '" + client.getNationality() + "' and";
        if (!(client.getAgeFrom().isEmpty()) || (!client.getAgeTo().isEmpty())) {
            client.setAgeFrom(client.getAgeFrom().isEmpty() || (!isNumber(client.getAgeFrom())) ? "0" : client.getAgeFrom());
            client.setAgeTo(client.getAgeTo().isEmpty() || (!isNumber(client.getAgeTo())) ?
                    String.valueOf(Integer.MAX_VALUE) : client.getAgeTo());
            query += " (age between " + client.getAgeFrom() + " and " + client.getAgeTo() + ") and";
        }
        if (!(client.getWageFrom().isEmpty()) || (!client.getWageTo().isEmpty())) {
            client.setWageFrom(client.getWageFrom().isEmpty() || (!isNumber(client.getWageFrom())) ?  "0" : client.getWageFrom());
            client.setWageTo(client.getWageTo().isEmpty() || (!isNumber(client.getWageTo())) ?
                    String.valueOf(Integer.MAX_VALUE) : client.getWageTo());
            query += " (wage between " + client.getWageFrom() + " and " + client.getWageTo() + ") and";
        }
        if (!client.getCompanyList().get(0).getName().isEmpty()) {
            query = query.replaceFirst("client c", baseCompanyName);
        }

        int length = query.length();
        query = query.endsWith("and") ? query.substring(0,length - 3) : query;
        query = query.endsWith("where ") ? query.substring(0,length - 6) : query;
        query = query.equals(helpQuery) ? printAll : query;
        return query;
    }

    private String buildBaseQuery(String from, String to) {
        return  "(\nselect cl.id, cl.name, cl.surname, cl.nationality, cl.age, cl.wage from client cl, (\n" +
                "\t\tselect cc.id, cc.id_company, cc.id_client  from company_client cc, (\n" +
                "\t\t\tselect co.id from company co\n" +
                "\t\t\twhere co.yearlyincomes between " + from + " and " + to + "\n" +
                "\t\t) as coo \t\n" +
                "\t\twhere coo.id = cc.id_company\n" +
                "\t) as ccl where ccl.id_client = cl.id\n" +
                ") as c";
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
