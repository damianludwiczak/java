package com.javafee.java.lessons.lesson15.model.repository.filedb.imp;

import com.javafee.java.lessons.lesson15.model.entity.Client;
import com.javafee.java.lessons.lesson15.model.entity.Company;
import com.javafee.java.lessons.lesson15.model.repository.filedb.FileDb;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClientFileDb extends FileDb<Client> {
    public ClientFileDb(String path) {
        super(path);
    }
    @Override
    public List<Client> findByFilter(Client client) {
        List<Client> clientstList = (List<Client>) findAll();
        List<Client> returnList =  clientstList;
        Client clientToFilter = replacePerCent(client);

        returnList = !clientToFilter.getName().isEmpty() ? returnList.stream().filter(
                e -> e.getName().contains(clientToFilter.getName())).collect(Collectors.toList()) : returnList;
        returnList = !clientToFilter.getSurname().isEmpty() ? returnList.stream().filter(
                e -> e.getSurname().contains(clientToFilter.getSurname())).collect(Collectors.toList()) : returnList;
        returnList = !clientToFilter.getNationality().isEmpty() ? returnList.stream().filter(
                e -> e.getNationality().contains(clientToFilter.getNationality())).collect(Collectors.toList()) : returnList;

        returnList = !clientToFilter.getAgeFrom().isEmpty() ? returnList.stream().filter(
                e -> e.getAge() >= Integer.parseInt(clientToFilter.getAgeFrom())).collect(Collectors.toList()) : returnList;
        returnList = !clientToFilter.getAgeTo().isEmpty() ? returnList.stream().filter(
                e -> e.getAge() <= Integer.parseInt(clientToFilter.getAgeTo())).collect(Collectors.toList()) : returnList;
        returnList = !clientToFilter.getWageFrom().isEmpty() ? returnList.stream().filter(
                e -> e.getWage() >= Integer.parseInt(clientToFilter.getWageFrom())).collect(Collectors.toList()) : returnList;
        returnList = !clientToFilter.getWageTo().isEmpty() ? returnList.stream().filter(
                e -> e.getWage() <= Integer.parseInt(clientToFilter.getWageTo())).collect(Collectors.toList()) : returnList;
        if(!clientToFilter.getCompanyList().get(0).getName().isEmpty()) {
            List<Client> newClientList = new ArrayList<>();
            for(Client clientInForeach : returnList)
                for (Company company : clientInForeach.getCompanyList())
                    if (company.getName().contains(clientToFilter.getCompanyList().get(0).getName()))
                        newClientList.add(clientInForeach);
            return newClientList;
        }
        return returnList;
    }

    @Override
    public List<Client> findAll(Class<?> clazz) {
        return null;
    }

    private Client replacePerCent(Client client) {
        client.setName(client.getName().replaceAll("%", ""));
        client.setSurname(client.getSurname().replaceAll("%", ""));
        client.setNationality(client.getNationality().replaceAll("%", ""));
        client.getCompanyList().get(0).setName(client.getCompanyList().get(0).getName().replaceAll("%",""));
        return client;
    }
}
