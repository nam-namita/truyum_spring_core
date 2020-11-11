package com.cognizant.truyum.dao;

//import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

//import com.cognizant.truyum.util.DateUtil;
@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	List<MenuItem> menuItemList;

	/*
	 * public MenuItemDaoCollectionImpl() throws ParseException {
	 * 
	 * super(); if (menuItemList == null) { menuItemList = new
	 * ArrayList<MenuItem>(); menuItemList.add(new MenuItem(1, "Sandwich", 99.0f,
	 * true, new DateUtil().convertToDate("15/03/2017"), "Main Course", true));
	 * menuItemList.add(new MenuItem(2, "Burger", 129.0f, true, new
	 * DateUtil().convertToDate("23/12/2017"), "Main Course", false));
	 * menuItemList.add(new MenuItem(3, "Pizza", 149.0f, true, new
	 * DateUtil().convertToDate("21/08/2018"), "Main Course", false));
	 * menuItemList.add(new MenuItem(4, "French Fries", 57.0f, false, new
	 * DateUtil().convertToDate("02/07/2017"), "Starters", true));
	 * menuItemList.add(new MenuItem(5, "Chocolate Brownie", 32.0f, true, new
	 * DateUtil().convertToDate("02/11/2022"), "Dessert", true));
	 * 
	 * }
	 * 
	 * }
	 */
	@Override
	public List<MenuItem> getMenuItemListAdmin() {

		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {

		List<MenuItem> menuItemListCust = new ArrayList<MenuItem>();

		Date today = new Date();
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getDateOfLaunch().getTime() <= today.getTime() && menuItem.isActive()) {
				menuItemListCust.add(menuItem);
			}
		}

		return menuItemListCust;
	}

	public void modifyMenuItem(MenuItem menuItem) {

		for (MenuItem menuItemModify : menuItemList) {

			if (menuItem.getId() == menuItemModify.getId()) {

				menuItemModify.setName(menuItem.getName());
				menuItemModify.setCategory(menuItem.getCategory());
				menuItemModify.setDateOfLaunch(menuItem.getDateOfLaunch());
				menuItemModify.setFreeDelivery(menuItem.isFreeDelivery());
				menuItemModify.setPrice(menuItem.getPrice());
				menuItemModify.setActive(menuItem.isActive());
			}

		}

	}

	@Override
	public MenuItem getMenuItem(long menuitemId) {

		for (MenuItem menuItem : menuItemList) {
			if (menuitemId == menuItem.getId()) {
				return menuItem;

			}

		}
		return null;

	}

}
