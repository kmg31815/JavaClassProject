package com.web.dao;

import java.util.List;

import com.web.model.ProductType;

public interface TypeDao {

	public void create(ProductType productType);

	public List<ProductType> readAll();

	public void update(ProductType productType);

	public void delete(int id);

}
