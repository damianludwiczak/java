package com.javafee.java.lessons.lesson15.model.repository.jdbcdb;

import com.javafee.java.lessons.lesson15.model.domain.Company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompanyJdbcDb extends JdbcDb<Company> {
    @Override
    public List<Company> findAll() {
        try {
            ResultSet resultSet = statement.executeQuery("select * from company");
            List<Company> companies = new ArrayList<>();
            while (resultSet.next())
                companies.add(Orm.getCompanyMapFunction().apply(Map.of("name", resultSet.getString("name"),
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

    }
}
