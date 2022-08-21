package com.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.ProductDao;
import com.web.dao.daoImpl.ProductDaoImpl;
import com.web.model.Product;

@WebServlet("/readProduct")
public class ReadProductServlet extends HttpServlet {

	private ProductDao productDao;

	public ReadProductServlet() {
		productDao = new ProductDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getAttribute("user"));

		/*
		 * 拿 form 參數 (若為空則顯示所有資料)
		 */
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");

		ArrayList<Product> products = null;
		if (type.equals("") && keyword.equals("")) {
			products = productDao.readAll();
		} else if (!type.equals("") && keyword.equals("")) {
			products = productDao.readByType(type);
		} else if (type.equals("") && !keyword.equals("")) {
			products = productDao.readByKeyword(keyword);
		} else {
			products = productDao.readByTypeAndKeyword(type, keyword);
		}

		request.setAttribute("products", products);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
