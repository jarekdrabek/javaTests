package com.company.order.promotion;

import com.company.ShoppingList;

public class MoreThan10ItemsPromotion implements Promotion {
	@Override
	public long calculate(final ShoppingList shoppingList) {
		if (shoppingList.amount() > 10) return 100L;
		return 0;
	}
}
