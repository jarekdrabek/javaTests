package com.mycompany.app.concurrency;

public class DoubleCheckLockingSingleton {

    public static void main( String[] args )
    {
        for(int i=0;i<10;i++){
            new Thread(new MyRunnable()).start();
        }

    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        VolatileExample.getInstance();
    }
}

class VolatileExample {

    private static volatile VolatileExample _instance;

    public static VolatileExample getInstance(){
        if(_instance==null){
            synchronized (VolatileExample.class){
                if(_instance==null){
                    System.out.println(String.format("Thread: %s , Instance is null ",Thread.currentThread().getName()));
                    _instance = new VolatileExample();
                }
            }
        }
        System.out.println(String.format("Thread: %s , Instance is created ",Thread.currentThread().getName()));
        return _instance;
    }

    private VolatileExample() {
    }

}