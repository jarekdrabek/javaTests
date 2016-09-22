package com.company.order.promotion;

import com.company.ShoppingList;
import com.company.order.item.Melon;

public class MelonsPromotion implements Promotion {
	@Override
	public long calculate(final ShoppingList shoppingList) {
		Integer amountOfMelons = shoppingList.amounts().get(Melon.class);
		if (amountOfMelons == null) return 0;
		return new Melon().price() * (amountOfMelons / 2L);
	}
}
