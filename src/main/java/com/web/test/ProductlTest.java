package com.web.test;

import org.junit.jupiter.api.Test;

import com.web.dao.ProductDao;
import com.web.dao.daoImpl.ProductDaoImpl;
import com.web.model.Product;

public class ProductlTest {

	private ProductDao productDao;

	public ProductlTest() {
		productDao = new ProductDaoImpl();
	}

	@Test
	public void testCreate() {
		productDao.create(new Product("productName", "productImage", "productDesc", 100, 2));
	}

	@Test
	public void testReadAll() {
		System.out.println(productDao.readAll());
	}

	@Test
	public void testReadById() {
		System.out.println(productDao.readById("1"));
	}

	@Test
	public void testReadByType() {
		System.out.println(productDao.readByType("1"));
	}

	@Test
	public void testReadByKeyword() {
		System.out.println(productDao.readByKeyword("pro"));
	}

	@Test
	public void testReadByTypeAndKeyword() {
		System.out.println(productDao.readByTypeAndKeyword("1", "2"));
	}

	@Test
	public void update() {
		productDao.update(new Product(7, "productName2", "productImage2", "productDesc2", 200, 1));
	}

	@Test
	public void delete() {
		productDao.delete(7);
	}

}
