package com.javafee.java.lessons.lesson12.controller;

import com.javafee.java.lessons.lesson12.model.domain.Company;
import com.javafee.java.lessons.lesson12.view.ManagmentCompany;

import java.util.ArrayList;
import java.util.List;

public class CompanyController {
    private ManagmentCompany managmentCompany;
    private List<Company> companyList = new ArrayList<>();

    public CompanyController() {
        managmentCompany = new ManagmentCompany();
    }

    public void manageCompany() {
        init();

    }

    private void init() {
        managmentCompany.getFrame().setVisible(true);
    }
}
