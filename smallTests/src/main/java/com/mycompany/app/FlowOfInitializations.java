package com.mycompany.app;

public class FlowOfInitializations {

    public static void main(String[] args) {
        new A();
    }
    
}

class SuperA {

    {
        System.out.println("Initialization Block of super class");
    }

    static {
        System.out.println("Static Block of super class");
    }

    public SuperA() {
        System.out.println("Constructor of super class");
    }
}

class A extends SuperA{

    {
        System.out.println("Initialization Block of A class");
    }

    static {
        System.out.println("Static Block of A class");
    }

    public A() {
        System.out.println("Constructor of A class");
    }
}
