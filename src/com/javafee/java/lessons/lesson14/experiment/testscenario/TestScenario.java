package com.javafee.java.lessons.lesson14.experiment.testscenario;

import com.javafee.java.lessons.lesson14.experiment.testcase.TestCase;

public class TestScenario implements Runnable {
    private TestCase testCase;
    private long noOfExecutions;

    public TestScenario(TestCase testCase, long noOfExecutions) {
        this.testCase = testCase;
        this.noOfExecutions = noOfExecutions;
    }

    public void run() {
        long startTime = System.nanoTime();
        for (long i = 0; i < noOfExecutions; i++)
            testCase.run();
        String[] name = Thread.currentThread().getName().split("-");
        System.out.println(name[0] + "," + (Integer.parseInt(name[1]) % 2 == 0 ? "min" : "max") + "," + (System.nanoTime() - startTime));
    }
}
