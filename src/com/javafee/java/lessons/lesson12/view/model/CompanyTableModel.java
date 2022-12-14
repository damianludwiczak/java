package com.javafee.java.lessons.lesson12.view.model;

import com.javafee.java.lessons.lesson12.model.domain.Company;
import com.javafee.java.lessons.lesson12.model.repository.DAO;
import com.javafee.java.lessons.lesson12.service.Utils;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CompanyTableModel extends AbstractTableModel {
    private List<Company> companies;
    private String[] columns;
    private DAO<Company[]> companyDAO;

    public CompanyTableModel() {
        companyDAO = new DAO<>();
        prepareData();
        columns = new String[]{"Name", "Yearly Incomes"};
    }

    public Company getCompany(Integer index) {
        return companies.get(index);
    }

    private void prepareData() {
        companies = new ArrayList<>(List.of(companyDAO.findAll(Utils.COMPANY_FILE)));
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
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    enum CompanyTableColumn {
        COMPANY_NAME(0), COMPANY_YEARLY_INCOMES(1);

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
