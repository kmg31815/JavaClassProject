package com.web.dao;

import com.web.model.User;

public interface UserDao {

	public void create(User productType);

	public User readByUser(User user);

	public User readByName(String name);

}
