package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static CartDao cartDao = new CartDaoCollectionImpl();

	public static void main(String[] args) throws CartEmptyException, ParseException {

		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
	}

	public static void testAddCartItem() throws ParseException {

		// CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 1);
		try {
			List<MenuItem> cartItemList = cartDao.getAllCartItems(1);
			cartItemList.forEach(System.out::println);
		} catch (CartEmptyException e) {

			// e.printStackTrace();
		}

	}

	public static void testGetAllCartItems() {

		List<MenuItem> menuItemList;
		try {
			menuItemList = cartDao.getAllCartItems(1);
		} catch (CartEmptyException e) {
			// e.printStackTrace();
			return;
		}
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	public static void testRemoveCartItem() {
		cartDao.removeCartItem(1, 1);
		List<MenuItem> cartItemList;
		try {
			cartItemList = cartDao.getAllCartItems(1);
			cartItemList.forEach(System.out::println);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

}