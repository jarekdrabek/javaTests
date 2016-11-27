package com.mycompany.app.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueExample {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(5);
        new Thread(new Producer(blockingQueue)).start();
        new Thread(new Consumer(blockingQueue)).start();
    }

    static class Producer implements Runnable {

        private BlockingQueue<String> blockingQueue;

        public Producer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            for(int i=0;i<20;i++){
                try {
                    Thread.sleep(100);
                    String productName = String.format("Produkt%s", i);
                    blockingQueue.put(productName);
                    System.out.println(String.format("%s: Item %s produced.",Thread.currentThread().getName(),productName));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {

        private BlockingQueue<String> blockingQueue;

        public Consumer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(500);
                    String consumedProductName = blockingQueue.take();
                    System.out.println(String.format("%s: Item %s has been consumed.",Thread.currentThread().getName(),consumedProductName));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
