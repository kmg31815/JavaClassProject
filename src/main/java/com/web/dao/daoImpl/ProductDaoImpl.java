package com.web.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.dao.ProductDao;
import com.web.model.Product;
import com.web.utils.DBConnection;

public class ProductDaoImpl implements ProductDao {

	private DBConnection db;
	private Connection conn;
	private PreparedStatement ps; // 預防注入攻擊
	private ResultSet rs;

	public ProductDaoImpl() {
		db = DBConnection.getDBConnection();
	}

	@Override
	public void create(Product product) {
		String sql = "insert into product(name, image, description, price, type_id) value(?, ?, ?, ?, ?)";
		conn = db.getConnection();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductImage());
			ps.setString(3, product.getProductDesc());
			ps.setInt(4, product.getProductPrice());
			ps.setInt(5, product.getTypeId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(ps);
			db.close(conn);
		}
	}

	@Override
	public List<Product> readAll() {
		String sql = "select * from product";
		return readFunction(sql);
	}

	@Override
	public Product readById(String id) {
		Product product = new Product();
		String sql = "select * from product where id = ?";
		conn = db.getConnection();

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));
			boolean isFirstResultSet = ps.execute();

			if (isFirstResultSet) {
				rs = ps.getResultSet();
				while (rs.next()) {
					product.setProductId(rs.getInt("id"));
					product.setProductName(rs.getString("name"));
					product.setProductImage(rs.getString("image"));
					product.setProductDesc(rs.getString("description"));
					product.setProductPrice(rs.getInt("price"));
					product.setTypeId(rs.getInt("type_id"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(ps);
			db.close(conn);
		}

		return product;
	}

	@Override
	public List<Product> readByType(String typeId) {
		String sql = "select * from product where type_id = ?";
		return readFunction(sql, typeId);
	}

	@Override
	public List<Product> readByKeyword(String keyword) {
		String sql = "select * from product where name like ?";
		return readFunction(sql, ("%" + keyword + "%"));
	}

	@Override
	public List<Product> readByTypeAndKeyword(String typeId, String keyword) {
		String sql = "select * from product where type_id = ? and name like ?";
		return readFunction(sql, typeId, ("%" + keyword + "%"));
	}

	@Override
	public void update(Product product) {
		String sql = "update product set name = ?, image = ?, description = ?, price = ?, type_id = ? where id = ?";
		conn = db.getConnection();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductImage());
			ps.setString(3, product.getProductDesc());
			ps.setInt(4, product.getProductPrice());
			ps.setInt(5, product.getTypeId());
			ps.setInt(6, product.getProductId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(ps);
			db.close(conn);
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from product where id = ?";
		conn = db.getConnection();

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(ps);
			db.close(conn);
		}
	}

	private List<Product> readFunction(String sql, String... parameter) {
		List<Product> products = new ArrayList<Product>();
		conn = db.getConnection();

		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < parameter.length; i++) {
				ps.setString(i + 1, parameter[i]);
			}
			boolean isFirstResultSet = ps.execute();

			if (isFirstResultSet) {
				rs = ps.getResultSet();
				while (rs.next()) {
					Product product = new Product();
					product.setProductId(rs.getInt("id"));
					product.setProductName(rs.getString("name"));
					product.setProductImage(rs.getString("image"));
					product.setProductDesc(rs.getString("description"));
					product.setProductPrice(rs.getInt("price"));
					product.setTypeId(rs.getInt("type_id"));
					products.add(product);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(ps);
			db.close(conn);
		}

		return products;
	}

}
