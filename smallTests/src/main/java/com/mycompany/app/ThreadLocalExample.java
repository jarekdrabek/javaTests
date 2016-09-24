package com.mycompany.app;

import java.util.Random;

public class ThreadLocalExample {

    public static void main(String[] args) {

        IntegerIncrement integerIncrement = new IntegerIncrement();
        ThreadLocalIncrement threadLocalIncrement = new ThreadLocalIncrement();

        new Thread(new MyRunnable(integerIncrement, threadLocalIncrement)).start();
        new Thread(new MyRunnable(integerIncrement, threadLocalIncrement)).start();
    }

    static class ThreadLocalIncrement implements Increment {
        private ThreadLocal<Integer> value = new ThreadLocal();

        @Override
        public Integer incrementAndGet() {
            Integer val = this.value.get();
            if(val == null){
                val = 1;
            } else {
                val++;
            }
            this.value.set(val);
            return val;
        }
    }

    static class IntegerIncrement implements Increment {

        private Integer value = new Integer(0);

        @Override
        public Integer incrementAndGet() {
            return ++value;
        }
    }

    static class MyRunnable implements Runnable {

        private Increment[] increments;

        public MyRunnable(Increment ... increments) {
            this.increments = increments;
        }

        @Override
        public void run() {
            for(int i=0; i<10 ; i++){
                waitRandomTime();
                logMessage(incrementAndGetValues());
            }
        }

        private void waitRandomTime() {
            try {
                Thread.sleep(new Random().nextInt(15)*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private String incrementAndGetValues(){
            StringBuilder outputString  = new StringBuilder("");
            for(Increment inc : increments){
                outputString.append(String.format("%s: %s   ", inc.getClass().getSimpleName(), inc.incrementAndGet()));
            }
            return outputString.toString();
        }
        private void logMessage(String msg) {
            System.out.println("MyThread: Name:" + Thread.currentThread().getName() + "-> Message: " + msg);
        }

    }

    interface Increment {
        Integer incrementAndGet();
    }
}
