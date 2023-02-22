package com.javafee.java.lessons.lesson15.view.model;

import com.javafee.java.lessons.lesson15.model.domain.Client;
import com.javafee.java.lessons.lesson15.model.domain.Company;
import com.javafee.java.lessons.lesson15.model.repository.Dao;
import com.javafee.java.lessons.lesson15.model.repository.filedb.FileDb;
import com.javafee.java.lessons.lesson15.model.repository.jdbcdb.JdbcDb;
import com.javafee.java.lessons.lesson15.model.repository.jdbcdb.impl.ClientJdbcDb;
import com.javafee.java.lessons.lesson15.service.Utils;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;

public class ClientTableModel extends AbstractTableModel {
    private List<Client> clients;
    private String[] columns;
    private Dao<Client> daoClient;

    public ClientTableModel() {
        daoClient = new ClientJdbcDb(); // new FileDb<>(Utils.CLIENT_FILE);
        prepareData();
        columns = new String[]{"name", "surname", "nationality", "age", "wage", "company"};
    }

    public Client getClient(Integer index) {
        return clients.get(index);
    }

    private void prepareData() {
        clients = daoClient.findAll();
    }

    public void reload() {
        prepareData();
        fireTableDataChanged();
    }

    public void reloadFilterData(Client client) {
        clients = daoClient.findByFilter(client);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return clients.size();
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
        Client client = clients.get(rowIndex);
        return switch (ClientTableColumn.getByIndex(columnIndex)) {
            case COL_NAME -> client.getName();
            case COL_SURNAME -> client.getSurname();
            case COL_NATIONALITY -> client.getNationality();
            case COL_AGE -> client.getAge();
            case COL_WAGE -> client.getWage();
            case COL_COMPANY -> !(client.getCompanyList() == null || client.getCompanyList().isEmpty()) ? client.getCompanyList().toString() : "";
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    enum ClientTableColumn {
        COL_NAME(0), COL_SURNAME(1), COL_NATIONALITY(2), COL_AGE(3), COL_WAGE(4), COL_COMPANY(5);

        private final Integer index;

        ClientTableColumn(final int index) {
            this.index = index;
        }

        public Integer getIndex() {
            return index;
        }

        public static ClientTableColumn getByIndex(Integer index) {
            return Arrays.stream(ClientTableColumn.values()).filter(e -> e.getIndex().equals(index)).findFirst().orElse(null);
        }
    }
}
