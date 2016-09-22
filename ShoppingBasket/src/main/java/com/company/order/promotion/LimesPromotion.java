package com.company.order.promotion;

import com.company.ShoppingList;
import com.company.order.item.Lime;

public class LimesPromotion implements Promotion {
	@Override
	public long calculate(final ShoppingList shoppingList) {
		Integer amountOfLimes = shoppingList.amounts().get(Lime.class);
		if (amountOfLimes == null) return 0L;
		return new Lime().price() * (amountOfLimes / 3L);
	}
}
