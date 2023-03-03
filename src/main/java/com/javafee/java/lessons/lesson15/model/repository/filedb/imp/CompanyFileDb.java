package com.javafee.java.lessons.lesson15.model.repository.filedb.imp;

import com.javafee.java.lessons.lesson15.model.domain.Company;
import com.javafee.java.lessons.lesson15.model.repository.filedb.FileDb;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyFileDb extends FileDb<Company> {
    public CompanyFileDb(String path) {
        super(path);
    }

    @Override
    public List<Company> findByFilter(Company company) {
        List<Company> companyList = (List<Company>) findAll();
        List<Company> returnList =  companyList;
        Company companyToFilter = replacePerCent(company);

        returnList = !companyToFilter.getName().isEmpty() ? returnList.stream().filter( // TODO: 02.03.2023 handle NumberFormatExcaeption 
                e -> e.getName().contains(companyToFilter.getName())).collect(Collectors.toList()) : returnList;
        returnList = !companyToFilter.getYearlyIncomesFrom().isEmpty() ? returnList.stream().filter(
                e -> e.getYearlyIncomes() >= Integer.parseInt(companyToFilter.getYearlyIncomesFrom())).collect(Collectors.toList()) : returnList;
        returnList = !companyToFilter.getYearlyIncomesTo().isEmpty() ? returnList.stream().filter(
                e -> e.getYearlyIncomes() <= Integer.parseInt(companyToFilter.getYearlyIncomesTo())).collect(Collectors.toList()) : returnList;
        return returnList;
    }

    private Company replacePerCent(Company company) {
        company.setName(company.getName().replaceAll("%", ""));
        return company;
    }
}
