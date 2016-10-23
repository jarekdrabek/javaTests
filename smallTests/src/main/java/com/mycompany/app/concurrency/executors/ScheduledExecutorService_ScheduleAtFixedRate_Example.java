package com.mycompany.app.concurrency.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorService_ScheduleAtFixedRate_Example {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
                System.out.println("Task finished");
        };

        executor.scheduleAtFixedRate(task, 3, 1, TimeUnit.SECONDS);
    }
}
