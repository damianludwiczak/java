package com.javafee.java.lessons.lesson13;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write the program that will give the user the possibility to remove elements from array (hardcoded)
        // by provided indexes (the user coould provide 1 or more index(s) of elements to be removed) f.eg.:
        // for input array int[] arr = {12, 33, 151, 21, 67, 73, 12};
        // and provided indexes: 2, 5, 6
        // the result array should be as follows:
        // {12, 33, 21, 67 }
//        Scanner scanner = new Scanner(System.in);
//        int[] tabExample = new int[]{12, 33, 151, 21, 67, 73, 12};
//        System.out.println("Give a indexes to delete");
//        String line = scanner.nextLine();
//        String[] index = line.split(", ");
//        int[] newTab = new int[tabExample.length - index.length];
//        String[] sortIndex = new String[index.length];
//
//        for (int i = 0; i < index.length; i++) {
//            for (int j = 1; j < index.length - i; j++)
//            if (Integer.parseInt(index[j-1]) > Integer.parseInt(index[j])) {
//                //sortIndex[]
//            }
//        }
//
//        for (int i = 0; i < index.length; i++) {
//            for (int j = 0; j < tabExample.length; j++) {
//                if (j != Integer.parseInt(index[i])) {
//                    newTab[]
//                }
//            }
//        }
//
//
//        for (int i = 0; i < newTab.length; i++)
//            System.out.print(newTab[i] + ", ");
//
////        int length = 200000000;
////        int[] arr = new int[length];
////        for (int i = 0; i < length; i++)
////            arr[i] = i;
//
//
//        int[] arr = new int[]{12, 33, 151, 21, 67, 73, 12};
//        String indexesToRemoveStr = "," + new Scanner(System.in).next() + ",";
//        int[] res = new int[arr.length - (indexesToRemoveStr.split(",").length - 1)];
//        for (int i = 0, k = 0; i < arr.length; i++)
//            if (!indexesToRemoveStr.contains("," + i + ",")) {
//                res[k] = arr[i];
//                k++;
//            }
//        Arrays.stream(res).forEach(System.out::println);


        int[] arr = new int[]{12, 33, 151, 21, 67, 73, 12};
        String indexesToRemoveStr = "," + new Scanner(System.in).next() + ",";
        int[] res = new int[arr.length - (indexesToRemoveStr.split(",").length - 1)];
        for (int i = 0, k = 0; i < arr.length; i++){
            if (indexesToRemoveStr.equals(",")) {
                res[k] = arr[i];
                k++;
            } else {
                if (!indexesToRemoveStr.contains("," + i + ",")) {
                    res[k] = arr[i];
                    k++;
                } else
                    indexesToRemoveStr = indexesToRemoveStr.replaceAll("," + i, "");
            }
        }
        Arrays.stream(res).forEach(System.out::println);

        // 1. generacja zestawu testowego:
        // - spreparowanie tablicy danych
        // - spreparowanie indesków do usunięcia
        // 2. wykonanie logiki z pomiarem czasu dla zadanych danych testowych
        // 3. powielenie czynności 2. n-krotnie, gdzie n to wartość potrzebna do uzyskania wyniku uśrednionego czasu
        // wykonania operacji (redukcja szumu obserwacji związanego ze zdarzeniami systemowymi np. chwilowe obciążenie CPU)
        // 4. zapis obserwacji w pliku w ustukruryzowany sposób (dane dot. danych wejściowych + czas(y))
        // 5. wykonanie analizy, jako wynik proponuję:
        // - utworzyć rozkład normalny,
        // - dokonać analizy zależności wydajności czasowej od danych (charakterystyka wydajności optymistycznej, średniej, pesymistycznej)
        // BAJLANDO, FAJRANT, WOLNOŚĆ I ODPOCZYNEK
    }
}
