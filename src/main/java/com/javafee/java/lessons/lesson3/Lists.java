package com.javafee.java.lessons.lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Lists {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3"};
        // add new element to the array that is out of bound
        String[] arrEx = new String[arr.length + 1];
        for (int i = 0; i < arr.length; i++)
            arrEx[i] = arr[i];
        arrEx[arr.length] = "4";
        for (String str : arrEx)
            System.out.print(str + " ");

        List<String> stringsList = new ArrayList<>();

        // add element
        stringsList.add("Ala");
        stringsList.add("Ania");
        stringsList.add("Artur");
        stringsList.add("Anastazja");
        stringsList.add("Andrzej");
        stringsList.add("Bartosz");
        stringsList.add("Daria");
        stringsList.add("Kamila");
        stringsList.add("Tomasz");

        // add element to index
        stringsList.add(1, "Damian");

        // get element
        System.out.println(stringsList.get(2));

        // remove element
        stringsList.remove("Ala");
        stringsList.remove(0);

        // size
        System.out.print(stringsList.size());

        // iterate
        for (String str : stringsList)
            System.out.print(str + " ");
        // *
        stringsList.forEach(System.out::println);
        System.out.println("Filtering =============================");
        stringsList.stream().filter(e -> e.startsWith("A")).map(String::toUpperCase).toList().forEach(System.out::println);

        List<Integer> integerList = new ArrayList<>(10);
        Random r = new Random();
        for(int i = 0; i < 20; i++)
            integerList.add(r.nextInt(10));

        integerList.forEach(System.out::println);
    }
}
