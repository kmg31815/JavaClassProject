package com.web.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.dao.TypeDao;
import com.web.model.ProductType;
import com.web.utils.DBConnection;

public class TypeDaoImpl implements TypeDao {

	private DBConnection db;
	private Connection conn;
	private PreparedStatement ps; // 預防注入攻擊
	private ResultSet rs;

	public TypeDaoImpl() {
		db = DBConnection.getDBConnection();
	}

	@Override
	public void create(ProductType productType) {

	}

	@Override
	public List<ProductType> readAll() {
		List<ProductType> productTypes = new ArrayList<ProductType>();
		String sql = "select * from type";
		conn = db.getConnection();

		try {
			ps = conn.prepareStatement(sql);
			boolean isFirstResultSet = ps.execute();

			if (isFirstResultSet) {
				rs = ps.getResultSet();
				while (rs.next()) {
					ProductType productType = new ProductType();
					productType.setTypeId(rs.getInt("id"));
					productType.setTypeName(rs.getString("name"));
					productTypes.add(productType);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(ps);
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
