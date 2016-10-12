package com.mycompany.app.concurrency;

public class DoubleCheckLockingSingleton {

    public static void main( String[] args )
    {
        for(int i=0;i<10;i++){
            new Thread(new MyRunnable()).start();
        }

    }

    private static volatile DoubleCheckLockingSingleton _instance;

    public static DoubleCheckLockingSingleton getInstance(){
        if(_instance==null){
            synchronized (DoubleCheckLockingSingleton.class){
                if(_instance==null){
                    System.out.println(String.format("Thread: %s , Instance is null ",Thread.currentThread().getName()));
                    _instance = new DoubleCheckLockingSingleton();
                }
            }
        }
        System.out.println(String.format("Thread: %s , Instance is created ",Thread.currentThread().getName()));
        return _instance;
    }

    private DoubleCheckLockingSingleton() {
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            DoubleCheckLockingSingleton.getInstance();
        }
    }

}
