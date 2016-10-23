package com.mycompany.app.concurrency.executors;

import java.util.concurrent.*;

public class ScheduledExecutorService_Schedule_Example {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        System.out.println("Program started");
        Runnable task = () -> {
            System.out.println("Task finished");
        };
        ScheduledFuture<?> result = executor.schedule(task, 3, TimeUnit.SECONDS);
        TimeUnit.MILLISECONDS.sleep(1333);
        System.out.println("DELAY IN MILLIS: "+result.getDelay(TimeUnit.MILLISECONDS));
    }

}
