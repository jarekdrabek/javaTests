package com.company;

import com.google.common.collect.Lists;

import java.util.ArrayList;

public class App
{
    public static void main( String[] args ) {
        ArrayList<String> itemsToBuy = Lists.newArrayList("Banana", "Apple", "Mellon", "Lime", "Melon");
        System.out.println("The price of products "+itemsToBuy+" is "+new Shopping().getPriceOf(itemsToBuy));
    }
}
