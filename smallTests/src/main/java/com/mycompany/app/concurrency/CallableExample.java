package com.mycompany.app.concurrency;

import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> task = () -> {
            System.out.println("Executing callable");
            TimeUnit.SECONDS.sleep(4);
            return 123;
        };

        Future<Integer> taskResult = Executors.newSingleThreadExecutor().submit(task);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Do we have result? :"+ taskResult.isDone());
        Integer result = taskResult.get();
        System.out.println("Do we have result? :"+ taskResult.isDone());
        System.out.println("Result:"+result);
        System.out.println("Program finished");
    }
}
