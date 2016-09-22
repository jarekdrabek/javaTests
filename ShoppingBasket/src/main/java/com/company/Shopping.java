package com.company;

import com.company.order.*;
import com.company.order.promotion.*;

import java.util.List;

public class Shopping {


	public double getPriceOf(List<String> itemsToBuy){
		ShoppingList shoppingList = new ShoppingList(itemsToBuy);

		long priceOfBasket = Basket.of(shoppingList).value();
		double discounts = Promotions.ffor(shoppingList).calculate();

		return priceOfBasket - discounts;
	}

}




