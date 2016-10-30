package com.mycompany.app.concurrency.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

import static com.mycompany.app.concurrency.ConcurrencyUtils.sleep;

public class ReadWriteLockExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Map<String, String> map = new HashMap<>();

        ReadWriteLock lock = new ReentrantReadWriteLock();

        executorService.submit(() -> {
            IntStream.range(0,100)
                    .forEach(i -> {
                        try{
                            lock.writeLock().lock(); //comment theese line to see what happened without
                            System.out.println(String.format("Writing %s to map", i));
                            sleep(2);
                            map.put("key", "val"+i);

                        } finally {
                            lock.writeLock().unlock(); //comment theese line to see what happened without
                        }
                        sleep(4);
                    });
        });

        Runnable readTask = () -> {
            while(true){
                try {
                    lock.readLock().lock();  //comment theese line to see what happened without
                    sleep(100, TimeUnit.MILLISECONDS);
                    System.out.println(String.format("key=%s", map.get("key")));
                } finally {
                    lock.readLock().unlock(); //comment theese line to see what happened without
                }
            }
        };

        executorService.submit(readTask);
        executorService.submit(readTask);


    }
}
