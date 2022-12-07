package com.javafee.java.lessons.lesson4;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj ilość wprowadzanych Stringów");
        int n = scan.nextInt();
//        ArrayList<String> arrayList = new ArrayList<>();
//        for (int i = 0; i <= n; i++)
//            arrayList.add(scan.nextLine());
//
//        arrayList.forEach(System.out::println);
//
//        for (int i = arrayList.size() - 1; i > 0; i--)
//            System.out.println(arrayList.get(i));
//
//        Set<String> listSet = new HashSet<>();
//
//        for (int i = 0; i < arrayList.size(); i++)
//            listSet.add(arrayList.get(i));
//
//        for (String s: listSet) {
//            System.out.println(s);
//        }

//        Map<Integer, String> listMap = new HashMap<>();
//
//        for (int i = 0; i < n; i++) {
//            listMap.put(i, scan.nextLine());
//        }
//
//        for (Map.Entry<Integer, String> entry : listMap.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }


        Map<String, Double> listMap = new HashMap<>();
        Double salary = 0.0;
        String name = "";

        for (int i = 0; i < n; i++) {
            salary = scan.nextDouble();
            name = scan.next();
            listMap.put(name, salary);
        }

        for (Map.Entry<String, Double> entry : listMap.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());

        Double sumOfSalaries = 0.0;
        for (Double salar: listMap.values()) {
            sumOfSalaries += salar.doubleValue();
        }
        System.out.println("Srednia " + sumOfSalaries / listMap.size());

        Double minSalary = 0.0, maxSalary = 0.0;
        int index = 0;
        for (Double salary2: listMap.values()) {
            if(index == 0) {
                minSalary = salary2.doubleValue();
                maxSalary = salary2.doubleValue();
            }
            if (salary2.doubleValue() < minSalary ) {
                minSalary = salary2.doubleValue();
            }
            if (salary2.doubleValue() > maxSalary ) {
                maxSalary = salary2.doubleValue();
            }
            index++;
        }

        System.out.println("Min " + minSalary + " Max" + " " + maxSalary);



    }
}

