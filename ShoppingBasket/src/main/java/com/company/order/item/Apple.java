package com.company.order.item;

public class Apple implements Item {

	public boolean test(final String itemName) {
		return itemName.equals("Apple");
	}

	public long price(){
		return 35;
	}
}
