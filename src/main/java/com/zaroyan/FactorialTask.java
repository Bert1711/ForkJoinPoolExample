package com.zaroyan;
import java.util.concurrent.RecursiveTask;

/**
 * @author Zaroyan
 */


public class FactorialTask extends RecursiveTask<Long> {
    private final int n;

    public FactorialTask(int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (n <= 1) {
            return 1L;
        } else {
            FactorialTask subtask = new FactorialTask(n - 1);
            subtask.fork();
            return n * subtask.join();
        }
    }
}






