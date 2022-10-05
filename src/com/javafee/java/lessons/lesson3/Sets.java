package com.javafee.java.lessons.lesson3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sets {
    public static void main(String[] args) {
        Set<String> stringsSet = new HashSet<>();

        // add element
        stringsSet.add("Ania");
        stringsSet.add("Bartosz");
        stringsSet.add("Cecylia");
        stringsSet.add("Cecylia");
        stringsSet.add("Cecylia");
        stringsSet.add("Cecylia");
        stringsSet.add("Hieronim");
        stringsSet.add("Gusław");
        stringsSet.add("Jadwiga");
        stringsSet.add("Hryzostom");
        stringsSet.add("Hryzostom");
        stringsSet.add("Hryzostom");

        // size
        System.out.println(stringsSet.size());

        // add element to index
        // NOT ALLOWED!!!

        // get element
        // NOT ALLOWED!!!

        // remove element
        stringsSet.remove("Bartosz");

        // iterate
        for (String str : stringsSet)
            System.out.print(str + " ");
        System.out.println();

        // *
        System.out.println("Filtered ==================================");
        stringsSet.stream().filter(e -> !e.startsWith("A")).forEach(System.out::println);
    }
}
