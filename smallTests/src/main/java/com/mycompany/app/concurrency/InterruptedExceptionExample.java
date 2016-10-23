package com.mycompany.app.concurrency;

import java.util.concurrent.TimeUnit;

public class InterruptedExceptionExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println(String.format("Thread %s Started", Thread.currentThread().getName()));
                TimeUnit.SECONDS.sleep(5);
                System.out.println(String.format("Thread %s FINISHED", Thread.currentThread().getName()));
            } catch (InterruptedException e) {
                System.out.println(String.format("Thread %s Interrupted", Thread.currentThread().getName()));
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        thread.interrupt();
    }
}
