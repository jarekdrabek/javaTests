package com.mycompany.app.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new MyFinalRunnable());

    public static void main(String[] args) throws InterruptedException {
        new Thread(new OneOfSeveralRunnable()).start();
        new Thread(new OneOfSeveralRunnable()).start();
        new Thread(new OneOfSeveralRunnable()).start();
    }

    static class OneOfSeveralRunnable implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println(String.format("%s : I am regular one and before await!", Thread.currentThread().getName()));
                cyclicBarrier.await();
                System.out.println(String.format("%s : I am done!", Thread.currentThread().getName()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyFinalRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(String.format("%s : All parties had passed, let's start!!!", Thread.currentThread().getName()));
        }
    }

}
