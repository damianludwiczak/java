package com.javafee.java.lessons.lesson14;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class Model {
    private View view;
    public Model() {
        view = new View();
    }
    public void init() throws IOException {
        view.getFrame().setVisible(true);
        view.getButtonAccept().addActionListener(e -> {
            try {
                calculateByUserInput();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        view.getButtonConfirm().addActionListener(e -> {
            try {
                calculateByStep();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void calculateByStep() throws IOException {
        try {
            Integer arrFrom = Integer.valueOf(view.getTextFieldArrayRangeFrom().getText()),
                    arrTo = Integer.valueOf(view.getTextFieldArrayRangeTo().getText()),
                    step = Integer.valueOf(view.getTextFieldStep().getText()),
                    iterationAmount = Integer.valueOf(view.gettextFieldIterationAmountByStep().getText()),
                    amountIndexesToRemove = Integer.valueOf(view.getTextFieldAmountIndexesToRemove().getText());
            Random random = new Random();

            long solution = 0, solution2 = 0, solution3 = 0;
            for (;arrFrom <= arrTo; arrFrom += step) {
                int[] arr = prepareInputData(arrFrom, 0, 1000);
                String indexesToRemove = prepareIndexesToRemove(0, arrFrom, amountIndexesToRemove);
                for (int i = 0; i < iterationAmount; i++) {
                    solution += deleteIndexes(arr, indexesToRemove);
                    solution2 += deleteIndexes2(arr, indexesToRemove);
                    solution3 += deleteIndexes3(arr, indexesToRemove);
                }
                Path path = Path.of("data_byStep.csv");
                if (Files.size(path) == 0)
                    Files.writeString(path, "Array length,Iteration Amount,Amount Indexes to remove,Solution 1,Solution2,Solution3" + "\n");
                String example = arrFrom + "," + iterationAmount + "," + amountIndexesToRemove;

                Files.writeString(path, example + "," + solution / iterationAmount + "," +
                        solution2 / iterationAmount + "," + solution3 / iterationAmount + "\n", StandardOpenOption.APPEND);
                solution = 0; solution2 = 0; solution3 = 0;
            }
        } catch (NumberFormatException e) {
            View.displayPopup("Invalid input", "Error", JOptionPane.ERROR_MESSAGE, view.getFrame());
        }
    }

    public void calculateByUserInput() throws IOException {
        try {
            Integer arrRangeMin = Integer.valueOf(view.getTextFieldArrayRangeMin().getText()),
                    arrRangeMax = Integer.valueOf(view.getTextFieldArrayRangeMax().getText()),
                    arrayLength = Integer.valueOf(view.getTextFieldArrayLength().getText()),
                    indexesAmount = Integer.valueOf(view.getTextFieldIndexesAmount().getText()),
                    indexesRangeMin = Integer.valueOf(view.getTextFieldIndexesRangeMin().getText()),
                    indexesRangeMax = Integer.valueOf(view.getTextFieldIndexesRangeMax().getText()),
                    iterationAmount = Integer.valueOf(view.getTextFieldIterationAmount().getText());

            // setup input data
            // generate input array of length
            // generate indexes array of length
            // perform logic multiply times
            
            long solution = 0, solution2 = 0, solution3 = 0;
            for (int i = 0; i < iterationAmount; i++) {
                int[] arr = prepareInputData(arrayLength, arrRangeMin, arrRangeMax);
                String indexesToRemove = prepareIndexesToRemove(indexesRangeMin, indexesRangeMax, indexesAmount);

                solution += deleteIndexes(arr, indexesToRemove);
                solution2 += deleteIndexes2(arr, indexesToRemove);
                solution3 += deleteIndexes3(arr, indexesToRemove);
            }
            Path path = Path.of("data_byUserInput.csv");
            if (Files.size(path) == 0)
                Files.writeString(path, "Array length,Arr From,Arr to,Indexes amount,Indexes from," +
                        "Indexes to,Solution1,Solution2,Solution3,Iteration amount" + "\n");
            String example = arrayLength + "," + arrRangeMin + "," + arrRangeMax + "," + indexesAmount + "," +
                    indexesRangeMin + "," + indexesRangeMax + "," + iterationAmount;

            Files.writeString(path, example + "," + solution / iterationAmount + "," +
                    solution2 / iterationAmount + "," + solution3 / iterationAmount + "\n", StandardOpenOption.APPEND);
            solution = 0; solution2 = 0; solution3 = 0;
        } catch (NumberFormatException e) {
            View.displayPopup("Invalid input", "Error", JOptionPane.ERROR_MESSAGE, view.getFrame());
        }
    }

    private int[] prepareInputData(int length, int arrRangeMin, int arrRangeMax) {
        Random random = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = random.nextInt(arrRangeMin, arrRangeMax);
        return arr;
    }

    private String prepareIndexesToRemove(Integer indexesRangeMin, Integer indexesRangeMax, Integer indexesQuantity) {
        Random random = new Random();
        String indexesToRemove = ",";
        int index = 0;
        int i = 0;
        while (i < indexesQuantity) {
            index = random.nextInt(indexesRangeMin, indexesRangeMax);
            if (!indexesToRemove.contains(String.valueOf(index))) {
                indexesToRemove += index + ",";
                i++;
            }
        }
        return indexesToRemove;
    }

    private long deleteIndexes(int[] arr, String indexesToRemoveStr) {
        long startTime = System.nanoTime();
        int[] res = new int[arr.length - (indexesToRemoveStr.split(",").length - 1)];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (indexesToRemoveStr.equals(",")) {
                for (int j = i; j < arr.length; j++) {
                    res[k] = arr[j];
                    k++;
                }
                break;
            } else {
                if (!indexesToRemoveStr.contains("," + i + ",")) {
                    res[k] = arr[i];
                    k++;
                } else
                    indexesToRemoveStr = indexesToRemoveStr.replaceAll("," + i + ",", ",");
            }
        }
        return System.nanoTime() - startTime;
    }

    private long deleteIndexes2(int[] arr, String indexesToRemoveStr) {
        long startTime = System.nanoTime();
        int[] res = new int[arr.length - (indexesToRemoveStr.split(",").length - 1)];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (indexesToRemoveStr.equals(",")) {
                res[k] = arr[i];
                k++;
            } else {
                if (!indexesToRemoveStr.contains("," + i + ",")) {
                    res[k] = arr[i];
                    k++;
                } else
                    indexesToRemoveStr = indexesToRemoveStr.replaceAll("," + i + ",", ",");
            }
        }
        return System.nanoTime() - startTime;
    }

    private long deleteIndexes3(int[] arr, String indexesToRemoveStr) {
        long startTime = System.nanoTime();
        int[] res = new int[arr.length - (indexesToRemoveStr.split(",").length - 1)];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (indexesToRemoveStr.equals(",")) {
                for (int j = i; j < arr.length; j++) {
                    res[k] = arr[j];
                    k++;
                }
                break;
            } else {
                if (!indexesToRemoveStr.contains("," + i + ",")) {
                    res[k] = arr[i];
                    k++;
                } else
                    indexesToRemoveStr = indexesToRemoveStr.replaceAll("," + i + ",", ",");
            }
        }
        return System.nanoTime() - startTime;
    }
}
