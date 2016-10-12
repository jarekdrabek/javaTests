package com.mycompany.app.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) {
        new Thread(new MyFinalRunnable()).start();
        new Thread(new MyInitialRunnable()).start();
        new Thread(new MyInitialRunnable()).start();
        new Thread(new MyInitialRunnable()).start();
    }

    static class MyInitialRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(String.format("%s : I am done!", Thread.currentThread().getName()));
            countDownLatch.countDown();
        }
    }

    static class MyFinalRunnable implements Runnable {

        @Override
        public void run() {
            try {
                countDownLatch.await();
                System.out.println(String.format("%s : I am final one and I am done!", Thread.currentThread().getName()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
