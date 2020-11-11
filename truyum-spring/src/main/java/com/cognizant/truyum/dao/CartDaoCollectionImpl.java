package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.*;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {

	private static Map<Long, Cart> userCarts;

	public CartDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<Long, Cart>();
		}
	}

	public static Map<Long, Cart> getUserCarts() {
		return userCarts;
	}

	public static void setUserCarts(Map<Long, Cart> userCarts) {
		CartDaoCollectionImpl.userCarts = userCarts;
	}

	@Override
	public List<MenuItem> getAllCartItems(long userid) throws CartEmptyException {

		Cart cart = userCarts.get(userid);
		List<MenuItem> menuItemList = cart.getMenuItemList();
		if (menuItemList.isEmpty()) {
			throw new CartEmptyException("Cart is empty");
		} else {
			double total = 0.0;
			for (MenuItem menuItem : menuItemList) {
				total = total + menuItem.getPrice();

			}
			cart.setTotal(total);

		}

		return menuItemList;
	}

	@Override
	public void addCartItem(long userId, long menuItemId) throws ParseException {

		// List<MenuItem> menuItemList;
		// MenuItemDaoCollectionImpl menuItemDaoCollectionImpl = new
		// MenuItemDaoCollectionImpl();
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();

		// @SuppressWarnings("deprecation")
		// Long userId = new Long(userid);
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);

		if (userCarts.containsKey(userId)) {
			// Cart cart = userCarts.get(userId);
			// menuItemList = cart.getMenuItemList();
			List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
			menuItemList.add(menuItem);
			userCarts.get(userId).setMenuItemList(menuItemList);
			// cart.setMenuItemList(menuItemList);
			// cart.setTotal(cart.getTotal() + menuItem.getPrice());
			// userCarts.put(userId, cart);

		} else {
			List<MenuItem> menuItemList = new ArrayList<>();
			// menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(menuItem);
			Cart cart = new Cart(menuItemList);
			// Cart cart = new Cart(menuItemList, menuItem.getPrice());
			userCarts.put(userId, cart);

		}

	}

	@Override
	public void removeCartItem(long userId, long menuitemid) {
		Cart cart = userCarts.get(userId);
		ListIterator<MenuItem> iterator = cart.getMenuItemList().listIterator();
		while (iterator.hasNext()) {
			if (iterator.next().getId() == menuitemid) {
				iterator.remove();
			}
		}

	}

}