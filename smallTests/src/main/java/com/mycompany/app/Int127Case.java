package com.mycompany.app;

public class Int127Case {
    public static void main( String[] args ) {
        Integer a = 10;
        Integer b = 10;
        System.out.println(a==b);
        System.out.println(a.equals(b));

        Integer c = 1000;
        Integer d = 1000;
        System.out.println(c==d);
        System.out.println(c.equals(d));
    }
}
