package com.mycompany.app;

import com.beust.jcommander.internal.Lists;
import com.google.common.primitives.Chars;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Interlace {
    ArrayList<Character> interlacedArray = new ArrayList();

    public int interlace(int number1, int number2) {
        String string1 = String.valueOf(number1);
        String string2 = String.valueOf(number2);

        LinkedList<Character> linkedlist1 = Lists.newLinkedList(Chars.asList(string1.toCharArray()));
        LinkedList<Character> linkedlist2 = Lists.newLinkedList(Chars.asList(string2.toCharArray()));

        int resultsize = linkedlist1.size() + linkedlist2.size() / 2 + 1;
        System.out.println("size:" + resultsize);
        for (int i = 0; i < resultsize; i++) {
            addToArrayIfNotNull(linkedlist1.poll());
            addToArrayIfNotNull(linkedlist2.poll());
        }
        String interlacedString = String.valueOf(Chars.toArray(interlacedArray));
        return Integer.valueOf(interlacedString);
    }

    private void addToArrayIfNotNull(Character character) {
        if (character != null) {
            interlacedArray.add(character);
        }
    }

    public static void main(String[] args) {
        int[] array = {
                0b10111111,
                0b1101,
                0xF,
                0b11 << 2,
                0b11111111 >> 1,
                0b11111111,
                0b10111010 >> 4,
                0b10111010 >>> 4,
                0b10111111
        };
        for (int a : array) {
            System.out.println(a);
        }

        System.out.println("Thread!! Name:" + Thread.currentThread().getName());
        new MyThread().start();
        new MyThread().start();

    }

    static class MyThread extends Thread {

        public static final int NUM = 10;
        ThreadLocal<Integer> value = new ThreadLocal<>();
        Integer globalValue = 1;

        public MyThread() {
            value.set(0);
        }

        @Override
        public void run() {
            value.set(0);
            for (int i = 0; i < NUM; i++) {
                value.set(value.get()+1);
                globalValue++;
                logMessage("VALUE: "+value.get() + " GLOBAL: " +globalValue);
                try {
                    Thread.sleep(new Random().nextInt(10)*100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void logMessage(String msg) {
            System.out.println("MyThread: Name:" + Thread.currentThread().getName() + "-> Message: " + msg);
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("MyRunnable!! Name:" + Thread.currentThread().getName());
        }
    }

}

