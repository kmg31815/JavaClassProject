package com.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.Product;
import com.web.utils.DBConnection;

@WebServlet("/readProduct")
public class ReadProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 拿 form 參數 (若為空則顯示所有資料)
		 */
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		System.out.println(type + "\t" + keyword);

		DBConnection db = DBConnection.getDBConnection();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			st = conn.createStatement();
			String sql = "";
			if (type.equals("") && keyword.equals("")) {
				sql = "select * from product";
			}
			rs = st.executeQuery(sql);

			ArrayList<Product> products = new ArrayList();
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("id"));
				product.setProductName(rs.getString("name"));
				product.setProductImage(rs.getString("image"));
				product.setProductDesc(rs.getString("description"));
				product.setProductPrice(rs.getInt("price"));
				product.setTypeId(rs.getInt("type_id"));
				products.add(product);
				System.out.println(product);
			}
			request.setAttribute("products", products);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(st);
			db.close(conn);
		}

	}

}
