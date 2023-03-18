package com.javafee.java.lessons.lesson15.model.repository.jakartadb.impl;

import com.javafee.java.lessons.lesson15.model.entity.Company;
import com.javafee.java.lessons.lesson15.model.repository.jakartadb.HibernateConfig;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyHibernate extends HibernateConfig<Company> {
    @Override
    public List<Company> findByFilter(Company company) {
        getSession().createQuery(buildQuery(company)).stream().collect(Collectors.toList());
    }

    private String buildQuery(com.javafee.java.lessons.lesson15.model.domain.Company company) {
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
