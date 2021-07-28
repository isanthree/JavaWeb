package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestTest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("<%@ page contentType=\"text/html; charset=UTF-8\"  %>");  // 防止网页乱码
		resp.getWriter().println("成功进来了！");

		// 处理请求
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		System.out.println(username + " : " + password);

		// 重定向一定要注意路径问题，否则会出现 404
		resp.sendRedirect("/response/success.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
