package com.mycompany.app.concurrency.executors;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.*;

public class ExecutorInvokeAnyExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newWorkStealingPool();
        System.out.println("Program start");
        Collection<Callable<String>> callables = Arrays.asList(
                () -> {
                    TimeUnit.SECONDS.sleep(2);
                    return "task1";
                },
                () -> {
                    TimeUnit.SECONDS.sleep(1);
                    return "task2";
                }
        );

        String result = executor.invokeAny(callables);
        System.out.println("Result: "+result);

    }

}
