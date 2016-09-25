package com.mycompany.app;

public class Int127Case {
//    http://stackoverflow.com/questions/1700081/why-does-128-128-return-false-but-127-127-return-true-when-converting-to-integ
    public static void main( String[] args ) { //From -128 to 127   look into Integer.valueOf implementation
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
