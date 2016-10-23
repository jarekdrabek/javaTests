package com.mycompany.app.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorShutdownExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            try {
                System.out.println(String.format("Thread %s Started", Thread.currentThread().getName()));
                TimeUnit.SECONDS.sleep(1);
                System.out.println(String.format("Thread %s Finished", Thread.currentThread().getName()));
            } catch (InterruptedException e) {
                System.out.println(String.format("Thread %s Interrupted", Thread.currentThread().getName()));
            }
        });
//        executorService.shutdownNow();
        executorService.shutdown();
    }
}
