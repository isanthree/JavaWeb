package org.example.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 统计网站在线人数：统计 session
 */
public class OnlineCountListener implements HttpSessionListener {
	// 创建 session 监听：看你的一举一动
	// 一旦创建 session，就会触发一次这个事件
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext ctx = se.getSession().getServletContext();  // 拿到上下文
		System.out.println(se.getSession().getId());  // 获取 session ID
		Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");  // 获取 OnlineCount 对象

		if (onlineCount == null) {
			onlineCount = new Integer(1);
		} else {
			int count = onlineCount.intValue();

			onlineCount = new Integer(count + 1);
		}
		ctx.setAttribute("OnlineCount", onlineCount);
	}

	// 销毁 session 监听
	// 一旦销毁 session，会触发这个事件
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext ctx = se.getSession().getServletContext();
		Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");

		if (onlineCount == null) {
			onlineCount = new Integer(0);
		} else {
			int count = onlineCount.intValue();

			onlineCount = new Integer(count - 1);
		}
		ctx.setAttribute("OnlineCount", onlineCount);
	}
}
