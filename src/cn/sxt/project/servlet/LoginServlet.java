package cn.sxt.project.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sxt.project.dao.AdminDao;
import cn.sxt.project.dao.imp.AdminDaoImpl;
import cn.sxt.project.entity.Admin;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		byte[] bytes;
		try {
			//将乱码的字符串转换成在网络上传输的原始字节数组
			bytes = username.getBytes("iso-8859-1");
			//将原始的字节数组按照UTF-8转换成字符串
			username = new String(bytes,"utf-8");
		}catch (UnsupportedEncodingException e) {
				e.printStackTrace();
		}
			
		req.getSession().setAttribute("username", username);
		String pwd = req.getParameter("pwd");
		String remember = req.getParameter("remember"); 
		AdminDao adminDao = new AdminDaoImpl();
		Admin admin = adminDao.findAdmin(username, pwd);
		System.out.println(admin);
		boolean flag = false;
		if (admin!=null) {
			flag=true;
		}
		if(flag){
			String cusername = URLEncoder.encode(username, "utf-8");
			Cookie cookieName = new Cookie("username", cusername);
			Cookie cookiePwd = new Cookie("pwd", pwd);
			Cookie cookieRemember = new Cookie("remember", remember);
			//范围
			if ("yes".equals(remember)) {
				cookieName.setMaxAge(60*60*24*10);
				cookiePwd.setMaxAge(60*60*24*10);
				cookieRemember.setMaxAge(60*60*24*10);
			}
			cookieName.setPath("/LXProject/");
			cookiePwd.setPath("/LXProject/");
			cookieRemember.setPath("/LXProject/");
			//添加到cookie
			resp.addCookie(cookieName);
			resp.addCookie(cookiePwd);
			resp.addCookie(cookieRemember);
			//跳转
			resp.sendRedirect("/LXProject/admin2/MyJsp.jsp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
