package com.web.dao;

import java.util.ArrayList;

import com.web.model.Product;

public interface ProductDao {

	public void create(Product product);

	public ArrayList<Product> readAll();

	public ArrayList<Product> readByType(int typeId);

	public ArrayList<Product> readByKeyword(String keyword);

	public ArrayList<Product> readByTypeAndKeyword(int typeId, String keyword);

	public void update(Product product);

	public void delete(int id);

}
