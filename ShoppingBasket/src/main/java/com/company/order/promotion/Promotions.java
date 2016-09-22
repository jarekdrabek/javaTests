package com.company.order.promotion;

import com.company.ShoppingList;
import com.google.common.collect.Lists;

import java.util.List;

public class Promotions {
	private static List<Promotion> PROMOTIONS = Lists.newArrayList(new MelonsPromotion(), new LimesPromotion(), new MoreThan10ItemsPromotion());
	private ShoppingList shoppingList;

	private Promotions(ShoppingList shoppingList) {
		this.shoppingList = shoppingList;
	}

	public static Promotions ffor(ShoppingList shoppingList){
		return new Promotions(shoppingList);
	}

	public long calculate() {
		return PROMOTIONS.stream()
				.mapToLong(promotion -> promotion.calculate(shoppingList))
				.sum();
	}
}
