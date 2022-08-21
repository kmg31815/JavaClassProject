package com.web.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.web.dao.UserDao;
import com.web.model.User;
import com.web.utils.DBConnection;

public class UserDaoImpl implements UserDao {

	private DBConnection db;
	private Connection conn;
	private PreparedStatement ps; // 預防注入攻擊

	public UserDaoImpl() {
		db = DBConnection.getDBConnection();
	}

	@Override
	public void create(User user) {
		String sql = "insert into user(name, password) value(?, ?)";
		conn = db.getConnection();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(ps);
			db.close(conn);
		}
	}

}
