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
		String sql = "select * from product";
		return readFunction(sql);
	}

	@Override
	public ArrayList<Product> readByType(int typeId) {
		String sql = "select * from product where type_id = " + typeId;
		return readFunction(sql);
	}

	@Override
	public ArrayList<Product> readByKeyword(String keyword) {
		String sql = "select * from product where name like '%" + keyword + "%'";
		return readFunction(sql);
	}

	@Override
	public ArrayList<Product> readByTypeAndKeyword(int typeId, String keyword) {
		String sql = "select * from product where type_id = " + typeId + " and name like '%" + keyword + "%'";
		return readFunction(sql);
	}

	@Override
	public void update(Product product) {

	}

	@Override
	public void delete(int id) {

	}

	private ArrayList<Product> readFunction(String sql) {
		ArrayList<Product> products = new ArrayList();

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
				System.out.println(product);
				products.add(product);
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

}
