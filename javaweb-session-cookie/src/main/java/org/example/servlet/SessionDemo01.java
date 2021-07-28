package org.example.servlet;

import org.example.pojo.Person;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 在会话里存进信息（对象）
 */
public class SessionDemo01 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 解决乱码问题
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("Content-type", "text/html;charset=UTF-8");

		// 得到 session
		HttpSession session = req.getSession();

		// 给 session 中存东西
		session.setAttribute("name", new Person("isanthree", 2021));

		// 获取 session 的 ID
		String sessionId = session.getId();

		// 判断 session 是不是新创建的

		// 在浏览器响应信息的「笔」
		PrintWriter out = resp.getWriter();
		if (session.isNew()) {
			out.write("session 创建成功，ID 为 " + sessionId);
		} else {
			out.write("session 已经在服务器中存在了，ID 为 " + sessionId);
		}

		// session 创建的时候做了什么事情？
//		Cookie cookie = new Cookie("JSESSIONID", sessionId);
//		resp.addCookie(cookie);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doGet(req, resp);
	}
}
