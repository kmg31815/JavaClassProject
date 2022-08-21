package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.UserDao;
import com.web.dao.daoImpl.UserDaoImpl;
import com.web.model.User;

@WebServlet("/signUpServlet")
public class SignUpServlet extends HttpServlet {

	private UserDao userDao;

	public SignUpServlet() {
		userDao = new UserDaoImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		System.out.println("username: " + username + "\tuserpass: " + userpass);

		User user = new User(username, userpass);
		userDao.create(user);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
