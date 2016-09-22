package com.company.order;

import com.company.ShoppingList;
import com.company.order.item.Item;

import java.util.List;

public class Basket {

	private List<Item> items;

	private Basket(final ShoppingList shoppingList) {
		this.items = shoppingList.items();
	}

	public static Basket of(final ShoppingList shoppingList){
		return new Basket(shoppingList);
	}

	public long value(){
		long basketValue = 0;
		for(Item item : items){
			basketValue+=item.price();
		}
		return basketValue;
	}

}
