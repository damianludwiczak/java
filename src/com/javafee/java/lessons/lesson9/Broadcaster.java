package com.javafee.java.lessons.lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Broadcaster implements Broadcast {
    private String name;
    List<News> newsList = new ArrayList<>();

    public Broadcaster(String name) {
        this.name = name;
    }

    public void broadcast(News news) {
        newsList.add(news);
        Map<String, Long> counted = newsList.stream().map(News::getAuthor).toList()
                .stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // BBC -> 3
        // CNN -> 5
        // SkyNews -> 6
        Long countForNewsAgency = counted.get(news.getAuthor());
        System.out.println(name + " " + countForNewsAgency + "\n" + news);
    }
}
