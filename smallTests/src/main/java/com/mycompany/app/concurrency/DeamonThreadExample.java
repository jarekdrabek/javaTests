package com.mycompany.app.concurrency;

public class DeamonThreadExample {

    private static class DeamonThread extends Thread {
        public DeamonThread() {
            setDaemon(true);
        }

        @Override
        public void run() {
            while(true) {
                System.out.println("I'm DEAMON thread. I'm still working.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class RegularThread extends Thread {

        @Override
        public void run() {
            int counter=0;
            while(counter<10) {
                try {
                    System.out.println("I'm regular thread. I'm still working.");
                    Thread.sleep(500);
                    counter++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("RegularThread finished");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new DeamonThread().start();
        new RegularThread().start();
//        Thread.sleep(2000);
        System.out.println("Main thread finished");
    }

}
