package com.javafee.java.lessons.lesson7.model.filedb;

import com.javafee.java.lessons.lesson7.model.memodb.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class MapperService {
    public List<Transaction> from(List<String> strings) {
        return strings.stream().map(this::from).collect(Collectors.toList());
    }

    public List<String> to(List<Transaction> transactions) {
        return transactions.stream().map(this::to).collect(Collectors.toList());
    }

    public Transaction from(String str) {
        String[] parts = str.split(",");
        return new Transaction(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
                                                                                            Integer.parseInt(parts[3]));
    }

    public String to(Transaction transaction) {
        return transaction.toString();
    }
}
