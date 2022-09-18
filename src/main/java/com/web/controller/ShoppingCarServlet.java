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

@WebServlet("/shoppingCar")
public class ShoppingCarServlet extends HttpServlet {

	private ProductDao productDao;

	public ShoppingCarServlet() {
		productDao = new ProductDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String buyProductId = request.getParameter("buy_product_id");

		if (buyProductId != null && !buyProductId.equals("")) {
			List<Product> buyProducts = (List<Product>) request.getSession().getAttribute("buyProducts");
			for (int i = 0; i < buyProducts.size(); i++) {
				if (buyProducts.get(i).getProductId() == Integer.parseInt(buyProductId)) {
					buyProducts.remove(i);
					break; // 這裡跳出迴圈，才不會把所有相同商品都清掉
				}
			}
		}
		request.getRequestDispatcher("shopping_car.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
