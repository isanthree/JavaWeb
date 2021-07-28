package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 实现从浏览器中下载图片
 */
public class FileServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.获取下载文件的路径
		String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/pikaqiu.jpg");
		// 2.下载的文件名是啥？
		String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);

		System.out.println("realPath: " + realPath);
		System.out.println("fileName: " + fileName);
		System.out.println("contextPath: " + this.getServletContext().getContextPath());

		// 3.设置浏览器能够支持（content-disposition）下载我们需要的东西
		resp.setHeader("content-disposition", "attachment;filename=" +
				URLEncoder.encode(fileName, "UTF-8"));  // 转码，避免中文乱码问题

		// 4.获取下载文件的输入流
		FileInputStream fis = new FileInputStream(realPath);

		// 5.获取 OutputStream 对象
		ServletOutputStream os = resp.getOutputStream();

		// 6.创建缓冲区
		int len;
		byte[] flush = new byte[1024];

		// 7.将 FileInputStream 流写入到 buffer 缓冲区，
		//   使用 OutputStream 将缓冲区中的数据输出到客户端
		while ((len = fis.read(flush)) != -1) {
			os.write(flush, 0, len);
		}

		os.close();
		fis.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
