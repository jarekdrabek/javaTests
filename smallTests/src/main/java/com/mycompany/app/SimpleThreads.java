package com.mycompany.app;

import java.util.Random;

public class SimpleThreads {
    public static void main(String[] args) {
        System.out.println("Thread!! Name:" + Thread.currentThread().getName());
        new MyThread().start();
        new MyThread().start();

        new Thread(() -> {
            System.out.println("BleBle");
        }).start();
    }

    static class MyThread extends Thread {

        public static final int NUM = 10;
        ThreadLocal<Integer> value = new ThreadLocal<>();
        Integer globalValue = 1;

        public MyThread() {
            value.set(0);
        }

        @Override
        public void run() {
            value.set(0);
            for (int i = 0; i < NUM; i++) {
                value.set(value.get()+1);
                globalValue++;
                logMessage("VALUE: "+value.get() + " GLOBAL: " +globalValue);
                try {
                    Thread.sleep(new Random().nextInt(10)*100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void logMessage(String msg) {
            System.out.println("MyThread: Name:" + Thread.currentThread().getName() + "-> Message: " + msg);
        }
    }


    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("MyRunnable!! Name:" + Thread.currentThread().getName());
        }
    }
}
