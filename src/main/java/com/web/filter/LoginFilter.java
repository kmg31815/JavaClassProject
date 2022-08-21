package com.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.web.model.User;
import com.web.utils.LoginUtil;

@WebFilter(filterName = "/loginFilter", urlPatterns = { "/*" })
public class LoginFilter extends HttpFilter implements Filter {

	private LoginUtil loginUtil;

	public LoginFilter() {
		loginUtil = new LoginUtil();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		String token = (String) session.getAttribute("token");
		System.out.println("LoginFilter\t" + token);

		if (token != null) {
			try {
				User user = loginUtil.validateJsonWebToken(token);
				System.out.println("LoginFilter\t" + user);
				((HttpServletRequest) request).getSession().setAttribute("user", user);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		chain.doFilter(request, response);
	}

}
