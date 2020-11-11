package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

@Service("menuItemService")
@Component
public class MenuItemService implements MenuItemDao {

	@Autowired
	private MenuItemDao menuItemDao;

	public MenuItemDao getMenuItemDao() {
		return menuItemDao;

	}

	public void setMenuItemDao(MenuItemDao menuItemDao) {

		this.menuItemDao = menuItemDao;
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		ApplicationContext xml = new ClassPathXmlApplicationContext("spring-config.xml");
		menuItemDao = (MenuItemDao) xml.getBean("menuItems");
		return menuItemDao.getMenuItemListAdmin();
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		ApplicationContext xml = new ClassPathXmlApplicationContext("spring-config.xml");
		menuItemDao = (MenuItemDao) xml.getBean("menuItems");
		return menuItemDao.getMenuItemListCustomer();
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		ApplicationContext xml = new ClassPathXmlApplicationContext("spring-config.xml");
		menuItemDao = (MenuItemDao) xml.getBean("menuItems");
		return menuItemDao.getMenuItem(menuItemId);
	}

	public void editMenuItem(MenuItem menuItem) {
		ApplicationContext xml = new ClassPathXmlApplicationContext("spring-config.xml");
		menuItemDao = (MenuItemDao) xml.getBean("menuItems");
		MenuItemDaoCollectionImpl item = new MenuItemDaoCollectionImpl();
		item.modifyMenuItem(menuItem);
	}

}
