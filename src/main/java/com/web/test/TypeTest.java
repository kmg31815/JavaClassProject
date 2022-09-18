package com.web.test;

import org.junit.jupiter.api.Test;

import com.web.dao.TypeDao;
import com.web.dao.daoImpl.TypeDaoImpl;

public class TypeTest {

	private TypeDao typeDao;

	public TypeTest() {
		typeDao = new TypeDaoImpl();
	}

	@Test
	public void testReadAll() {
		System.out.println(typeDao.readAll());
	}

}
