package com.mycompany.app;

public class BinaryLiterals {
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
    }
}
