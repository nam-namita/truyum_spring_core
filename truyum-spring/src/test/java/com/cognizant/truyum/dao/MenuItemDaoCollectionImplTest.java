package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionImplTest {

	public static void main(String[] args) throws ParseException {
		System.out.println("Menu List Admin Printing...");
		testGetMenuItemListAdmin();
		System.out.println("Menu List Customer Printing...");
		testGetMenuListCustomer();
		System.out.println("Modified Menu and Printing to check...");
		testModifyMenuItem();
		System.out.println("Completed.");
	}

	static void testGetMenuItemListAdmin() throws ParseException {

		MenuItemDaoCollectionImpl menuItemDaoCollectionImpl = new MenuItemDaoCollectionImpl();

		List<MenuItem> menuItems = menuItemDaoCollectionImpl.getMenuItemListAdmin();

		for (MenuItem menuItem : menuItems) {

			System.out.println(menuItem.toString());

		}

	}

	static void testGetMenuListCustomer() throws ParseException {
		MenuItemDaoCollectionImpl menuItemDaoCollectionImpl = new MenuItemDaoCollectionImpl();

		List<MenuItem> menuItems = menuItemDaoCollectionImpl.getMenuItemListCustomer();

		for (MenuItem menuItem : menuItems) {

			System.out.println(menuItem.toString());

		}

	}

	static void testModifyMenuItem() throws ParseException {

		MenuItem menuItem = new MenuItem();
		MenuItemDaoCollectionImpl menuItemDaoCollectionImpl = new MenuItemDaoCollectionImpl();
		MenuItemDao menuItemDao = menuItemDaoCollectionImpl;
		menuItemDao.modifyMenuItem(menuItem);
		System.out.println("Modified MenuItem details are :" + menuItemDao.getMenuItem(000002));

	}

	void testGetMenuItem() {

	}

}