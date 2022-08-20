package com.web.test;

import org.junit.jupiter.api.Test;

import com.web.dao.ProductDao;
import com.web.dao.daoImpl.ProductDaoImpl;
import com.web.model.Product;

public class ProductDaoImplTest {

	private ProductDao productDao;

	public ProductDaoImplTest() {
		productDao = new ProductDaoImpl();
	}

	@Test
	public void testCreate() {
		productDao.create(new Product("productName", "productImage", "productDesc", 100, 2));
	}

	@Test
	public void testReadAll() {
		productDao.readAll();
	}

	@Test
	public void testReadByType() {
		productDao.readByType("1");
	}

	@Test
	public void testReadByKeyword() {
		productDao.readByKeyword("pro");
	}

	@Test
	public void testReadByTypeAndKeyword() {
		productDao.readByTypeAndKeyword("1", "2");
	}

	@Test
	public void update() {
		productDao.update(new Product(4, "productName2", "productImage2", "productDesc2", 200, 1));
	}

	@Test
	public void delete() {
		productDao.delete(4);
	}

}
