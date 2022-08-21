package com.web.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.web.dao.TypeDao;
import com.web.model.ProductType;
import com.web.utils.DBConnection;

public class TypeDaoImpl implements TypeDao {

	private DBConnection db;
	private Connection conn;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;

	public TypeDaoImpl() {
		db = DBConnection.getDBConnection();
	}

	@Override
	public void create(ProductType productType) {

	}

	@Override
	public ArrayList<ProductType> readAll() {
		ArrayList<ProductType> productTypes = new ArrayList();
		try {
			conn = db.getConnection();
			st = conn.createStatement();
			String sql = "select * from type";
			rs = st.executeQuery(sql);

			while (rs.next()) {
				ProductType productType = new ProductType();
				productType.setTypeId(rs.getInt("id"));
				productType.setTypeName(rs.getString("name"));
				productTypes.add(productType);
				System.out.println(productType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(st);
			db.close(conn);
		}
		return productTypes;
	}

	@Override
	public void update(ProductType productType) {

	}

	@Override
	public void delete(int id) {

	}

}
