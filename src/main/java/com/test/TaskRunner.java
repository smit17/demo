package com.test;

/**
 * Created by Smit on 3/13/16.
 */
public class TaskRunner implements Runnable {
    private int taskNo;

    public TaskRunner(int taskNo) {
        this.taskNo = taskNo;
    }

    public void run() {
        System.out.println(
                "Thread " + Thread.currentThread() + " finished running task " + this.taskNo);
    }
}
