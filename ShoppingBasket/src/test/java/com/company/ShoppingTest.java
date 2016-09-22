package com.company;


import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

public class ShoppingTest {

	@Test
	public void should_calculate_one_apple_properly(){
		assertThat(new Shopping().getPriceOf(Lists.newArrayList("Apple"))).isEqualTo(35);
	}

	@Test
	public void should_calculate_one_banana_properly(){
		assertThat(new Shopping().getPriceOf(Lists.newArrayList("Banana"))).isEqualTo(20);
	}

	@Test
	public void should_calculate_one_melon_properly(){
		assertThat(new Shopping().getPriceOf(Lists.newArrayList("Melon"))).isEqualTo(50);
	}

	@Test
	public void should_calculate_one_lime_properly(){
		assertThat(new Shopping().getPriceOf(Lists.newArrayList("Lime"))).isEqualTo(15);
	}

	@Test
	public void empty_basket_should_cost_zero(){
		assertThat(new Shopping().getPriceOf(Collections.<String>emptyList())).isEqualTo(0.0);
	}

	@Test
	public void should_get_one_melon_free_when_get_first_one(){
		assertThat(new Shopping().getPriceOf(Lists.newArrayList("Melon","Melon"))).isEqualTo(50);
	}

	@Test
	public void should_get_one_melon_free_when_get_three(){
		assertThat(new Shopping().getPriceOf(Lists.newArrayList("Melon","Melon","Melon","Melon"))).isEqualTo(100);
	}

	@Test
	public void should_get_two_melons_free_when_get_four(){
		assertThat(new Shopping().getPriceOf(Lists.newArrayList("Melon","Melon","Melon"))).isEqualTo(100);
	}

	@Test
	public void should_get_one_lime_free_when_get_three(){
		assertThat(new Shopping().getPriceOf(Lists.newArrayList("Lime","Lime","Lime"))).isEqualTo(30);
	}

	@Test
	public void should_get_one_lime_free_when_get_five(){
		assertThat(new Shopping().getPriceOf(Lists.newArrayList("Lime","Lime","Lime","Lime","Lime"))).isEqualTo(60);
	}

	@Test
	public void should_get_two_lime_free_when_get_six(){
		assertThat(new Shopping().getPriceOf(Lists.newArrayList("Lime","Lime","Lime","Lime","Lime","Lime"))).isEqualTo(60);
	}

	@Test
	public void should_get_one_lime_free_and_one_melon_free(){
		assertThat(new Shopping().getPriceOf(Lists.newArrayList("Lime","Lime","Lime","Melon","Melon"))).isEqualTo(80);
	}

	@Test
	public void should_get_100p_discount_when_you_get_11_items(){
		assertThat(new Shopping().getPriceOf(Lists.newArrayList("Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple"))).isEqualTo(285);
	}

	@Test
	public void should_not_get_100p_discount_when_you_get_10_items(){
		assertThat(new Shopping().getPriceOf(Lists.newArrayList("Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple"))).isEqualTo(350);
	}



}