package com.company.order.item;

public class Banana implements Item {

	public boolean test(final String itemName) {
		return itemName.equals("Banana");
	}

	public long price(){
		return 20;
	}
}
