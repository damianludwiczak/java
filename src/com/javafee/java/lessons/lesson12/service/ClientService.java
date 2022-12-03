package com.javafee.java.lessons.lesson12.service;

import com.javafee.java.lessons.lesson12.model.domain.Account;
import com.javafee.java.lessons.lesson12.model.domain.Client;
import com.javafee.java.lessons.lesson12.model.domain.UserData;
import com.javafee.java.lessons.lesson12.model.repository.DAO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClientService {
    DAO<Client[]> dao = new DAO<>();
    List<Client> clientList = new ArrayList<>();

    public Client findById(Integer id) {
        clientList = List.of(dao.findAll(Utils.CLIENT_FILE));
        for (Client client : clientList ) {
            if(client.getId().equals(id)) {
                return client;
            }
        }
        return null;
    }

    public Integer findMaxId() {
        clientList = List.of(dao.findAll(Utils.CLIENT_FILE));
        Client client = clientList.stream().max(Comparator.comparingInt(UserData::getId)).orElse(null);
        return client.getId();
    }
}
