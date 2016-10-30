package com.mycompany.app.concurrency.locks;

import com.mycompany.app.concurrency.ConcurrencyUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        ReentrantLock lock = new ReentrantLock();

        executor.submit(() -> {
            lock.lock();
            try{
                ConcurrencyUtils.sleep(2);
            } finally {
                lock.unlock();
            }
        });

        executor.submit(() -> {
            System.out.println("Locked: "+lock.isLocked());
            System.out.println("Held by me: "+lock.isHeldByCurrentThread());
            System.out.println("Locked: "+lock.isLocked());
            boolean free = lock.tryLock();
            System.out.println("Lock acquired: "+free);
        });

        ConcurrencyUtils.stop(executor);
    }
}
