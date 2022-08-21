package com.web.test;

import org.junit.jupiter.api.Test;

import com.web.dao.UserDao;
import com.web.dao.daoImpl.UserDaoImpl;
import com.web.model.User;

public class UserTest {

	private UserDao userDao;

	public UserTest() {
		userDao = new UserDaoImpl();
	}

	@Test
	public void create() {
		userDao.create(new User("name1", "pass1"));
	}

	@Test
	public void readByUser() {
		System.out.println(userDao.readByUser(new User("name1", "pass1")));
	}

	@Test
	public void readByName() {
		System.out.println(userDao.readByName("sherry"));
	}

}
