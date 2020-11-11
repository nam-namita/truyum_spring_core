package com.cognizant.truyum.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public class CartService implements CartDao {

	@Autowired
	private CartDao cartDao;

	public CartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		ApplicationContext xml = new ClassPathXmlApplicationContext("spring-config.xml");
		cartDao = (CartDao) xml.getBean("menuItems");
		return cartDao.getAllCartItems(userId);
	}

	@Override
	public void addCartItem(long userId, long menuItemId) throws ParseException {
		ApplicationContext xml = new ClassPathXmlApplicationContext("spring-config.xml");
		cartDao = (CartDao) xml.getBean("menuItems");
		cartDao.addCartItem(userId, menuItemId);
	}

	public void removeCartItem(long userId, long menuItemId) {

		ApplicationContext xml = new ClassPathXmlApplicationContext("spring-config.xml");
		cartDao = (CartDao) xml.getBean("menuItems");
		cartDao.removeCartItem(userId, menuItemId);
	}
}
