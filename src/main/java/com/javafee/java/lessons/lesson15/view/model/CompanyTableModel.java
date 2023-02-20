package com.javafee.java.lessons.lesson15.view.model;

import com.javafee.java.lessons.lesson15.model.domain.Company;
import com.javafee.java.lessons.lesson15.model.repository.Dao;
import com.javafee.java.lessons.lesson15.model.repository.jdbcdb.impl.CompanyJdbcDb;


import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;


public class CompanyTableModel extends AbstractTableModel {
    private List<Company> companies;
    private String[] columns;
    // private FileDb<Company> companyFileDb;
    private Dao<Company> companyDao;

    public CompanyTableModel() {
        companyDao =  new CompanyJdbcDb(); // new FileDb<>(Utils.COMPANY_FILE);
        prepareData();
        columns = new String[]{"Name", "Yearly Incomes", "Client List"};
    }

    public Company getCompany(Integer index) {
        return companies.get(index);
    }

    public List<Company> getCompanies() {
        return companies;
    }

    private void prepareData() {
        companies = companyDao.findAll();
    }

    public void reload() {
        prepareData();
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return companies.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Company company = companies.get(rowIndex);
        return switch (CompanyTableColumn.getByIndex(columnIndex)) {
            case COMPANY_NAME -> company.getName();
            case COMPANY_YEARLY_INCOMES -> company.getYearlyIncomes();
            case COMPANY_LIST_CLIENT -> company.getClientList();
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    enum CompanyTableColumn {
        COMPANY_NAME(0), COMPANY_YEARLY_INCOMES(1), COMPANY_LIST_CLIENT(2);

        private final Integer index;

        CompanyTableColumn(final int index) {
            this.index = index;
        }

        public Integer getIndex() {
            return index;
        }

        public static CompanyTableColumn getByIndex(Integer index) {
            return Arrays.stream(CompanyTableColumn.values()).filter(e -> e.getIndex().equals(index)).findFirst().orElse(null);
        }
    }
}

