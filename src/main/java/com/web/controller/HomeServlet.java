package com.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.dao.ProductDao;
import com.web.dao.TypeDao;
import com.web.dao.daoImpl.ProductDaoImpl;
import com.web.dao.daoImpl.TypeDaoImpl;
import com.web.model.Product;
import com.web.model.ProductType;

public class HomeServlet extends HttpServlet {

	private TypeDao typeDao;
	private ProductDao productDao;

	public HomeServlet() {
		typeDao = new TypeDaoImpl();
		productDao = new ProductDaoImpl();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 每次一進首頁要拿下拉選單(之後可能會新增，要刷新)
		List<ProductType> typeList = typeDao.readAll();
		HttpSession session = request.getSession();
		session.setAttribute("typeList", typeList); // 在當前瀏覽器中都拿的到

		// 每次一進首頁顯示所有商品
		List<Product> products = productDao.readAll();
		request.setAttribute("products", products);

		// 購物車 list 先準備好
		List<Product> buyProducts = new ArrayList<Product>();
		request.getSession().setAttribute("buyProducts", buyProducts);

		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
