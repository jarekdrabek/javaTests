package com.company.order.item;

public class Melon implements Item {

	public boolean test(final String itemName) {
		return itemName.equals("Melon");
	}

	public long price(){
		return 50;
	}
}
