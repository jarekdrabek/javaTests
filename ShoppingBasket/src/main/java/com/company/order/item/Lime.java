package com.company.order.item;

public class Lime implements Item {

	public boolean test(final String itemName) {
		return itemName.equals("Lime");
	}

	public long price(){
		return 15;
	}
}
