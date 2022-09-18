package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.UserDao;
import com.web.dao.daoImpl.UserDaoImpl;
import com.web.model.User;
import com.web.utils.LoginUtil;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	private UserDao userDao;
	private LoginUtil loginUtil;

	public LoginServlet() {
		userDao = new UserDaoImpl();
		loginUtil = new LoginUtil();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		User user = new User(username, userpass);

		// 驗證user是否在DB
		if (userDao.readByUser(user) != null) {
			// 產token
			String token = loginUtil.generateJsonWebToken(user);
			System.out.println("LoginServlet\t" + token);
			// 存token
			request.getSession().setAttribute("token", token);
		} else {
			request.getSession().setAttribute("loginfail", true);
		}

		// 導回專案根目錄
		response.sendRedirect(request.getContextPath());
	}

}
