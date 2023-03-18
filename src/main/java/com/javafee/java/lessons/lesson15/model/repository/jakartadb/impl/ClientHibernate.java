package com.javafee.java.lessons.lesson15.model.repository.jakartadb.impl;

import com.javafee.java.lessons.lesson15.model.entity.Client;
import com.javafee.java.lessons.lesson15.model.repository.jakartadb.HibernateConfig;

import java.util.List;
import java.util.stream.Collectors;

public class ClientHibernate extends HibernateConfig<Client> {
    @Override
    public List<Client> findByFilter(Client clientToFilter) {
        return getSession().createQuery(buildQuery(clientToFilter)).stream().collect(Collectors.toList());
    }

    private String buildQuery(com.javafee.java.lessons.lesson15.model.domain.Client client) {
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

    private boolean isNumber(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
