package com.cognizant.truyum.service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemServiceTest {

	MenuItemService menuItemService;

	@Before
	public void initializeService() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.cognizant.truyum");
		context.refresh();
		menuItemService = context.getBean(MenuItemService.class);

	}

	@Test
	public void testGetMenuItemListAdminSize() {
		int actualsize = menuItemService.getMenuItemListAdmin().size();
		int expectedsize = 5;
		assertTrue(Integer.compare(actualsize, expectedsize) == 0 ? true : false);
	}

	@Test
	public void testGetMenuItemListAdminContainsSandwich() {
		List<MenuItem> menu = menuItemService.getMenuItemListAdmin();
		MenuItem menuItem = null;
		for (MenuItem m : menu) {
			String name = m.getName();
			if (name.equals("Sandwich")) {
				menuItem = m;
			}
		}
		assertEquals(menuItem.getName(), "Sandwich");
	}

	@Test
	public void testGetMenuItemListCustomerSize() throws ParseException {
		int actualsize = menuItemService.getMenuItemListCustomer().size();
		int expectedsize = 3;
		assertTrue(Integer.compare(actualsize, expectedsize) == 0 ? true : false);
	}

	@Test
	public void testGetMenuItemListCustomerNotContainsFrenchFries() throws ParseException {
		List<MenuItem> menu = menuItemService.getMenuItemListCustomer();
		String name2 = null;
		for (MenuItem m : menu) {
			String name = m.getName();
			if (name.equals("French Fries")) {
				name2 = name;
			}
		}
		assertNotEquals(name2, "French Fries", "Item Not Exists");
	}

	@Test
	public void testGetMenuItem() {
		MenuItem item = menuItemService.getMenuItem(2);
		assertNotNull("Valid Menu Item", item);
	}

}