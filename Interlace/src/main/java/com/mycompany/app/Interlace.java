package com.mycompany.app;

import com.beust.jcommander.internal.Lists;
import com.google.common.primitives.Chars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

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

}

