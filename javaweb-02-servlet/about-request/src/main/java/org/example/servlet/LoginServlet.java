package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.util.Arrays;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String[] hobbies = req.getParameterValues("hobby");

		System.out.println("================== 分割线 =====================");

		System.out.println(username);
		System.out.println(password);
		System.out.println(Arrays.toString(hobbies));

		System.out.println("================== 分割线 =====================");

		// 通过请求转发
		req.getRequestDispatcher("/success.jsp").forward(req, resp);  // 这里的 '/' 代表当前的 web 应用

//		resp.sendRedirect("/success.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
