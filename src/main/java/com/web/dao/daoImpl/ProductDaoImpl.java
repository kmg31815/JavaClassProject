package com.web.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.web.dao.ProductDao;
import com.web.model.Product;
import com.web.utils.DBConnection;

public class ProductDaoImpl implements ProductDao {

	private DBConnection db;
	private Connection conn;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;

	public ProductDaoImpl() {
		db = DBConnection.getDBConnection();
	}

	@Override
	public void create(Product product) {

	}

	@Override
	public ArrayList<Product> readAll() {
		ArrayList<Product> products = new ArrayList();
		String sql = "select * from product";

		try {
			conn = db.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);

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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(st);
			db.close(conn);
		}

		return products;
	}

	@Override
	public ArrayList<Product> readByType(int typeId) {
		ArrayList<Product> products = new ArrayList();
		String sql = "select * from product where type_id = " + typeId;

		try {
			conn = db.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);

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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(st);
			db.close(conn);
		}

		return products;
	}

	@Override
	public ArrayList<Product> readByKeyword(String keyword) {
		return null;
	}

	@Override
	public ArrayList<Product> readByTypeAndKeyword(int typeId, String keyword) {
		return null;
	}

	@Override
	public void update(Product product) {

	}

	@Override
	public void delete(int id) {

	}

}
