package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.ProductDao;
import com.web.dao.daoImpl.ProductDaoImpl;
import com.web.model.Product;

@WebServlet("/buyProduct")
public class BuyProductServlet extends HttpServlet {

	private ProductDao productDao;

	public BuyProductServlet() {
		productDao = new ProductDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String buyProductId = request.getParameter("buy_product_id");
		Product buyProduct = productDao.readById(buyProductId);

		List<Product> buyProducts = (List<Product>) request.getSession().getAttribute("buyProducts");
		buyProducts.add(buyProduct);
		request.getSession().setAttribute("buyProducts", buyProducts);

		// 每次一進首頁顯示所有商品
		List<Product> products = productDao.readAll();
		request.setAttribute("products", products);

		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
