package com.web.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.dao.UserDao;
import com.web.model.User;
import com.web.utils.DBConnection;

public class UserDaoImpl implements UserDao {

	private DBConnection db;
	private Connection conn;
	private PreparedStatement ps; // 預防注入攻擊
	private ResultSet rs;

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

	@Override
	public User readByUser(User user) {
		User user2 = null;
		String sql = "select * from user where name = ? AND password = ?";
		conn = db.getConnection();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			boolean isFirstResultSet = ps.execute();

			if (isFirstResultSet) {
				rs = ps.getResultSet();
				while (rs.next()) {
					user2 = new User();
					user2.setUserName(rs.getString("name"));
					user2.setPassword(rs.getString("password"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(ps);
			db.close(conn);
		}

		return user2;
	}

	@Override
	public User readByName(String name) {
		User user = null;
		String sql = "select * from user where name = ?";
		conn = db.getConnection();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			boolean isFirstResultSet = ps.execute();

			if (isFirstResultSet) {
				rs = ps.getResultSet();
				while (rs.next()) {
					user = new User(rs.getString("name"), rs.getString("password"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(ps);
			db.close(conn);
		}

		return user;
	}

}
