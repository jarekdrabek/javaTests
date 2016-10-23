package com.mycompany.app.concurrency;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.*;

public class ExecutorInvokeAllExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();
        System.out.println("Program start");
        Collection<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3",
                () -> {
                    TimeUnit.SECONDS.sleep(2);
                    return "task4";
                },
                () -> "task5",
                () -> "task6",
                () -> "task7"
        );

        executor.invokeAll(callables)
            .stream()
            .map(future -> {
                try {
                    return future.get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new IllegalStateException(e);
                }
            })
            .forEach(System.out::println);

    }
}
