package com.mycompany.app;

public class FinalizeExample {
    public static void main(String[] args) {
        new MyObject();
        System.gc();
    }

    static class MyObject {
        @Override
        protected void finalize() throws Throwable {
            System.out.println("Objects finalize method invocation");
        }
    }
}
