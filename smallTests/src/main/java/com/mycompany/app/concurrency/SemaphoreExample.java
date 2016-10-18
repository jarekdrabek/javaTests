package com.mycompany.app.concurrency;


import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static final int PERMITS = 4;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(PERMITS);
        new Thread(new Producer(semaphore)).start();
        new Thread(new Consumer(semaphore)).start();
    }

    static class Producer implements Runnable {

        private Semaphore semaphore;

        public Producer(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    semaphore.acquire();
                    Thread.sleep(500);
                    System.out.println(String.format("%s: Semaphore acquired. Item produced. (semaphor size:%s)",Thread.currentThread().getName(), PERMITS-semaphore.availablePermits()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {

        private Semaphore semaphore;

        public Consumer(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(1000);
                    semaphore.release();
                    System.out.println(String.format("%s: Semaphore released. Item consumed.  (semaphor size:%s)",Thread.currentThread().getName(), PERMITS-semaphore.availablePermits()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
