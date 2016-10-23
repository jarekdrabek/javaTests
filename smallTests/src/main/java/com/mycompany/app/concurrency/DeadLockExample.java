package com.mycompany.app.concurrency;

import java.util.concurrent.TimeUnit;

public class DeadLockExample {

    public static void main(String[] args) {
        MyObject myObject1 = new MyObject(1);
        MyObject myObject2 = new MyObject(2);

        new ThreadOne(myObject1, myObject2).start();
        new ThreadTwo(myObject1, myObject2).start();
    }

    static private class ThreadOne extends Thread{
        MyObject object1;
        MyObject object2;

        public ThreadOne(MyObject object1, MyObject object2) {
            this.object1 = object1;
            this.object2 = object2;
        }

        @Override
        public void run() {
            try {
                synchronized (object1){
                    System.out.println(Thread.currentThread().getName()+": first synchronized block");
                    object1.changeValue(4);
                    TimeUnit.SECONDS.sleep(0);
                    synchronized (object2){
                        System.out.println(Thread.currentThread().getName()+": second synchronized block");
                        object2.changeValue(4);
                    }
                }
            } catch (InterruptedException e) {
                System.err.println("InterruptedException occured");
            }
        }

    }

    static private class ThreadTwo extends Thread{
        MyObject object1;
        MyObject object2;

        public ThreadTwo(MyObject object1, MyObject object2) {
            this.object1 = object1;
            this.object2 = object2;
        }

        @Override
        public void run() {
            try {
                synchronized (object2){
                    System.out.println(Thread.currentThread().getName()+": first synchronized block");
                    object1.changeValue(4);
                    TimeUnit.SECONDS.sleep(2);
                    synchronized (object1){
                        System.out.println(Thread.currentThread().getName()+": second synchronized block");
                        object2.changeValue(4);
                    }
                }
            } catch (InterruptedException e) {
                System.err.println("InterruptedException occured");
            }
        }

    }




    static private class MyObject {

        private int value;

        public MyObject(int value) {
            this.value = value;
        }

        synchronized void changeValue(int newValue){
            this.value = newValue;
        }

    }
}
