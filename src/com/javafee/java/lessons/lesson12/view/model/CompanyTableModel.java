package com.javafee.java.lessons.lesson12.view.model;

import com.javafee.java.lessons.lesson12.model.domain.Client;
import com.javafee.java.lessons.lesson12.model.domain.Company;
import com.javafee.java.lessons.lesson12.model.repository.DAO;
import com.javafee.java.lessons.lesson12.service.Utils;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CompanyTableModel extends AbstractTableModel {
    private List<Company> companies;
    private String[] columns;
    private DAO<Company[]> clientDAO;

    public CompanyTableModel() {
        clientDAO = new DAO<>();
        prepareData();
        columns = new String[]{"name", "Yearly Incomes"};
    }

    private void prepareData() {
        companies = new ArrayList<>(List.of(clientDAO.findAll(Utils.COMPANY_FILE)));
    }

    public Company getClient(Integer index) {
        return companies.get(index);
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

