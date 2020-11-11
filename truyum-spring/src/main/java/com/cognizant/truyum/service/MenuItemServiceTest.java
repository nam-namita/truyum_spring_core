package com.cognizant.truyum.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MenuItemServiceTest {
	private MenuItemService menuItemService;

	public MenuItemService getMenuItemService() {
		return menuItemService;
	}

	public void setMenuItemService(MenuItemService menuItemService) {
		this.menuItemService = menuItemService;
	}

	@Before
	public void initializeService() {
		ApplicationContext context = new AnnotationConfigApplicationContext();
		((AnnotationConfigApplicationContext) context).scan("com.cognizant.truyum");
		((AnnotationConfigApplicationContext) context).refresh();
		menuItemService = (MenuItemService) context.getBean("menuItemService");
	}

	@Test
	public void testGetMenuItemListAdminSize() {
		assertTrue(menuItemService.getMenuItemListAdmin().size() == 5);
	}

}
