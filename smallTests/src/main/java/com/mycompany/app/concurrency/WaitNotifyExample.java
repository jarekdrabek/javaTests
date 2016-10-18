package com.mycompany.app.concurrency;

import java.util.LinkedList;

public class WaitNotifyExample {

    public static void main(String[] args) {
        LinkedList<String> sharedList = new LinkedList();
        new Thread(new Producer(sharedList)).start();
        new Thread(new Consumer(sharedList)).start();
    }

    static class Producer implements Runnable {
        private int SIZE = 5;
        private LinkedList<String> sharedList;

        public Producer(LinkedList<String> sharedList) {
            this.sharedList = sharedList;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 20; i++) {
                    synchronized (sharedList) {
                        if (sharedList.size() >= SIZE) {
                            sharedList.wait();
                        }
                        String productName = "Product" + i;
                        sharedList.push(productName);
                        System.out.println(String.format("%s: Item %s produced.", Thread.currentThread().getName(), productName));
                        Thread.sleep(100);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {

        private LinkedList<String> sharedList;

        public Consumer(LinkedList<String> sharedList) {
            this.sharedList = sharedList;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (sharedList) {
                        if (!sharedList.isEmpty()) {
                            String productName = sharedList.pollLast();
                            System.out.println(String.format("%s: Item %s consumed.", Thread.currentThread().getName(), productName));
                            sharedList.notify();
                        }
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


