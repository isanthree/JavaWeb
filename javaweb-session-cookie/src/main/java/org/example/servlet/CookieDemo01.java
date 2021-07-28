package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookieDemo01 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
//		resp.setCharacterEncoding("utf-8");  // 不知道为什么加了这个语句还是乱码
		resp.setHeader("Content-type", "text/html;charset=UTF-8");

		PrintWriter out = resp.getWriter();

		// Cookie，服务器端从客户端获取
		Cookie[] cookies = req.getCookies();  // 这里返回数组，说明 Cookie 可能存在多个

		// 判断 Cookie 是否存在
		if (cookies != null) {
			// 存在
			out.write("你上一次访问的时间是：");

			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				// 获取 cookie 的名字
				if (cookie.getName().equals("lastLoginTime")) {
					// 获取 cookie 中的值
					long lastLoginTime = Long.parseLong(cookie.getValue());
					Date date = new Date(lastLoginTime);
					out.write(date.toLocaleString());
				}
			}
		} else {
			out.print("您好！这是您第一次访问本网站！");
		}

		// 服务器给客户端响应一个 cookie（新建一个 cookie）
		Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis() + "");
		cookie.setMaxAge(24 * 60 * 60);  // 设置 cookie 有效期为一天
		resp.addCookie(cookie);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doGet(req, resp);
	}
}
