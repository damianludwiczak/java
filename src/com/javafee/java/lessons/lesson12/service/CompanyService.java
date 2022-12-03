package com.javafee.java.lessons.lesson12.service;

import com.javafee.java.lessons.lesson12.model.domain.Company;
import com.javafee.java.lessons.lesson12.model.repository.DAO;

import java.util.ArrayList;
import java.util.List;

public class CompanyService {
    public DAO<Company[]> companyDao;
    List<Company> companyList = new ArrayList<>();

    public CompanyService() {
        companyDao = new DAO<>();
    }

    public Company findByName(String name){
       companyList = List.of(companyDao.findAll(Utils.COMPANY_FILE));
       for (Company company : companyList) {
           if(company.getName().equals(name)){
               return company;
           }
       }
       return null;
       // return (Company) companyList.stream().filter(e -> e.getName().equals(name));
    }
}
