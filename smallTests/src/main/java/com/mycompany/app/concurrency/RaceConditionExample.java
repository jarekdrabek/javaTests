package com.mycompany.app.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class RaceConditionExample {

    private static class MyCounter {
        private int value;
        public void increment(){
            ++value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main( String[] args ) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        MyCounter counter = new MyCounter();

        IntStream.range(0,10000)
                .forEach(i -> executorService.submit(counter::increment));

        ConcurrencyUtils.stop(executorService);

        System.out.println();
        System.out.println("Hello World!"+counter.getValue());
    }
}
