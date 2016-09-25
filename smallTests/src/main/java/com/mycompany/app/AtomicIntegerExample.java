package com.mycompany.app;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

    public static void main(String[] args) {

        IntegerValues values = new IntegerValues();
        new MyThread(values).start();
        new MyThread(values).start();
    }

    static class IntegerValues {
        AtomicInteger value1 = new AtomicInteger(0);
        Integer value2 = new Integer(0);

        public void incrementAndPrint() {
            System.out.println(String.format("Atomic: %s   Regular: %s", value1.incrementAndGet(), ++value2));
        }
    }

    static class MyThread extends Thread {

        private IntegerValues integerValues;

        public MyThread(IntegerValues integerValues1) {
            this.integerValues = integerValues1;
        }

        @Override
        public void run() {
            for(int i=0;i<200000;i++)
                integerValues.incrementAndPrint();
        }
    }

}
