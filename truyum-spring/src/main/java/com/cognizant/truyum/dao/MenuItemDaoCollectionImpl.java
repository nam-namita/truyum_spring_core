package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@Component
@ImportResource("classpath:spring-config.xml")
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	@Autowired
	private ArrayList<MenuItem> menuItemList;

	public ArrayList<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(ArrayList<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public ArrayList<MenuItem> getMenuItemListAdmin() {

		return menuItemList;
	}

	public ArrayList<MenuItem> getMenuItemListCustomer() throws ParseException {
		ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
		//DateUtil d = new DateUtil();
		for (MenuItem m : menuItemList) {
			if (m.isActive() == true && (m.getDateOfLaunch().before(DateUtil.convertToDate("19/08/2019")))) {
				menu.add(m);
			}
		}
		return menu;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {

		for (MenuItem m : menuItemList) {
			if (m.getId() == (menuItem.getId())) {
				m.setId(menuItem.getId());
				m.setName(menuItem.getName());
				m.setCategory(menuItem.getCategory());
				m.setPrice(menuItem.getPrice());
				m.setActive(menuItem.isActive());
				m.setDateOfLaunch(menuItem.getDateOfLaunch());
			}
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menu = null;
		for (MenuItem m : menuItemList) {
			if (m.getId() == menuItemId) {
				menu = m;
				break;
			}
		}
		return menu;
	}
}