package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;
import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {

	public List<MenuItem> getMenuItemListAdmin();

	public List<MenuItem> getMenuItemListCustomer() throws ParseException;

	public void modifyMenuItem(MenuItem menuItem);

	public MenuItem getMenuItem(long menuItemId);
}