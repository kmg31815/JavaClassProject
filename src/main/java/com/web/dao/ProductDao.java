package com.web.dao;

import java.util.List;

import com.web.model.Product;

public interface ProductDao {

	public void create(Product product);

	public List<Product> readAll();

	public Product readById(String id);

	public List<Product> readByType(String typeId);

	public List<Product> readByKeyword(String keyword);

	public List<Product> readByTypeAndKeyword(String typeId, String keyword);

	public void update(Product product);

	public void delete(int id);

}
