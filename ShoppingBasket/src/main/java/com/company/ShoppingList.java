package com.company;

import com.company.order.item.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class ShoppingList {
	private static List<Item> PRODUCTS_TYPES_PREDICATES = new ImmutableList.Builder<Item>()
			.add(new Banana())
			.add(new Apple())
			.add(new Melon())
			.add(new Lime())
			.build();

	private Map<Class,Integer> amounts = Maps.newHashMap();
	private List<Item> objects = Lists.newArrayList();

	public ShoppingList(final List<String> shoppingList) {
		for(final String item : shoppingList){
			List<Item> candidates = PRODUCTS_TYPES_PREDICATES.stream()
					.filter(predicate -> predicate.test(item))
					.collect(toList());
			if(candidates.size()>1) throw new IllegalStateException("Name matches two items");
			if(candidates.size()==0) throw new IllegalStateException("No matches found for name '"+item+"'");
			objects.add(candidates.get(0));
			incrementAmount(candidates.get(0).getClass());
		}
	}

	public List<Item> items(){
		return objects;
	}

	public Map<Class,Integer> amounts(){
		return amounts;
	}

	public int amount() {
		return objects.size();
	}

	private void incrementAmount(Class itemClass){
		if(amounts.get(itemClass)==null){
			amounts.put(itemClass,1);
		} else {
			Integer newAmount = amounts.get(itemClass);
			newAmount++;
			amounts.put(itemClass, newAmount);
		}
	}
}
