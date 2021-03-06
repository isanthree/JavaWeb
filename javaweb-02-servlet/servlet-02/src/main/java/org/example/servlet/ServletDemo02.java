package org.example.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo02 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("进入了 ServletDemo02......");

		ServletContext context = getServletContext();
//		RequestDispatcher requestDispatcher = context.getRequestDispatcher("/gp");  // 转发的请求路径
//		requestDispatcher.forward(req, resp);  // 调用 forward 实现请求转发
		// 上面两句合并为下面一句：
		context.getRequestDispatcher("/gp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
