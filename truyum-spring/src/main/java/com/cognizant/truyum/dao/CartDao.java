package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.MenuItem;

import java.text.ParseException;
import java.util.List;

public interface CartDao {
	public void addCartItem(long userId, long menuItemId) throws ParseException;

	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException;

	void removeCartItem(long userId, long menuItemId);

}
