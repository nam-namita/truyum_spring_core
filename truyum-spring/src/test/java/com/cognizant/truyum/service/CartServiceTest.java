package com.cognizant.truyum.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public class CartServiceTest {

	CartService cartService;

	@Before
	public void initializeService() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.cognizant.truyum");
		context.refresh();
		cartService = context.getBean(CartService.class);
	}

	@Test(expected = CartEmptyException.class)
	public void testGetCartItemThrowsExceptionEmptyCart() throws CartEmptyException {

		cartService.getAllCartItems(1);

	}

	@Test(expected = CartEmptyException.class)
	public void testAddItemCheck() throws CartEmptyException, ParseException {
		boolean isSandwich = false;
		for (MenuItem item : cartService.getAllCartItems(1)) {
			if (item.getName().equalsIgnoreCase("Sandwich")) {
				isSandwich = true;
			}
		}
		assertFalse(isSandwich);
		isSandwich = false;
		cartService.addCartItem(1, 1);
		for (MenuItem item : cartService.getAllCartItems(1)) {
			if (item.getName().equalsIgnoreCase("Sandwich")) {
				isSandwich = true;
			}
		}
		assertTrue(isSandwich);
	}

	@Test
	public void testRemoveCartItem() throws CartEmptyException, ParseException {
		boolean isSandwich = false;
		for (MenuItem item : cartService.getAllCartItems(2)) {
			if (item.getName().equalsIgnoreCase("Sandwich")) {
				isSandwich = true;
			}
		}
		assertTrue(isSandwich);

		cartService.addCartItem(2, 1);
		isSandwich = false;
		for (MenuItem item : cartService.getAllCartItems(2)) {
			if (item.getName().equalsIgnoreCase("Sandwich")) {
				isSandwich = true;
			}
		}
		assertFalse(isSandwich);
	}
}
