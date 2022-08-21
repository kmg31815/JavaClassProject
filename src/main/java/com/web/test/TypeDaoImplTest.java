package com.web.test;

import org.junit.jupiter.api.Test;

import com.web.dao.TypeDao;
import com.web.dao.daoImpl.TypeDaoImpl;

public class TypeDaoImplTest {

	private TypeDao typeDao;

	public TypeDaoImplTest() {
		typeDao = new TypeDaoImpl();
	}

	@Test
	public void testReadAll() {
		typeDao.readAll();
	}

}
