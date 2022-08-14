package com.web.dao;

import java.util.ArrayList;

import com.web.model.ProductType;

public interface TypeDao {

	public void create(ProductType productType);

	public ArrayList<ProductType> readAll();

	public void update(ProductType productType);

	public void delete(int id);

}
