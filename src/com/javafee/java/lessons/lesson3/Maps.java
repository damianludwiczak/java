package com.javafee.java.lessons.lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Maps {
    public static void main(String[] args) {
        Map<Integer, String> stringsMap = new HashMap<>();

        // add element
        stringsMap.put(1, "Ania");
        stringsMap.put(2, "Bartosz");
        stringsMap.put(3, "Cecylia");
        stringsMap.put(4, "Cecylia");
        stringsMap.put(5, "Cecylia");
        stringsMap.put(5, "Cecylia");
        stringsMap.put(6, "Hieronim");
        stringsMap.put(6, "Gusław");
        stringsMap.put(6, "Jadwiga");
        stringsMap.put(7, "Hryzostom");
        stringsMap.put(7, "Hryzostom");
        stringsMap.put(8, "Hryzostom");

        // size
        System.out.println(stringsMap.size());

        // add element to index
        // NOT ALLOWED!!!

        // get element
        // NOT ALLOWED!!!
        String str = stringsMap.get(3);

        // remove element
        //stringsSet.remove("Bartosz");
        stringsMap.remove(2);

        // iterate
//        for (String str : stringsSet)
//            System.out.print(str + " ");
//        System.out.println();
        for (String name : stringsMap.values())
            System.out.print(name);

        for (Integer key : stringsMap.keySet())
            System.out.println(stringsMap.get(key));

        for (Map.Entry<Integer, String> entry : stringsMap.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());

        // *
//        System.out.println("Filtered ==================================");
//        stringsSet.stream().filter(e -> !e.startsWith("A")).forEach(System.out::println);
    }
}
